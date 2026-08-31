package com.progresslab.progresslab.service;

import org.springframework.stereotype.Service;
import com.google.genai.Client;
import com.google.genai.Chat;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Part;
import com.progresslab.progresslab.tool.FitnessGoalTool;
import com.google.genai.types.Tool;
import com.google.genai.types.FunctionDeclaration;
import com.google.genai.types.FunctionCall;
import com.google.genai.types.FunctionResponse;

import java.util.Map;

@Service
public class CoachService {
    private final Client client;
    private final Chat chatSession;
    private final FitnessGoalTool fitnessGoalTool;

    public CoachService(FitnessGoalTool fitnessGoalTool) {

        this.fitnessGoalTool = fitnessGoalTool;
        this.client = new Client();

        Content systemInstruction = Content.fromParts(
                Part.fromText(
                        """
                                You are the ProgressLab AI Fitness Coach.

                                Your role is to help users:
                                - set and understand fitness goals
                                - stay consistent with workouts
                                - build sustainable nutrition habits
                                - understand body measurement progress
                                - track overall fitness progress

                                Be supportive, practical, clear, and realistic.

                                Never invent fitness records that were not provided.
                                Use ProgressLab user data when it is available.

                                Do not diagnose medical conditions or present yourself
                                as a doctor or licensed healthcare professional.
                                """));

        FunctionDeclaration getFitnessGoalDeclaration = FunctionDeclaration.builder()
                .name("getFitnessGoal")
                .description("Get the user's current saved fitness goal.")
                .build();

        Tool fitnessGoalToolDefinition = Tool.builder()
                .functionDeclarations(getFitnessGoalDeclaration)
                .build();

        GenerateContentConfig config = GenerateContentConfig.builder()
                .systemInstruction(systemInstruction)
                .tools(fitnessGoalToolDefinition)
                .build();

        this.chatSession = client.chats.create(
                "gemini-3.6-flash",
                config);
    }

    public String sendMessage(String userMessage) {

        GenerateContentResponse response = chatSession.sendMessage(userMessage);

        FunctionCall functionCall = response.functionCalls()
                .stream()
                .findFirst()
                .orElse(null);

        if (functionCall != null) {

            String functionName = functionCall.name().orElse("");

            if (functionName.equals("getFitnessGoal")) {

                String toolResult = fitnessGoalTool.getFitnessGoal();

                FunctionResponse.Builder functionResponseBuilder = FunctionResponse.builder()
                        .name(functionName)
                        .response(
                                Map.of(
                                        "result",
                                        toolResult));

                functionCall.id().ifPresent(
                        functionResponseBuilder::id);

                FunctionResponse functionResponse = functionResponseBuilder.build();

                Part functionResponsePart = Part.builder()
                        .functionResponse(functionResponse)
                        .build();

                Content toolResponseContent = Content.fromParts(functionResponsePart);

                GenerateContentResponse finalResponse = chatSession.sendMessage(toolResponseContent);

                return finalResponse.text();
            }
        }

        return response.text();
    }
}
