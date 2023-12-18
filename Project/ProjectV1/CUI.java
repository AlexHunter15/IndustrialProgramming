import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CUI {
    private static final String SECRET_KEY = "YourSecretKey123";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Fabric> fabrics = ContainerCreator.createFabricListFromTxtFile("in_file.txt");

            while (true) {
                displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        displayFabricDetails(fabrics);
                        break;
                    case 2:
                        addNewFabric(scanner, fabrics);
                        break;
                    case 3:
                        displayEncryptedData(fabrics);
                        break;
                    case 4:
                        displayDecryptedData(fabrics);
                        break;
                    case 5:
                        displayFabricMapDetails(fabrics);
                        break;
                    case 6:
                        exitProgram(scanner);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== Fabric Data Management Menu =====");
        System.out.println("1. Display Fabric Details");
        System.out.println("2. Add New Fabric");
        System.out.println("3. Display Encrypted Data");
        System.out.println("4. Display Decrypted Data");
        System.out.println("5. Display Fabric Map Details");
        System.out.println("6. Exit");
        System.out.println("Enter your choice (1-6): ");
    }

    private static void displayFabricDetails(ArrayList<Fabric> fabrics) {
        // Display fabric details
        for (Fabric fabric : fabrics) {
            System.out.println(fabric);
        }
    }

    private static void addNewFabric(Scanner scanner, ArrayList<Fabric> fabrics) {
        System.out.println("Enter new Fabric data (Type Place Amount):");
        String newType = scanner.next();
        String newPlace = scanner.next();
        String newAmount = scanner.next();

        FabricBuilder fabricBuilder = FabricBuilder.getInstance();
        Fabric newFabric = fabricBuilder.setType(newType).setPlace(newPlace).setAmount(newAmount).build();
        fabrics.add(newFabric);

        System.out.println("New Fabric added successfully!");
    }

    private static void displayEncryptedData(ArrayList<Fabric> fabrics) {
        // Display encrypted data
        ArrayList<String> encryptedDataList = ContainerCreator.createEncryptedData(fabrics, SECRET_KEY);
        for (String encryptedData : encryptedDataList) {
            System.out.println(encryptedData);
        }
    }

    private static void displayDecryptedData(ArrayList<Fabric> fabrics) {
        ArrayList<String> encryptedDataList = ContainerCreator.createEncryptedData(fabrics, SECRET_KEY);
        for (String encryptedData : encryptedDataList) {
            System.out.println(encryptedData);
        }
    }

    private static void displayFabricMapDetails(ArrayList<Fabric> fabrics) {
        // Display fabric map details
        Map<String, Fabric> fabricMap = ContainerCreator.createFabricMap(fabrics);
        for (Map.Entry<String, Fabric> entry : fabricMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    private static void exitProgram(Scanner scanner) {
        System.out.println("Exiting the program. Goodbye!");
        scanner.close();
        System.exit(0);
    }
}
