import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDatabase {

    // This method saves a patient to the database
    public static void savePatient(Patient p) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // connect to the database
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/clinic", "postgres", "admin"
            );

            // insert patient into the table
            String sql = "INSERT INTO patients (patientId, patientFirstName, patientLastName, patientDOB) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

 
            stmt.setInt(1, p.getPatientId());
            stmt.setString(2, p.getPatientFirstName());
            stmt.setString(3, p.getPatientLastName());
            stmt.setString(4, p.getPatientDOB());

            stmt.executeUpdate();
            System.out.println("Patient saved to database.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // This method displays all patients from the database
    public static void displayAllPatients() {
        Connection conn = null;
        Statement stmt = null;

        try {
            // connect to the database
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/clinic", "postgres", "admin"
            );

            stmt = conn.createStatement();
            String sql = "SELECT * FROM patients";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("List of patients:");
            while (rs.next()) {
                int id = rs.getInt("patientId");
                String firstName = rs.getString("patientFirstName");
                String lastName = rs.getString("patientLastName");
                String dob = rs.getString("patientDOB");

                System.out.println(id + ", " + firstName + ", " + lastName + ", " + dob);
            }

            rs.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}