import Main.SocialHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HandleTest {

    @Test
    @DisplayName("Check if social media handle was created")
    void checkHandleTest(){
        String expected = "@isaiahg";

        SocialHandler socialHandler = new SocialHandler();
        String name = "IsaiahG";
        String handleName = socialHandler.nameOfAccount(name);

        Assertions.assertEquals(expected,handleName);
    }

    @Test
    @DisplayName("Check if handler created with 9 characters or less")
    void checkHandleLessThan9CharactersTest(){
        String expected = "@supercali";

        SocialHandler socialHandler = new SocialHandler();
        String name = "supercalifragilisticexpialidocious";
        String handleName = socialHandler.nameOfAccount(name);

        Assertions.assertEquals(expected,handleName);
    }
    
    @Test
    @DisplayName("Check if handle input is null")
    void checkIfNullTest(){
        String expected = "Name cannot be blank or null";

        SocialHandler socialHandler = new SocialHandler();
        String name = null;
        String handleName = socialHandler.nameOfAccount(name);

        Assertions.assertEquals(expected,handleName);
    }
    
    @Test
    @DisplayName("Check if handle input is empty or blank")
    void checkEmptyOrBlankTest(){
        String expected = "Name cannot be blank or null";

        SocialHandler socialHandler = new SocialHandler();
        String name = "";
        String handleName = socialHandler.nameOfAccount(name);

        Assertions.assertEquals(expected,handleName);
    }
    
    @Test
    @DisplayName("If handle was added despite multiple attempts")
    void addHandleTest(){
        String expected = "[@isaiahg]";

        SocialHandler socialHandler = new SocialHandler();
        String name = "isaiahg";
        String name2 = "isaiahg";
        String handleName = socialHandler.nameOfAccount(name);
        String handleName2 = socialHandler.nameOfAccount(name2);
        socialHandler.addHandleToList(handleName);
        socialHandler.addHandleToList(handleName2);


        Assertions.assertEquals(expected,socialHandler.getUsernames());
    }

}