package lt.techin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Sign in tests")
@Tag("SignIn")
public class SignInTest extends BaseTest{

    @Test
    @Tag("Positive")
    @DisplayName("Sign in with good data")
    void signInGood() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.performSignIn("Vardas1", "Slaptazodis1230");

        assertTrue(signInPage.isSignInSuccessful(), "Should sign in successfully");
        assertFalse(signInPage.hasSignInError(), "Should not have errors");
    }
    @Test
    @Tag("Negative")
    @DisplayName("Sign in with empty fields")
    void signInEmpty() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.clickSignIn();

        assertTrue(signInPage.hasSignInError(), "Should show error for empty fields");
        assertFalse(signInPage.isSignInSuccessful(), "Should not sign in with empty fields");
    }
    @Test
    @Tag("Negative")
    @DisplayName("Sign in with wrong username")
    void signInWrongUser() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.performSignIn("BlogasVardas", "Slaptazodis1230");

        assertTrue(signInPage.hasSignInError(), "Should show error for wrong username");
        assertFalse(signInPage.isSignInSuccessful(), "Should not sign in with wrong username");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Sign in with wrong password")
    void signInWrongPassword() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.performSignIn("Vardas1", "BlogasSlaptazodis");

        assertTrue(signInPage.hasSignInError(), "Should show error for wrong password");
        assertFalse(signInPage.isSignInSuccessful(), "Should not sign in with wrong password");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Sign in with empty username")
    void signInEmptyUsername() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.signInPasswordInput("Slaptazodis1230");
        signInPage.clickSignIn();

        assertTrue(signInPage.hasSignInError(), "Should show error for empty username");
        assertFalse(signInPage.isSignInSuccessful(), "Should not sign in with empty username");
    }

    @Test
    @Tag("Negative")
    @DisplayName("Sign in with empty password")
    void signInEmptyPassword() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.signInNameInput("Vardas1");
        signInPage.clickSignIn();

        assertTrue(signInPage.hasSignInError(), "Should show error for empty password");
        assertFalse(signInPage.isSignInSuccessful(), "Should not sign in with empty password");
    }
}