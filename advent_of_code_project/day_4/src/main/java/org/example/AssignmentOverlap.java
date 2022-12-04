package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class AssignmentOverlap {
    public static void main(String[] args) {
        int totalOverlappingPairs= 0;

        try {
            File file = FileReaderUtil.getFileFromResource(AssignmentOverlap.class);

            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim();
                if (!data.isEmpty()) {
                    String[] assignmentsByPair = data.split(",");
                    String zonesPairOne = getZoneStringForAssignment(assignmentsByPair[0]);
                    String zonesPairTwo = getZoneStringForAssignment(assignmentsByPair[1]);

                    if(checkCompleteOverlap(zonesPairOne, zonesPairTwo)){
                        totalOverlappingPairs++;
                    }
                }
            }
            myReader.close();
            System.out.println("Total overlapping pairs: " + totalOverlappingPairs);

        } catch (FileNotFoundException | URISyntaxException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static boolean checkCompleteOverlap(String zonesPairOne, String zonesPairTwo) {
        return zonesPairOne.matches(".*\\b"+ zonesPairTwo + "\\b.*") || zonesPairTwo.matches(".*\\b"+ zonesPairOne + "\\b.*");
    }

    private static String getZoneStringForAssignment(String zones) {
        StringBuilder resultString = new StringBuilder();
        String[] zoneNumbers = zones.split("-");
        int num = Integer.parseInt(zoneNumbers[0]);
        while (num < Integer.parseInt(zoneNumbers[1])){
            resultString.append(num).append(",");
            num++;
        }
        resultString.append(zoneNumbers[1]);
        return resultString.toString();
    }
}