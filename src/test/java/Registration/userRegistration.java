package Registration;

import helpers.setupPageObject;
import org.testng.annotations.Test;
import pages.commonActions;
import java.util.Random;



public class userRegistration extends setupPageObject {



    pages.commonActions commonActions;

    public userRegistration() {

        commonActions = new commonActions();


    }


    @Test
    public void registrationNonContractorUS() throws Throwable {
        int min = 1;
        int max = 99;
        int randomNumbers= (int)(Math.random() * (max - min + 1) + min);
        String randomEmail = "test00" + randomNumbers + "@test.com";
        String randomUsername = "testuser00" + randomNumbers;

        commonActions.getTestUrl();
        commonActions.clickIdButton(("gwt-uid-10"));
        commonActions.enterTextToTextField("firstNameField", "TestUserName");
        commonActions.enterTextToTextField("lastNameField", "LastName");
        commonActions.selectOptionFromDropdown("selectOrgDropdown", 2);
        commonActions.enterTextToTextField("phoneNumberField", randomNumbers + "-" + randomNumbers + "-" + randomNumbers + "-" + randomNumbers);
        commonActions.enterTextToTextField("emailAddressField", randomEmail );
        commonActions.enterTextToTextField("confirmEmailAddressField", randomEmail );
        System.out.println("User email is: " + randomEmail);
        commonActions.clickIdButton(("gwt-uid-25"));
        commonActions.selectOptionFromDropdown("siteLeadListBox", 7);
        commonActions.enterTextToTextField("userNameField__XXX", randomUsername);
        System.out.println("Username is: " + randomUsername);
        commonActions.enterTextToTextField("passwordField", "Password1029!!");
        commonActions.enterTextToTextField("areaOfInterestField", "Anywhere in the World");
        commonActions.enterTextToTextField("justificationTextArea", "The justification goes here");
        //commonActions.clickByXpath("//*[@id='gwt-uid-58']");
        //commonActions.explicitWait("submitButton");
        //commonActions.clickIdButton(("submitButton"));






    }


}
