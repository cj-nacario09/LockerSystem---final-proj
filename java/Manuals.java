import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

class manualGui {

    public manualGui() {
        // Constructor (can initialize any required components or settings here)
    }

    // Method to create the title panel
    public JPanel createTitlePanel() {
        Border border = BorderFactory.createLineBorder(Color.black, 2);

        // Title Label
        JLabel titleLabel = new JLabel("C.A.L.I.S. User Manual", JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("jetbrains mono medium", Font.BOLD, 25));
        titleLabel.setBorder(new EmptyBorder(20, 0, 20, 0)); // Adjusted spacing for better appearance

        // Title Panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(67, 70, 75));
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        return titlePanel;
    }

  public JScrollPane createContentPanel() {
    // Header Label for Contents
    JLabel contentLabel = new JLabel("Table Of Contents", JLabel.CENTER);
    contentLabel.setForeground(Color.WHITE);
    contentLabel.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 30));
    contentLabel.setBorder(new EmptyBorder(20, 20, 20, 0)); // Adjusted spacing for better appearance


        // Items for the content
        JLabel itemsLabel = new JLabel(
            "<html>" +
                "<div style='margin-left: 20px;'>" + // Add left margin for indentation
                    "<br>1. Introduction<br>" +
                    "2. System Requirements<br>" +
                    "3. Installation and Setup<br>" +
                    "4. Getting Started<br>" +
                    "5. Features and Usage Instructions<br>" +
                    "<div style='margin-left: 40px;'>" + 
                        "<span style='font-weight: normal;'>" + 
                        "- Home<br>" +
                        "- Locker Manager<br>" + 
                        "- Space Checker<br>" + 
                        "- History<br>" +
                        "- Manual<br>" +
                        "- About<br>" + 
                        "</span>" +
                    "</div>" +
                    "6. Troubleshooting<br>" + 
                    "7. Contact And Support<br><br>" +
                "</div>" +
            "</html>",
            JLabel.CENTER);
             
        itemsLabel.setForeground(Color.WHITE);
        itemsLabel.setFont(new Font("jetbrains mono medium", Font.BOLD, 23));
        itemsLabel.setVerticalAlignment(JLabel.TOP);
        // Set a preferred size for itemsLabel
        itemsLabel.setPreferredSize(new java.awt.Dimension(500, 1000)); // Adjust as needed

        // Create a main panel to hold both content and detailed items
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // Set vertical layout
        contentPanel.setBackground(new Color(0x3D5A80));
        
        // Add content components to the main panel
        contentPanel.add(contentLabel);
        contentPanel.add(itemsLabel);

        
        JLabel detailedItemsLabel = new JLabel(
             "<html>" +
        "<div style='margin-left: 20px;'>" + // Add left margin for indentation
            "<br><br><br><h2 style='font-weight: bold; font-size: 20px;'>1. Introduction</h2><br>" +
            "<p>Welcome to CALIS, the Content Analyzer and Locker Inventory System. This application is designed to help administrators of facilities with lockers to efficiently store, organize, and manage items. Whether you manage lockers in schools, businesses, or other establishments, CALIS simplifies the process of tracking contents and optimizing locker usage.</p>" +
            "<br><hr>" + // Horizontal line
            "<h2 style='font-weight: bold; font-size: 20px;'>2. System Requirements</h2>" +
            "<ul>" +
                "<li><strong>Operating System</strong>: Compatible with Windows, macOS, and Linux</li>" +
                "<li><strong>Java Version</strong>: Ensure Java Runtime Environment (JRE) is installed (version 8 or above recommended)</li>" +
                "<li><strong>Storage</strong>: Minimum of 50MB free space</li>" +
                "<li><strong>RAM</strong>: 2GB or more recommended</li>" +
            "</ul>" +
            "<br><hr>" +
            "<h2 style='font-weight: bold; font-size: 20px;'>3. Installation and Setup</h2>" +
            "<ol>" +
                "<li>Download the standalone JAR file from the provided link or source.</li>" +
                "<li>Ensure that Java is installed on your system.</li>" +
                "<li>Double-click the JAR file to launch the application.</li>" +
                "<li>If the JAR file doesn’t open, use the terminal or command prompt to run the command: " +
                "<code>java -jar calis.jar</code></li>" +
            "</ol>" +
            "<br><hr>" +
            "<h2 style='font-weight: bold; font-size: 20px;'>4. Getting Started</h2>" +
            "<br><p>Upon launching CALIS, you will be greeted with the main window, which consists of:</p>" +
            "<ul>" +
                "<li><strong>Left Sidebar</strong>: Contains navigation buttons for various features (Home, Locker Manager, etc.)</li>" +
                "<li><strong>Main Panel</strong>: Displays the corresponding content for the selected feature.</li>" +
            "</ul>" +
            "<br><h3>Navigation Tips</h3>" +
            "<ul>" +
                "<li>Click on the buttons in the left sidebar to access specific functionalities.</li>" +
                "<li>Use the Manual button for quick help within the app.</li>" +
            "</ul>" +
            "<br><hr>" +
            "<h2 style='font-weight: bold; font-size: 20px;'>5. Features and Usage Instructions</h2>" +
            "<br><h3>5.1 Home</h3>" +
            "<p>The Home screen provides an overview and access to all primary features. Use this screen as the starting point for navigation.</p>" +
            "<br><h3>5.2 Locker Manager</h3>" +
            "<p>Manage the lockers effectively:</p>" +
            "<ul>" +
                "<li><strong>View Locker Contents</strong>: Select a locker to see its stored items.</li>" +
                "<li><strong>Add Item</strong>: Choose a locker and input the item details to store it.</li>" +
                "<li><strong>Remove Item</strong>: Select an item from the locker to remove it.</li>" +
                "<li><strong>Move Item Between Lockers</strong>: Relocate items by specifying source and destination lockers.</li>" +
            "</ul>" +
            "<br><h3>5.3 Space Checker</h3>" +
            "<p>Check the availability of space in each locker:</p>" +
            "<ul>" +
                "<li>Displays the total and used capacity.</li>" +
                "<li>Helps optimize storage.</li>" +
            "</ul>" +
                    "<br><h3>5.4 History</h3>" +
            "<p>View a log of all actions performed, such as items added, removed, or moved.</p>" +
            "<ul>" +
                "<li>Useful for tracking activity.</li>" +
            "</ul>" +
            "<br><h3>5.5 Manual</h3>" +
            "<p>Access the in-app help documentation, which provides a summary of features and tips.</p>" +
            "<br><h3>5.6 About</h3>" +
            "<p>Learn more about CALIS, including version information and credits.</p>" +
            "<br><hr>" +
            "<h2 style='font-weight: bold; font-size: 20px;'>6. Troubleshooting</h2>" +
            "<br><h3>Common Issues</h3>" +
            "<ul>" +
                "<li><strong>App doesn't start</strong>: Ensure Java is installed and properly configured.</li>" +
                "<li><strong>Errors while managing lockers</strong>: Verify the input values and try again.</li>" +
                "<li><strong>Locker data not updating</strong>: Restart the application.</li>" +
            "</ul>" +
            "<br><p>If issues persist, refer to the Contact and Support section.</p>" +
            "<br><hr>" +
            "<h2 style='font-weight: bold; font-size: 20px;'>7. Contact and Support</h2>" +
            "<br><p>For assistance or inquiries, reach out to the project team:</p>" +
            "<ul>" +
                "<li><strong>Email</strong>: (To be edited)</li>" +
                "<li><strong>Phone</strong>: (To be edited)</li>" +
            "</ul>" +
            "<br><br><p>Thank you for using CALIS! We hope it makes managing lockers easier and more efficient.</p>" +
        "</div>" +
    "</html>", JLabel.CENTER);

        // Set the font and color for the JLabel\n" +
        detailedItemsLabel.setForeground(Color.WHITE);
        detailedItemsLabel.setFont(new Font("jetbrains mono medium", Font.PLAIN, 18));
        detailedItemsLabel.setVerticalAlignment(JLabel.TOP);
        
        // Set a preferred size for the detailed items label if necessary
        detailedItemsLabel.setPreferredSize(new java.awt.Dimension(500, 2200)); // Adjust as needed
        
        // Add the detailed items label to the content panel
        contentPanel.add(detailedItemsLabel);

        // Create a JScrollPane for the content panel
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        return scrollPane; 
                                                                                                                                                           
    }

    // Method to combine title and content panels
    public JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        
         // Create and add the title panel
        JPanel titlePanel = createTitlePanel();
        mainPanel.add(titlePanel, BorderLayout.NORTH); // Add title panel to the top

        // Add the content panel (which includes the scrollable items)
        JScrollPane contentScrollPane = createContentPanel();
        mainPanel.add(contentScrollPane, BorderLayout.CENTER);

        return mainPanel;
    }
}