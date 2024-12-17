import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LockerFileHandler {
    private static final String INPUT_FILE = "/home/xhyth3r/SoureCodes/Netbeans/CLIS/src/main/java/in/out_files/input.in";
    
     public static void saveLockersToFile(List<Locker> lockers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INPUT_FILE))) {
            for (Locker locker : lockers) {
                // Only write lockers that have valid data
                if (locker.getUserName() != null && !locker.getUserName().equals("Unknown") || !locker.getItems().isEmpty()) {
                    writer.write(locker.getId() + "\n");
                    writer.write(locker.getUserName() + "\n");

                    // Save items for the locker
                    for (Items item : locker.getItems()) {
                        writer.write( item.getKey() + "," + item.getName() + "," + item.getFrequency()+ "\n");
                    }
                    writer.write("\n"); // Add a new line between lockers
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // Method to load all lockers from the file
    public static List<Locker> loadLockersFromFile() {
    List<Locker> lockers = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {
        String line;
        Locker currentLocker = null;

        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue;

            if (line.matches("\\d+")) { // Locker ID
                if (currentLocker != null) {
                    lockers.add(currentLocker); // Add previous locker if it exists
                }
                currentLocker = new Locker(Integer.parseInt(line.trim())); // Create new locker
            } else if (currentLocker != null) {
                if (!line.contains(",")) {
                    currentLocker.setUserName(line.trim()); // Set the username
                } else { // Item line
                    String[] itemParts = line.split(",");
                    if (itemParts.length == 3) {
                        String itemKey = itemParts[0].trim();
                        String itemName = itemParts[1].trim();
                        int quantity = Integer.parseInt(itemParts[2].trim());
                        Items newItem = new Items(itemName, itemKey, quantity);
                        currentLocker.addItem(newItem); // Add item to locker
                    }
                }
            }
        }
        if (currentLocker != null) {
            lockers.add(currentLocker); // Add the last locker
        }
    } catch (IOException e) {
        System.err.println("Error while loading lockers: " + e.getMessage());
    }
    return lockers;
}

}
