class Items {
    String key;   // A unique key for identifying the item
    private String name;  // The name of the item
    private int frequency;

    // Constructor
    public Items(String name, String key, int frequency) {
        this.key = key;
        this.name = name;
        this.frequency = frequency;
    }

    // Getters
    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

  
    
    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void incrementFrequency(int quantity) {
        this.frequency += quantity;
    }

    @Override
    public String toString() {
        return "Key: " + key + ", Name: " + name + " (x" + frequency + ")";
    }
}
