# Implementation Plan - Authentication & Homepage Flow

Create three new activities (Register, Login, Homepage) with beautiful custom UI styled precisely according to the design mockups, and implement explicit/implicit intents for seamless navigation, data passing, logout, and text sharing.

## User Review Required

> [!IMPORTANT]
> - New descriptive activity files (`RegisterActivity`, `LoginActivity`, `HomeActivity`) will be created to keep the codebase structured.
> - Custom drawable backgrounds will be added for the light-grey rounded input fields and the blue action buttons to exactly match the provided design.
> - The launcher activity will be set to `RegisterActivity` (first screen from left to right in mockup).

## Proposed Changes

### 1. Custom UI Styles & Drawables
Create background drawables to give fields and buttons rounded corners as shown in the design.

#### [NEW] [bg_input_field.xml](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/res/drawable/bg_input_field.xml)
- Light grey color (`#EEEEEE`) with rounded corners (`8dp`).

#### [NEW] [bg_button.xml](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/res/drawable/bg_button.xml)
- Vibrant blue color (`#4D5DFA`) with rounded corners (`8dp`).

### 2. Layouts
Design layouts using `LinearLayout`/`ConstraintLayout` matching the provided image.

#### [NEW] [activity_register.xml](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/res/layout/activity_register.xml)
- Title: "Register"
- Inputs: Username, Email, Phone, Password using `bg_input_field`.
- Checkbox for Terms and Conditions.
- Register Button using `bg_button`.
- Bottom text: "Already Have an Account? Log In".

#### [NEW] [activity_login.xml](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/res/layout/activity_login.xml)
- Title: "Login"
- Inputs: Username, Password.
- Remember Me checkbox & Forget Password label.
- Login Button using `bg_button`.
- Bottom text: "New Member? Register".

#### [NEW] [activity_home.xml](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/res/layout/activity_home.xml)
- Title: "Homepage"
- Labels for: Welcome Username, Active Email, Registered Phone.
- Button: "Share Info" (Implicit intent).
- Button: "Logout" (Navigates to Login).

### 3. Source Code & Logic
Implement modern Kotlin activities using View Binding.

#### [NEW] [RegisterActivity.kt](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/java/com/example/intentapp/RegisterActivity.kt)
- Navigates to `HomeActivity` by sending Username, Email, and Phone via intent extras.
- Navigates to `LoginActivity` when "Log In" link text is clicked.

#### [NEW] [LoginActivity.kt](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/java/com/example/intentapp/LoginActivity.kt)
- Navigates to `HomeActivity` upon clicking Login.
- Navigates to `RegisterActivity` when "Register" link text is clicked.

#### [NEW] [HomeActivity.kt](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/java/com/example/intentapp/HomeActivity.kt)
- Receives data from registration/login and displays it dynamically.
- Logout Button: Navigates back to `LoginActivity` and clears activity stack.
- Share Button: Creates an implicit `ACTION_SEND` intent sharing a text message with username and email details.

### 4. Manifest Configuration

#### [MODIFY] [AndroidManifest.xml](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/AndroidManifest.xml)
- Register `RegisterActivity`, `LoginActivity`, and `HomeActivity`.
- Configure `RegisterActivity` as the entry point launcher activity.

## Verification Plan

### Automated Tests
- Build project using Gradle: `./gradlew assembleDebug` to verify no compilation/resource errors.

### Manual Verification
- Verify navigation between Register and Login screens via bottom link text.
- Register a user and verify data flows correctly onto the Homepage text labels.
- Verify the Logout button takes the user securely to the Login screen.
- Verify the Share button opens the Android system share sheet with a correctly prefilled message.
