package org.example;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class SupplyStacks {

    public static Map<Integer, String> stackData = new HashMap<>();

    public static void main(String[] args) {

        stackData = new HashMap<>(inputStack());

        try {
            File file = FileReaderUtil.getFileFromResource(SupplyStacks.class);

            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim();
                if (data.contains("move")) {
                    System.out.println(data);
                    String[] dataArray = data.split(" ");
                    Integer stacksToMove = returnDigitForOperation(Operation.STACKS_TO_MOVE, dataArray);
                    Integer fromContainer = returnDigitForOperation(Operation.CONTAINER_FROM, dataArray);
                    Integer toContainer = returnDigitForOperation(Operation.CONTAINER_TO, dataArray);

                    moveStack(stacksToMove, fromContainer, toContainer);
                }
            }
            myReader.close();
            System.out.println("Last value of each container as string: " + getLastValueOfEachContainer());

        } catch (FileNotFoundException | URISyntaxException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static String getLastValueOfEachContainer() {
        AtomicReference<String> result = new AtomicReference<>("");
        stackData.forEach((container, value) -> result.updateAndGet(v -> v + value.charAt(value.length() - 1)));
        return result.get();
    }

    private static void moveStack(Integer stacksToMove, Integer fromContainer, Integer toContainer) {
        String stacksFromContainer = stackData.get(fromContainer);
        StringBuilder stacksToContainer = new StringBuilder(stackData.get(toContainer));
        for (int i = 0; i < stacksToMove; i++){
          stacksToContainer.append(stacksFromContainer.charAt(stacksFromContainer.length() - 1));
           stacksFromContainer =  StringUtils.chop(stacksFromContainer);
        }
        stackData.replace(fromContainer, stacksFromContainer);
        stackData.replace(toContainer, String.valueOf(stacksToContainer));

    }

    private static Map<Integer, String> inputStack(){
        return Map.of(
            1, "QWPSZRHD",
            2, "VBRWQHF",
            3, "CVSH",
            4, "HFG",
            5, "PGJBZ",
            6, "QTJHWFL",
            7, "ZTWDLVJN",
            8, "DTZCJGHF",
            9, "WPVMBH"
        );
    }

    private static Integer returnDigitForOperation(Operation operation, String[] line){
        switch (operation) {
            case STACKS_TO_MOVE:
                return Integer.parseInt(line[1]);
            case CONTAINER_FROM:
                return Integer.parseInt(line[3]);
            case CONTAINER_TO:
                return Integer.parseInt(line[5]);
        }
        return null;
    }
}