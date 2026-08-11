# ProgressLab Use Case Diagram

```mermaid
flowchart LR

    Visitor[Visitor / New User]
    User[Registered User]

    subgraph ProgressLab
        UC1((Create Account))
        UC2((Log In))
        UC3((Log Out))
        UC4((Create Fitness Goal))
        UC5((Edit Fitness Goal))
        UC6((Delete Fitness Goal))
        UC7((Record Body Measurement))
        UC8((Edit Body Measurement))
        UC9((Delete Body Measurement))
        UC10((Record Workout))
        UC11((Edit Workout))
        UC12((Delete Workout))
        UC13((View Dashboard))
        UC14((View Weight Trend))
        UC15((View Goal Progress))
        UC16((View Workout Activity))
        UC17((View BMI))
    end

    Visitor --> UC1

    User --> UC2
    User --> UC3
    User --> UC4
    User --> UC5
    User --> UC6
    User --> UC7
    User --> UC8
    User --> UC9
    User --> UC10
    User --> UC11
    User --> UC12
    User --> UC13
    User --> UC14
    User --> UC15
    User --> UC16
    User --> UC17