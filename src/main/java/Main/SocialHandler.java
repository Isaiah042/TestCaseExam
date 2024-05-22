package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SocialHandler {


    private Set<String> usernames;


    public SocialHandler() {
        usernames = new HashSet<>();
    }

    public String nameOfAccount(String name) {
        if (name == null || name.isEmpty()) {
            return "Name cannot be blank or null";
        } else if (name.length() <= 10) {
            return  "@" + name.toLowerCase();
            } else {

                return "@" + name.substring(0,9).toLowerCase();
            }
        }

        public void addHandleToList(String handle) {
            usernames.add(nameOfAccount(handle));
        }


    public Set<String> getUsernames() {
        return usernames;
    }

    public static void main(String[] args) {
        SocialHandler socialHandler = new SocialHandler();
        String name = "IsaiahG";
        String handleName = socialHandler.nameOfAccount(name);
        System.out.println(handleName);
        socialHandler.addHandleToList(handleName);
        String name2 = "IsaiahG";
        String handlerName2 = socialHandler.nameOfAccount(name2);
        socialHandler.addHandleToList(handlerName2);
        System.out.println(socialHandler.getUsernames());
    }
}
