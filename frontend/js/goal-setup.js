const goalCards = document.querySelectorAll(".goal-card");
const continueButton = document.querySelector(".continue-button");
const goalMessage = document.querySelector("#goalMessage");
const goalSelectionStep = document.querySelector("#goalSelectionStep");
const loseWeightStep = document.querySelector("#loseWeightStep");

let selectedGoal = null;
goalCards.forEach(function (card) {
    card.addEventListener("click", function () {
        //Remove slection for every goal card
        goalCards.forEach(function (goalCard) {
            goalCard.classList.remove("selected");
        })

        //Select the card the user just clicked
        card.classList.add("selected");

        //remember which goal was seleted 
        selectedGoal = card.dataset.goal;

        goalMessage.textContent = "";
    });

    continueButton.addEventListener("click", function () {
        if (selectedGoal === null) {
            goalMessage.textContent = "Please select your main fitness goal before continuing.";
            return;
        }

        if (selectedGoal === "LOSE_WEIGHT") {

            goalSelectionStep.classList.add("hidden");

            loseWeightStep.classList.remove("hidden");
        }


    })
});