import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class aboutGui {

    // Constructor
    public aboutGui() {
        // Initialize any required settings if needed
    }

    // Method to create the header panel
    public JPanel createHeaderPanel() {
        JLabel titleLabel = new JLabel("ABOUT", JLabel.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
        titleLabel.setForeground(Color.BLACK);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(61, 90, 128)); // Dark blue background
        headerPanel.setBorder(new EmptyBorder(20, 10, 10, 10));
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        return headerPanel;
    }

// Method to create the description panel
public JPanel createDescriptionPanel() {
    // Label for the actual description text
    JLabel descriptionLabel = new JLabel(
            "<html><div style='text-align: justify; width: 500px;'>Welcome to CALIS (Content Analyzer and Locker Inventory System), " +
            "a versatile tool designed to streamline locker management for administrators in schools, businesses, " +
            "and other establishments. CALIS offers an intuitive interface to efficiently organize, track, and optimize " +
            "locker usage. With features like Locker Manager for managing items, Space Checker for monitoring capacity, " +
            "and History for tracking activities, CALIS ensures seamless inventory control. Designed to work across " +
            "Windows, macOS, and Linux systems, the application requires minimal setup, allowing users to get started quickly. " +
            "CALIS embodies simplicity and functionality, making it an indispensable resource for efficient locker management." +
            "</div></html>",
            JLabel.CENTER);

    descriptionLabel.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 23));
    descriptionLabel.setForeground(Color.BLACK);
    descriptionLabel.setBorder(new EmptyBorder(0, 20, 20, 0)); // Padding around text

    // Panel to hold the description text with a border
    JPanel textPanel = new JPanel(new BorderLayout());
    textPanel.setBackground(new Color(255, 255, 255)); // White background
    textPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Black border
    textPanel.add(descriptionLabel, BorderLayout.CENTER);

    // Outer description panel
    JPanel descriptionPanel = new JPanel(new BorderLayout());
    descriptionPanel.setBackground(new Color(152, 193, 217)); // Light blue background
    descriptionPanel.setBorder(new EmptyBorder(10, 30, 10, 30)); // Padding around the textPanel
    descriptionPanel.add(textPanel, BorderLayout.CENTER);

    return descriptionPanel;
}


    // Method to create a single team member card
    public JPanel createTeamMemberCard(String name, String course, String age, String location) {
        JPanel memberPanel = new JPanel(new BorderLayout());
        memberPanel.setBackground(Color.BLACK); // Black background
        memberPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Border around the card

        // Content of the card
        JLabel memberLabel = new JLabel(
                String.format("<html><div style='color: white; text-align: center;'>%s<br>%s<br>AGE: %s<br>%s</div></html>",
                        name, course, age, location),
                JLabel.CENTER);
        memberLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        memberPanel.add(memberLabel, BorderLayout.CENTER);
        return memberPanel;
    }

    // Method to create the team panel
    public JPanel createTeamPanel() {
        JPanel teamPanel = new JPanel(new GridLayout(1, 4, 15, 0)); // Grid layout for team cards
        teamPanel.setBackground(new Color(61, 90, 128)); // Dark blue background

        // Add team members
        teamPanel.add(createTeamMemberCard("BRUTAS, JOHN ARIES", "BS COMPUTER SCIENCE", "20", "MALILIPOT ALBAY"));
        teamPanel.add(createTeamMemberCard("MORGA, CHRISTIAN", "BS COMPUTER SCIENCE", "21", "DARAGA ALBAY"));
        teamPanel.add(createTeamMemberCard("NACARIO, CARL JOSEPH", "BS COMPUTER SCIENCE", "20", "LEGAZPI ALBAY"));
        teamPanel.add(createTeamMemberCard("TABALAN, VHON MICHAEL", "BS COMPUTER SCIENCE", "19", "CAMARINES NORTE"));

        return teamPanel;
    }

    // Method to assemble the About Us GUI panel
    public JPanel createAboutPanel() {
        JPanel aboutPanel = new JPanel(new BorderLayout());
        aboutPanel.setBackground(new Color(61, 90, 128));

        aboutPanel.add(createHeaderPanel(), BorderLayout.NORTH);
        aboutPanel.add(createDescriptionPanel(), BorderLayout.CENTER);
        aboutPanel.add(createTeamPanel(), BorderLayout.SOUTH);

        return aboutPanel;
    }

    // Main method to display the About Us GUI
    public static void main(String[] args) {
        JFrame frame = new JFrame("About CALIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        aboutGui gui = new aboutGui();
        JPanel aboutPanel = gui.createAboutPanel();

        frame.add(aboutPanel);
        frame.setSize(900, 700); // Window size
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}