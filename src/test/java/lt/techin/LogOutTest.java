package lt.techin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Logout")
@DisplayName("Logout functionality test")
public class LogOutTest extends BaseTest{


    @Test
    @Tag("Positive")
    @DisplayName("Successful logout from calculator page")
    void logoutTest() {

        SignInPage signInPage = new SignInPage(driver);

        signInPage.performSignIn("Vardas1234!", "Slaptazodis1230");

        CalcPage calcPage = new CalcPage(driver);

        calcPage.clickLogout();

        assertTrue(calcPage.isLoggedOut(), "User should be logged out and redirected to login page");
    }

}
