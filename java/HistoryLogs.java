import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

class HistoryLogs {
    private final String filePath;
    
    public HistoryLogs(String filePath) {
        this.filePath = filePath;
    }
    
    // Method to create the header panel
    public JPanel createHeaderPanel() {
        // Create a border for the title panel
        Border border = BorderFactory.createLineBorder(Color.black, 2);

        // Title Label
        JLabel headerLabel = new JLabel("TRANSACTION LOGS", JLabel.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 25));
        headerLabel.setBorder(new EmptyBorder(10, 0, 10, 0)); // Adjusted spacing for better appearance

        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(67, 70, 75));
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        headerPanel.setBorder(border); // Set the border to the title panel

        // Set a preferred size for the header panel
        headerPanel.setPreferredSize(new Dimension(0, 60)); // Height of 60 pixels

        return headerPanel;
    }
    
   // Method to create the log panel with a JScrollPane
public JPanel createPanelLog() {
    // Create a JTextPane to hold the logs
    JTextPane logPane = new JTextPane();
    logPane.setEditable(false); // Make it read-only
    logPane.setBackground(new Color(0x3D5A80)); // Dark background for better contrast
    logPane.setForeground(Color.WHITE); // Set text color to white
    logPane.setFont(new Font("JetBrains Mono", Font.PLAIN, 20)); // Set font for logs (size 18)

    // Center align the text
    StyledDocument doc = logPane.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);

    // Read history from the file and populate the JTextPane
    logPane.setText(readHistoryFromFile());

    // Create a JScrollPane for the log area
    JScrollPane scrollPane = new JScrollPane(logPane);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    // Create a JPanel to hold the JScrollPane
    JPanel logPanel = new JPanel(new BorderLayout());
    logPanel.add(scrollPane, BorderLayout.CENTER); // Add the scroll pane to the panel

    return logPanel; // Return the panel containing the scroll pane
}

    // Method to read history from the file
    private String readHistoryFromFile() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error while reading history from file: " + e.getMessage());
        }
        return content.toString();
    }

    // Method to create the main panel
    public JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Create and add the header panel
        JPanel headerPanel = createHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH); // Add header panel to the top

        // Create and add the log panel
        JPanel logPanel = createPanelLog();
        mainPanel.add(logPanel, BorderLayout.CENTER); // Add log panel to the center

        return mainPanel; // Return the main panel
    }
}