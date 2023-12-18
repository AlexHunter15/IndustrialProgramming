import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class GUI extends JFrame {
    private static final String SECRET_KEY = "YourSecretKey123";
    private ArrayList<Fabric> fabrics;

    private JLabel statusLabel;

    public GUI() {
        super("Fabric Data Management");

        // Load fabric data from the file
        fabrics = ContainerCreator.createFabricListFromTxtFile("in_file.txt");

        // Set up the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        createComponents();
        setVisible(true);
    }

    private void createComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        JButton displayFabricDetailsButton = new JButton("Display Fabric Details");
        displayFabricDetailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayFabricDetails();
            }
        });
        mainPanel.add(displayFabricDetailsButton);

        JButton addFabricButton = new JButton("Add New Fabric");
        addFabricButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNewFabric();
            }
        });
        mainPanel.add(addFabricButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainPanel.add(exitButton);

        statusLabel = new JLabel("Status: Ready");
        add(mainPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }

    private void displayFabricDetails() {
        StringBuilder details = new StringBuilder("<html><body>");
        for (Fabric fabric : fabrics) {
            details.append(fabric.toString()).append("<br>");
        }
        details.append("</body></html>");
        JOptionPane.showMessageDialog(this, details.toString(), "Fabric Details", JOptionPane.PLAIN_MESSAGE);
    }

    private void addNewFabric() {
        String type = JOptionPane.showInputDialog(this, "Enter Fabric Type:");
        String place = JOptionPane.showInputDialog(this, "Enter Fabric Place:");
        String amount = JOptionPane.showInputDialog(this, "Enter Fabric Amount:");

        FabricBuilder fabricBuilder = FabricBuilder.getInstance();
        Fabric newFabric = fabricBuilder.setType(type).setPlace(place).setAmount(amount).build();
        fabrics.add(newFabric);

        statusLabel.setText("Status: New Fabric Added");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}
