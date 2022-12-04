package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.*;

public class RuckSack {

   public static Map<String, Integer> priorityMap = new HashMap<>();

    public static void main(String[] args) {

        priorityMap = getPriorityMap();
        int totalPriority = 0;

        try {
            File file = FileReaderUtil.getFileFromResource(RuckSack.class);

            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim();
                if (!data.isEmpty()) {
                    List<String> compartmentStrings = splitStringInHalf(data);
                    Set<String> commonStrings = getCommonItems(compartmentStrings.get(0), compartmentStrings.get(1));
                   for(String commonString : commonStrings){
                       totalPriority += priorityMap.get(commonString);
                   }

                }
            }
            myReader.close();
            System.out.println("Total priority: " + totalPriority);

        } catch (FileNotFoundException | URISyntaxException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static List<String> splitStringInHalf(String inputString) {
        int midPoint = (inputString.length()+1)/2;
        return List.of(inputString.substring(0, midPoint), inputString.substring(midPoint));
    }

    public static Map<String, Integer> getPriorityMap() {
        Map<String, Integer> result = new HashMap<>();
        int priority = 0;

        for(char alphabet = 'a'; alphabet <='z'; alphabet++ ) {
            priority++;
            result.put(String.valueOf(alphabet), priority);
        }
        for(char alphabet = 'a'; alphabet <='z'; alphabet++ ) {
            priority++;
            result.put(String.valueOf(alphabet).toUpperCase(), priority);
        }


        return result;
    }

    public static Set<String> getCommonItems(String compartmentOne, String compartmentTwo) {
        Set<String> resultSet = new HashSet<>();

        Set<Character> compartmentOneSet = new HashSet<>();
        Set<Character> compartmentTwoSet = new HashSet<>();

        for (int i = 0; i < compartmentOne.length(); i++){
            compartmentOneSet.add(compartmentOne.charAt(i));
        }
        for (int i = 0; i < compartmentOne.length(); i++){
            compartmentTwoSet.add(compartmentTwo.charAt(i));
        }

        for (Character common : compartmentOneSet){
            if(compartmentTwoSet.contains(common)){
                resultSet.add(String.valueOf(common));
            }
        }

        resultSet.forEach(System.out::println);

        return resultSet;
    }
}