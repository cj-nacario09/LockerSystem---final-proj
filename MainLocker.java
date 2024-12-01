import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainLocker {
    public static void main(String[] args) {
        Locker lockerSystem = new Locker();

        try (Scanner scanner = new Scanner(System.in)){

            File lockerFile = new File("LockerInfo.txt");
            
            if (lockerFile.createNewFile()){

                System.out.println("File created: " + lockerFile.getName());
                System.out.println("\n\n");
            } 
            else {
                System.out.println("File already exists. Writing to the existing file.");
                System.out.println("\n\n");
            }

            try (FileWriter fileWriter = new FileWriter(lockerFile, true)){

                System.out.print("\nEnter your name: ");
                String userName = scanner.nextLine().trim();

                while (userName.isEmpty()) {

                    System.out.println("\nName cannot be empty. Please enter a valid name.");
                    System.out.print("\nEnter your name: ");
                    userName = scanner.nextLine().trim();
                }

                System.out.println("\n\nHello, " + userName + "! Let's proceed.");

                while (true) {

                    String lockerCode = getLockerCode(scanner, lockerSystem);

                    System.out.print("\nHow many items do you want to add to the locker? ");

                    int numberOfItems = getValidInt(scanner, "\nPlease enter a valid number.");

                    if (numberOfItems <= 0) {
                        System.out.println("\nYou must add at least one item.");
                        continue;
                    }

                    List<Items> itemList = collectItems(scanner, numberOfItems);

                    int x = Character.getNumericValue(lockerCode.charAt(0));
                    int y = Character.getNumericValue(lockerCode.charAt(1));
                    int z = Character.getNumericValue(lockerCode.charAt(2));
                    lockerSystem.storeItemsInLocker(x, y, z, itemList);

                    // outputfile
                    fileWriter.write("Locker " + lockerCode + " contains:\n");
                    for (Items item : itemList){

                        Date thisDate = new Date();
                        SimpleDateFormat dateform = new SimpleDateFormat("MM/dd/YY");
                        String printdate = dateform.format(thisDate);
    
                        System.out.println(printdate);
                        fileWriter.write("Date: " + printdate + "\n"); 
                        fileWriter.write("  - " + item.getName() + " (Key: " + item.getKey() + ", Frequency: " + item.getFrequency() + ")\n");
                    }

                    fileWriter.write("\n");

                    System.out.println("\n\nItems in Locker " + lockerCode + ":");
                    lockerSystem.viewLockerItems(x, y, z);

                    System.out.print("\nDo you want to add items to another locker? (yes/no): ");
                    String response = scanner.nextLine().trim();

                    if (response.equalsIgnoreCase("no")){

                        System.out.println("\nThank you, " + userName + "! Goodbye.");
                        break;
                    }
                }
            }
        } catch (IOException e) {

            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    private static int getValidInt(Scanner scanner, String errorMessage){

        while (!scanner.hasNextInt()){

            System.out.println(errorMessage);
            scanner.next();
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static List<Items> collectItems(Scanner scanner, int numberOfItems) {

        List<Items> itemList = new ArrayList<>();

        for (int i = 0; i < numberOfItems; i++) {
            
            System.out.println("\nEnter details for item " + (i + 1) + ":");

            System.out.print("\nItem name: ");
            String itemName = scanner.nextLine().trim();

            String itemKey = RandomKeyGenerator.generateRandomKey(5);

            System.out.print("How many: ");
            int itemFrequency = getValidInt(scanner, "/nPlease enter a valid number.");

            itemList.add(new Items(itemName, itemKey, itemFrequency));

        }
        return itemList;
    }

    private static String getLockerCode(Scanner scanner, Locker lockerSystem) {

        while (true) {

            System.out.print("\nEnter the locker number (3-digit format like 000, 001, etc.): ");
            String input = scanner.nextLine().trim();

            if (!input.matches("\\d{3}")) {

                System.out.println("\nInvalid locker format. Please enter exactly three digits (e.g., 000, 001).");
                continue;
                
            }

            int x = Character.getNumericValue(input.charAt(0));
            int y = Character.getNumericValue(input.charAt(1));
            int z = Character.getNumericValue(input.charAt(2));

            if (!lockerSystem.isValidLocker(x, y, z)) {

                System.out.println("\nInvalid locker number. Lockers range from 000 to 444.");
                continue;
            }

            return input;
        }
    }
}
