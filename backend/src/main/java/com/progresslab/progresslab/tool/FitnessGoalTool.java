package com.progresslab.progresslab.tool;

import org.springframework.stereotype.Component;

@Component
public class FitnessGoalTool {

    // Return user's fitness goal to gemini

    public String getFitnessGoal() {
        return """
                Goal Type: Weight loss
                Starting Weight: 170 lbs;
                Target Weight: 160 lbs;
                Traget loss: 10 lbs
                """;

    }
}
