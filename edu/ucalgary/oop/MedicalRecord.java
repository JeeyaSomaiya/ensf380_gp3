package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MedicalRecord {
    private Location location;
    private String treatmentDetails;
    private String dateOfTreatment;

    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) {
        this.location = location;
        this.treatmentDetails = treatmentDetails;
        this.dateOfTreatment = dateOfTreatment;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }

    public String getDateOfTreatment() {
        return dateOfTreatment;
    }

    public void setDateOfTreatment(String dateOfTreatment) {
    try {
        LocalDate.parse(dateOfTreatment);
    } catch (DateTimeParseException e) {
        throw new IllegalArgumentException("Invalid date format for date of treatment");
    }
    this.dateOfTreatment = dateOfTreatment;
}

}
