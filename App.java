import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Clinic System Menu ===");
            System.out.println("1. Add Drug to File");
            System.out.println("2. Add Patient to Database");
            System.out.println("3. Display Patients from Database");
            System.out.println("4. Display Drugs from File");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Drug ID: ");
                    int drugId = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter Drug Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Drug Cost: ");
                    double cost = input.nextDouble();
                    input.nextLine();
                    System.out.print("Enter Dosage: ");
                    String dosage = input.nextLine();

                    Drug drug = new Drug(drugId, name, cost, dosage);
                    drug.saveToFile("drugs.txt");
                    break;

                case 2:
                    System.out.print("Enter Patient ID: ");
                    int pid = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter First Name: ");
                    String fname = input.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lname = input.nextLine();
                    System.out.print("Enter DOB (YYYY-MM-DD): ");
                    String dob = input.nextLine();

                    Patient p = new Patient(pid, fname, lname, dob);
                    PatientDatabase.savePatient(p);
                    break;

                case 3:
                    PatientDatabase.displayAllPatients();
                    break;

                case 4:
                    System.out.println("List of drugs:");
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("drugs.txt"));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("Error reading file: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        input.close();
    }
}