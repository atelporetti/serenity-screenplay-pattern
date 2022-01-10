package swaglabs.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import swaglabs.model.SwaglabsUser;
import swaglabs.tasks.authentication.Login;
import swaglabs.tasks.navigation.Navigate;

public class AuthenticationStepDefinitions {

    @Given("{actor} is on the login page")
    public void onTheLoginPage(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheLoginPage()
        );
    }

    @When("{actor} logs in with valid credentials")
    public void logsInWithValidCredentials(Actor actor) {
        actor.attemptsTo(
                Login.asA(SwaglabsUser.STANDARD_USER)
        );
    }

    @Then("{actor} should be presented with the product catalog")
    public void heShouldBePresentedWithTheProductCatalog(Actor actor) {
        actor.attemptsTo(
                Ensure.that(Text.of(".title")).isEqualToIgnoringCase("Products")
        );
    }

    @Given("{actor} has logged on the application")
    public void hasLoggedOnTheApplication(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheLoginPage()
        );
        actor.attemptsTo(
                Login.asA(SwaglabsUser.STANDARD_USER)
        );
    }
}
