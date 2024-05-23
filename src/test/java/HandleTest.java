import Main.SocialHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HandleTest {

    @Test
    @DisplayName("Check if social media handle was created")
    void checkHandleTest(){
        String expected = "@isaiahg12";

        SocialHandler socialHandler = new SocialHandler();
        String name = "IsaiahG12345";
        String handleName = socialHandler.nameOfAccount(name);

        Assertions.assertEquals(expected,handleName);
    }

    @Test
    @DisplayName("Check if handler created with 9 characters or less")
    void checkHandleLessThan9CharactersTest(){
        String expected = "@super";

        SocialHandler socialHandler = new SocialHandler();
        String name = "super";
        String handleName = socialHandler.nameOfAccount(name);

        Assertions.assertEquals(expected,handleName);
    }
    
    @Test
    @DisplayName("Check if handle input is null")
    void checkIfNullTest(){
        String expected = "Name cannot be blank, null, or Empty";

        SocialHandler socialHandler = new SocialHandler();
        String name = null;
        String handleName = socialHandler.nameOfAccount(name);

        Assertions.assertEquals(expected,handleName);
    }
    
    @Test
    @DisplayName("Check if handle input is empty or blank")
    void checkEmptyOrBlankTest(){
        String expected = "Name cannot be blank, null, or Empty";

        SocialHandler socialHandler = new SocialHandler();
        String name = "   ";
        String handleName = socialHandler.nameOfAccount(name);

        Assertions.assertEquals(expected,handleName);
    }
    
    @Test
    @DisplayName("If handle was added despite multiple attempts")
    void addHandleTest(){
        Set<String> expected = new HashSet<>();
        expected.add("@isaiahg");

        SocialHandler socialHandler = new SocialHandler();
        String name = "isaiahg";
        String name2 = "isaiahg";
        String handleName = socialHandler.nameOfAccount(name);
        String handleName2 = socialHandler.nameOfAccount(name2);
        socialHandler.addHandleToList(handleName);
        socialHandler.addHandleToList(handleName2);
        //Check size list
        Assertions.assertEquals(1,socialHandler.getUsernames().size());
        Assertions.assertEquals(expected,socialHandler.getUsernames());
    }

    @Test
    @DisplayName("Remove a Handler")
    void removeHandleTest(){
        Set<String> expected = new HashSet<>();
        expected.add("@christt");

        SocialHandler socialHandler = new SocialHandler();
        String name = "ChristT";
        String name2 = "IsaiahG";
        String handleName = socialHandler.nameOfAccount(name);
        String handleName2 = socialHandler.nameOfAccount(name2);
        socialHandler.addHandleToList(handleName);
        socialHandler.addHandleToList(handleName2);

        socialHandler.removeHandle(handleName2);
        //check size
        Assertions.assertEquals(1,socialHandler.getUsernames().size());
        Assertions.assertEquals(expected,socialHandler.getUsernames());
    }


    @Test
    @DisplayName("Change handlers name")
    void changeHandleTest(){
        Set<String> expected = new HashSet<>();
        expected.add("@christt");

        SocialHandler socialHandler = new SocialHandler();

        String name = "IsaiahG";
        String handleName = socialHandler.nameOfAccount(name);
        socialHandler.addHandleToList(handleName);
        socialHandler.changeHandle(handleName,"ChristT");
        Assertions.assertEquals(expected,socialHandler.getUsernames());
    }
}
