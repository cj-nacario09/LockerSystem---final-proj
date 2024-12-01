import java.util.Random;

class RandomKeyGenerator {
    public static String generateRandomKey(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < length; i++) {
            key.append(characters.charAt(random.nextInt(characters.length())));
        }
        return key.toString();
    }
}

class Items {
    private String name;
    private String key;
    private int frequency;

    public Items(String name, String key, int frequency) {
        this.name = name;
        this.key = key;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public int getFrequency() {
        return frequency;
    }

    public void incrementFrequency() {
        this.frequency++;
    }

    public void decrementFrequency() {
        if (this.frequency > 0) {
            this.frequency--;
        }
    }
}