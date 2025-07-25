//ٍRamadan Masadekh
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Drug {
    // attributes
    private int drugId;
    private String drugName;
    private double drugCost;
    private String dosage;

    // constructor
    public Drug(int drugId, String drugName, double drugCost, String dosage) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugCost = drugCost;
        this.dosage = dosage;
    }

    // getters
    public int getDrugId() {
        return drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public double getDrugCost() {
        return drugCost;
    }

    public String getDosage() {
        return dosage;
    }

    // setters
    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public void setDrugCost(double drugCost) {
        this.drugCost = drugCost;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    // method to save drug info to a text file
    public void saveToFile(String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(drugId + "," + drugName + "," + drugCost + "," + dosage);
            writer.newLine();
            writer.close();
            System.out.println("Drug saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}