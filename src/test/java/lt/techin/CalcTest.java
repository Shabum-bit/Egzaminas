package lt.techin;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

    @DisplayName("Calculator tests")
    @Tag("Calculator")
    public class CalcTest extends BaseTest {

        @BeforeEach
        void signInFirst() {
            SignInPage signInPage = new SignInPage(driver);
            signInPage.performSignIn("Vardas1234!", "Slaptazodis1230");
        }

        @Test
        @Tag("Positive")
        void additionTest() {
            CalcPage calcPage = new CalcPage(driver);
            calcPage.calculate("5", "+", "3");

            assertTrue(calcPage.resultContains("= 8"));
        }
        @Test
        @Tag("Positive")
        void subtractionTest() {
            CalcPage calcPage = new CalcPage(driver);
            calcPage.calculate("10", "-", "4");

            assertTrue(calcPage.resultContains("= 6"));
        }

        @Test
        @Tag("Positive")
        void divisionTest() {
            CalcPage calcPage = new CalcPage(driver);
            calcPage.calculate("20", "/", "4");

            assertTrue(calcPage.resultContains("= 5"));
        }

        @Test
        @Tag("Positive")
        void multiplicationTest() {
            CalcPage calcPage = new CalcPage(driver);
            calcPage.calculate("6", "*", "7");

            assertTrue(calcPage.resultContains("= 42"));
        }
    }