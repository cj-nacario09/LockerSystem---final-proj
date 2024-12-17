import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Locker{
    private int id;
    private String userName;
    private List<Items> items; // Use List<Item> instead of array
    private int maximumItemLimit = 100;

    // Constructor
    public Locker(int id) {
        this.id = id;
        this.userName = "Unknown";  // Default username
        this.items = new ArrayList<>(); // Initialize the list
    }

    public Locker(int id, String userName, List<Items> items) {
        this.id = id;
        this.userName = userName;
        this.items = items;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public boolean isOccupied() {
        return items.size() > 0; // Locker is occupied if there are items
    }

    public List<Items> getItems() {
        return items;
    }
    
    // Add Item to Locker
    public void addItem(Items newItem) {
        // Check if the item already exists in the list
        for (Items item : items) {
            if (item.getName().equalsIgnoreCase(newItem.getName())) { 
                // If the item already exists, increase its quantity by the new item's frequency
                item.incrementFrequency(newItem.getFrequency());
                return; // Exit after updating the frequency
            }
        }

        // If the item doesn't exist and the locker has space, add the new item to the list
        if (items.size() < maximumItemLimit) {
            items.add(newItem);  // Add the item to the list
        } else {
            // Handle the case when the locker is full
            System.out.println("Cannot add more items, locker is full.");
        }
    }

    // Clear all items from Locker
    public void clearLocker() {
        items.clear();  // Clears the list of items
    }
    
    // Check if Locker contains an item by name
    public boolean containsItem(String itemName) {
        for (Items item : items) {
            if (item != null && item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    // Remove Item from Locker by key
    public void removeItem(String key) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getKey().equals(key)) {
                items.remove(i); // Remove item by index
                return;
            }
        }
        System.out.println("Item not found.");
    }

    

    public static Locker fromFileString(BufferedReader reader, String lockerIdLine) throws IOException {
    int id;
    try {
        id = Integer.parseInt(lockerIdLine.trim()); // Parse LockerID
    } catch (NumberFormatException e) {
        System.out.println("Error parsing LockerID: " + lockerIdLine);
        return null;
    }

    // Read UserName (just a single line)
    String userNameLine = reader.readLine();
    if (userNameLine == null || userNameLine.isEmpty()) {
        System.out.println("Invalid UserName format: " + userNameLine);
        return null;
    }
    String userName = userNameLine.trim(); // Extract UserName

    // Read item lines (each item on a new line)
    List<Items> items = new ArrayList<>();
    String line;
    while ((line = reader.readLine()) != null && !line.isEmpty()) {
        String itemLine = line.trim();
        String[] parts = itemLine.split(",");
        if (parts.length < 3) {
            System.out.println("Invalid item format: " + itemLine);
            continue;  // Skip malformed item lines
        }

        String key = parts[0].trim(); // Item key
        String name = parts[1].trim(); // Item name
        int quantity = 0;
        try {
            quantity = Integer.parseInt(parts[2].trim()); // Item quantity
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity for item: " + itemLine);
            continue;  // Skip malformed item
        }

        items.add(new Items(name, key, quantity)); // Add item to list
    }

    // Return the locker object with parsed data
    return new Locker(id, userName, items);
}

   
   public String toFileString() {
    StringBuilder sb = new StringBuilder();
    sb.append(id).append("\n");  // LockerID
    sb.append(userName).append("\n");  // UserName
    for (Items item : items) {  // Each item
        sb.append(item.getKey()).append(",")
          .append(item.getName()).append(",")
          .append(item.getFrequency()).append("\n");
    }
    return sb.toString();  // Return formatted string
}


    // Method to check if the locker is empty
    public boolean isEmpty() {
        return userName == null || userName.equals("Unknown") && items.isEmpty();
    }




}
