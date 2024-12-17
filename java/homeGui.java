import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

class homeGui {

    private final Font defaultFont;

    public homeGui() {
        // Initialize JetBrains Mono Medium font
        defaultFont = new Font("JetBrains Mono Medium", Font.PLAIN, 18);
    }

    // Method to create the home content panel
    public JPanel createContentPanel() {
        // Header Label for Welcome Message
        JLabel welcomeLabel = new JLabel("SMART TRACKING, EFFICIENT CONTROL, SEAMLESS ORGANIZATION", JLabel.CENTER);
        welcomeLabel.setForeground(new Color(0xE0FBFC));
        welcomeLabel.setFont(defaultFont.deriveFont(Font.BOLD, 28));
        welcomeLabel.setBorder(new EmptyBorder(50, 0, 20, 0)); // Add spacing at the top and bottom

        // Load and resize the logo
        ImageIcon originalLogo = new ImageIcon("/home/xhyth3r/SoureCodes/Netbeans/CLIS/src/main/java/Icons/calisn.png");  // Replace with actual path to your logo
        Image scaledLogo = originalLogo.getImage().getScaledInstance(450, 450, Image.SCALE_SMOOTH); // Width x Height in pixels
        ImageIcon resizedLogo = new ImageIcon(scaledLogo);

        // Create JLabel with resized logo
        JLabel logoLabel = new JLabel(resizedLogo);
        logoLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        logoLabel.setBorder(new EmptyBorder(5, 0, 5, 0)); // Add space below logo

        // Introduction text with updated font sizes
        JLabel introLabel = new JLabel(
            "<html><div style='text-align: center; width: 700px; margin-left: auto; margin-right: auto;'>"
                    + "<span style='font-size: 30px;'>Welcome to the Content Analyzer and Locker Inventory System (C.A.L.I.S.)</span><br>"
                    + "<span style='font-size: 20px;'>Your all-in-one solution for effective locker management.</span>"
                    + "</div></html>", JLabel.CENTER);  // Center the label's text

        introLabel.setForeground(new Color(0xE0FBFC));
        introLabel.setFont(defaultFont); // Set font for the JLabel
        introLabel.setBorder(new EmptyBorder(0, 10, 10, 0)); // Padding for text

        // Content Panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(new Color(0x3D5A80)); // Set background color to #98c1d9 (light blue)
        contentPanel.add(welcomeLabel, BorderLayout.NORTH);
        contentPanel.add(logoLabel, BorderLayout.CENTER); // Add the logo below the caption
        contentPanel.add(introLabel, BorderLayout.SOUTH); // Add the introduction text below the logo
        
        return contentPanel;
    }

    // Method to create the home panel
    public JPanel createHomePanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Add only the content panel
        mainPanel.add(createContentPanel(), BorderLayout.CENTER);

        return mainPanel;
    }
}