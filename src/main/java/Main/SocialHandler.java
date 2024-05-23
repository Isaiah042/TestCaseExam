package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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


    public static void socialMediaHandle(){
        File file = new File("C:\\Users\\chell\\IdeaProjects\\TestCaseExam\\src\\main\\resources/SocialHandles");
        try {
            file.createNewFile();
        } catch (IOException error) {
            System.out.println("No such path exist");
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public static void writeToFile(Set<String> handles){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Users\\chell\\IdeaProjects\\TestCaseExam\\src\\main\\resources/SocialHandles");
            fileWriter.write(handles.toString());
            System.out.println("Wrote to file successfully");
        } catch (IOException e) {
            System.out.println("Unable to write to file");
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Unable to close resource");
            }
        }
    }

    public static void main(String[] args) {
        SocialHandler socialHandler = new SocialHandler();
        String name = "IsaiahG";
        String handleName = socialHandler.nameOfAccount(name);
        socialHandler.addHandleToList(handleName);


        String name2 = "NelsonG";
        String handlerName2 = socialHandler.nameOfAccount(name2);
        socialHandler.addHandleToList(handlerName2);


//        socialHandler.removeHandle(handleName);

        String name1 = "IsaiahG";
        String handleName1 = socialHandler.nameOfAccount(name1);
        socialHandler.addHandleToList(handleName1);

        socialHandler.changeHandle(handlerName2, "ChrisT");
        System.out.println(socialHandler.getUsernames());



        socialMediaHandle();
        writeToFile(socialHandler.getUsernames());


    }
}
