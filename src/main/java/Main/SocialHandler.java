package Main;

import java.util.*;
import java.util.concurrent.Phaser;

public class SocialHandler {


    private Set<String> usernames;


    public SocialHandler() {
        usernames = new HashSet<>();
    }

    public String nameOfAccount(String name) {
        if (name == null || name.isEmpty()) {
            return "Name cannot be blank or null";
        } else if (name.length() <= 10) {
            return "@" + name.toLowerCase();
        } else {
            return "@" + name.substring(0, 9).toLowerCase();
        }
    }

    public void addHandleToList(String handle) {
        usernames.add(handle);
    }

    public void removeHandle(String handle){
        usernames.remove(handle);
    }


    public void changeHandle(String remove, String add) {
        removeHandle(remove);
        nameOfAccount(add);
        addHandleToList("@" + add.toLowerCase());
    }


    public Set<String> getUsernames() {
        return usernames;
    }


    public static void main(String[] args) {
        SocialHandler socialHandler = new SocialHandler();
        String name = "IsaiahG";
        String handleName = socialHandler.nameOfAccount(name);
        socialHandler.addHandleToList(handleName);
        String name2 = "NelsonG";
        String handlerName2 = socialHandler.nameOfAccount(name2);
        socialHandler.addHandleToList(handlerName2);
        socialHandler.removeHandle(handleName);

        socialHandler.changeHandle(handlerName2, "ChrisT");
        System.out.println(socialHandler.getUsernames());
    }
}
