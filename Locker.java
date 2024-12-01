import java.util.ArrayList;
import java.util.List;

class Locker {
    private final List<Items>[][][] lockers; 

    @SuppressWarnings("unchecked")
    public Locker() {
        lockers = new ArrayList[5][5][5]; 
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    lockers[i][j][k] = new ArrayList<>();
                }
            }
        }
    }


    public boolean isValidLocker(int x, int y, int z) {
        return x >= 0 && x < 5 && y >= 0 && y < 5 && z >= 0 && z < 5;
    }

   
    public void storeItemsInLocker(int x, int y, int z, List<Items> items) {
        if (!isValidLocker(x, y, z)) {
            System.out.println("\nInvalid locker coordinates.");
            return;
        }
        lockers[x][y][z].addAll(items);
        System.out.println("\nItems successfully added to Locker (" + x + "," + y + "," + z + ").");
    }

    public void viewLockerItems(int x, int y, int z) {
        if (!isValidLocker(x, y, z)) {
            System.out.println("Invalid locker coordinates.");
            return;
        }
        List<Items> lockerItems = lockers[x][y][z];
        if (lockerItems.isEmpty()) {
            System.out.println("Locker (" + x + "," + y + "," + z + ") is empty.");
        } else {
            for (Items item : lockerItems) {
                System.out.println("Name: " + item.getName());
                System.out.println("Key: " + item.getKey());
                System.out.println("Number of items: " + item.getFrequency());
                System.out.println();
            }
        }
    }
}
