# ProgressLab Use Cases

## UC-001: Create Account

**Primary Actor:** User

**Goal:** Create a new ProgressLab account.

**Preconditions:**
- The user does not already have an account with the same email address.

**Main Flow:**
1. The user opens the account registration page.
2. The system asks the user to enter an email address and password.
3. The user enters the required information.
4. The system validates the email format and password requirements.
5. The system checks whether the email address is already associated with another account.
6. The system creates the account.
7. The system confirms that registration was successful.

**Alternative Flows:**
- If the email format is invalid, the system displays a validation message.
- If the password does not satisfy the password requirements, the system displays a validation message.
- If the email address is already associated with an account, the system prevents account creation and informs the user.

**Postconditions:**
- A new ProgressLab user account exists.

**Related Requirements:**
- FR-001
- FR-002
- FR-003
- FR-004
- FR-005
- FR-006
- FR-007
- FR-008

## UC-002: Log In

**Primary Actor:** Registered User

**Goal:** Access the user's ProgressLab account.

**Preconditions:**
- The user already has a registered ProgressLab account.

**Main Flow:**
1. The user opens the login page.
2. The system asks the user to enter an email address and password.
3. The user enters the required login information.
4. The system validates the provided credentials.
5. The system authenticates the user.
6. The system grants the user access to their personal ProgressLab account.
7. The system displays the user's dashboard.

**Alternative Flows:**
- If the email address or password is incorrect, the system denies access and displays an appropriate error message.
- If required login information is missing, the system asks the user to complete the missing information.

**Postconditions:**
- The user is authenticated and has access to their personal ProgressLab information.

**Related Requirements:**
- FR-009
- FR-010
- FR-011
- FR-012
- FR-014

## UC-003: Log Out
## UC-004: Create Fitness Goal
## UC-005: Edit Fitness Goal
## UC-006: Delete Fitness Goal
## UC-007: Record Body Measurement
## UC-008: Edit Body Measurement
## UC-009: Delete Body Measurement
## UC-010: Record Workout
## UC-011: Edit Workout
## UC-012: Delete Workout
## UC-013: View Dashboard
## UC-014: View Weight Trend
## UC-015: View Goal Progress
## UC-016: View Workout Activity
## UC-017: View BMI