# Walkthrough - Authentication & Homepage Flow

All 3 activities (Register, Login, Homepage) have been fully designed and integrated into the project application flow.

## Changes Made

### 1. Styles & Background Customization
- **[bg_input_field.xml](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/res/drawable/bg_input_field.xml)**: Light grey background shape with rounded corners (`10dp`) for elegant input fields.
- **[bg_button.xml](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/res/drawable/bg_button.xml)**: Beautiful primary blue color shape with rounded corners (`10dp`) for application wide action buttons.

### 2. Beautiful Interface XML Layouts
- **[activity_register.xml](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/res/layout/activity_register.xml)**: Contains fields for Username, Email, Phone, Password, terms checkbox, custom blue action button, and a redirect text link to the login screen.
- **[activity_login.xml](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/res/layout/activity_login.xml)**: Simple elegant form with username/password entries, a "Remember Me" checkbox paired with a "Forget Password ?" label, and a register link.
- **[activity_home.xml](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/res/layout/activity_home.xml)**: Display dashboard displaying user credentials dynamically with full options to invoke the implicit share sheet or log out.

### 3. Application Flow Source Code
- **[RegisterActivity.kt](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/java/com/example/intentapp/RegisterActivity.kt)**: Performs basic validation checks and sends full registration data (`username`, `email`, `phone`) via explicit intent to `HomeActivity`.
- **[LoginActivity.kt](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/java/com/example/intentapp/LoginActivity.kt)**: Authenticates credentials input and passes username data forward to the homepage dashboard.
- **[HomeActivity.kt](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/java/com/example/intentapp/HomeActivity.kt)**: Receives intent extras dynamically. Implements the implicit `ACTION_SEND` intent via the **Share Message** button to export username/email, and provides stack-clearing logic for the **Logout** action back to login.

### 4. Manifest Registry
- **[AndroidManifest.xml](file:///D:/Ridho/kuliah/PPPBD/IntentApp/app/src/main/AndroidManifest.xml)**: Set `RegisterActivity` as the initial application entry point activity launcher.

## Verification Results
- Built completely successfully using standard Gradle task: `./gradlew app:assembleDebug` with zero syntax or compiler errors.
