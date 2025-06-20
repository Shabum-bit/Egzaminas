package lt.techin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testing registration form with positive and negative scenarios")
@Tag("Registration")
public class RegistrationTest extends BaseTest {

    @BeforeEach
    void setUpRegistrationForm() {

        SignInPage signIpPage = new SignInPage(driver);

        signIpPage.clickCreateNewAccount();
    }

    @Test
    @Tag("Positive")
    @DisplayName("Successful registration with valid user data")
    void SignUpPositive() {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.enterUserName("Vardas1234!");

        registrationPage.enterPassword("Slaptazodis1230");

        registrationPage.enterPasswordConfirmation("Slaptazodis1230");

        registrationPage.clickCreateAccount();

        assertTrue(registrationPage.isRegistrationSuccessful(),
                "Registration should be successful with valid data");
        assertFalse(registrationPage.hasErrorMessage(),
                "No error messages should be displayed after successful registration");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Registration with minimum length values")
    void registrationWithMinimumLength() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.performRegistration("ABC12345", "123", "123");

        assertTrue(registrationPage.isRegistrationSuccessful(),
                "Registration should work with minimum length values");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with empty fields")
    void registrationWithEmptyFields() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickCreateAccount();

        assertTrue(registrationPage.hasErrorMessage(),
                "Error should be displayed for empty fields");
        assertFalse(registrationPage.isRegistrationSuccessful(),
                "Registration should fail with empty fields");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with too short username")
    void registrationWithTooShortUsername() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.performRegistration("AB", "Slaptazodis", "Slaptazodis");

        assertTrue(registrationPage.hasUsernameError(),
                "Should show username length error");
        assertFalse(registrationPage.isRegistrationSuccessful(),
                "Registration should fail with short username");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with too short password")
    void registrationWithTooShortPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.performRegistration("Testas", "12", "12");

        assertTrue(registrationPage.hasPasswordError(),
                "Should show password length error");
        assertFalse(registrationPage.isRegistrationSuccessful(),
                "Registration should fail with short password");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with password mismatch")
    void registrationWithPasswordMismatch() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.performRegistration("Testas", "Slaptazodis123", "KitoksSlaptazodis");

        assertTrue(registrationPage.hasPasswordMismatchError(),
                "Should show password mismatch error");
        assertFalse(registrationPage.isRegistrationSuccessful(),
                "Registration should fail with mismatched passwords");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Registration fails with existing username")
    void registrationWithExistingUsername() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.performRegistration("Vardas", "Vardas1230", "Vardas1230");

        assertTrue(registrationPage.hasUsernameTakenError(),
                "Should show username taken error");
        assertFalse(registrationPage.isRegistrationSuccessful(),
                "Registration should fail with existing username");
    }
}

