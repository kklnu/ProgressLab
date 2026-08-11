# ProgressLab Functional Requirements

# ProgressLab Functional Requirements

## Account Management

FR-001: The system shall allow a new user to create an account using an email address and password.
FR-002: The system shall prevent the creation of multiple user accounts using the same email address.
FR-003: The system shall treat email addresses as case-insensitive when determining whether an account already exists.
FR-004: The system shall validate that the email address entered during account registration follows a valid email address format.
FR-005: The system shall require passwords to contain at least 10 characters.
FR-006: The system shall require passwords to contain at least one uppercase letter, one lowercase letter, one numerical digit, and one special character.
FR-007: The system shall display an appropriate validation message when the user enters invalid registration information.
FR-008: The system shall create the user's account when all required registration information is valid.
FR-009: The system shall allow a registered user to log in using their email address and password.
FR-010: The system shall deny access when the user enters an incorrect email address or password.
FR-011: The system shall display an appropriate error message when a login attempt is unsuccessful.
FR-012: The system shall provide an authenticated user access to their personal ProgressLab account after a successful login.
FR-013: The system shall allow an authenticated user to log out of their account.
FR-014: The system shall prevent unauthenticated users from accessing another user's private fitness information.

## Fitness Goal Management

FR-015: The system shall allow an authenticated user to create a personal fitness goal.
FR-016: The system shall support weight-loss, weight-gain, and workout-consistency goals.
FR-017: The system shall allow the user to specify a starting value and target value for applicable fitness goals.
FR-018: The system shall allow the user to specify a start date and target date for a fitness goal.
FR-019: The system shall calculate the user's progress toward an active measurable fitness goal using recorded fitness data.
FR-020: The system shall allow the user to view their active fitness goals.
FR-021: The system shall allow the user to edit an existing fitness goal.
FR-022: The system shall allow the user to delete a fitness goal.

## Body Measurement Management

FR-023: The system shall allow an authenticated user to record their body weight.
FR-024: The system shall allow an authenticated user to record selected body measurements.
FR-025: Each body measurement record shall include the date on which the measurement was taken.
FR-026: The system shall allow the user to view previously recorded body measurements.
FR-027: The system shall allow the user to edit an existing body measurement record.
FR-028: The system shall allow the user to delete an existing body measurement record.
FR-029: The system shall maintain historical measurement records so that changes can be viewed over time.

## Workout Management

FR-030: The system shall allow an authenticated user to manually create a workout record.
FR-031: The system shall allow the user to specify the date of a workout.
FR-032: The system shall allow the user to add one or more exercises to a workout.
FR-033: The system shall allow the user to record the number of sets performed for an exercise.
FR-034: The system shall allow the user to record the number of repetitions performed for an exercise.
FR-035: The system shall allow the user to record the weight used for an exercise when applicable.
FR-036: The system shall allow the user to view previously recorded workouts.
FR-037: The system shall allow the user to edit an existing workout record.
FR-038: The system shall allow the user to delete an existing workout record.

## Progress Dashboard

FR-039: The system shall provide an authenticated user with a personal fitness dashboard.
FR-040: The dashboard shall display the user's current active fitness goal and progress toward that goal.
FR-041: The dashboard shall display the user's recorded weight trend over time.
FR-042: The dashboard shall display information about the user's workout activity.
FR-043: The system shall calculate workout consistency using the user's recorded workout history.
FR-044: The dashboard shall update its displayed progress information when relevant fitness records are added, edited, or deleted.

## BMI

FR-045: The system shall allow the user to provide the information required for BMI calculation.
FR-046: The system shall calculate the user's BMI using the height and weight provided by the user.
FR-047: The system shall display the calculated BMI to the user.
FR-048: The system shall display the general BMI category associated with the calculated BMI.
FR-049: The system shall identify BMI information as general fitness information rather than individualized medical advice.

## Data Privacy and User Records

FR-050: The system shall associate fitness goals, measurements, workouts, and other personal fitness records with the authenticated user's account.
FR-051: The system shall allow an authenticated user to access only the personal fitness records associated with their account.
FR-052: The system shall prevent one user from viewing, modifying, or deleting another user's private fitness records.