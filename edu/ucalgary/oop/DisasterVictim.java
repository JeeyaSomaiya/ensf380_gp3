package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DisasterVictim {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String comments;
    private static int ASSIGNED_SOCIAL_ID;
    private int assignedSocialID;
    private MedicalRecord[] medicalRecords;
    private FamilyRelation[] familyConnections;
    private String ENTRY_DATE;
    private Supply[] personalBelongings;
    private String gender;
    private static int counter = 0;

    public DisasterVictim(String firstName, String ENTRY_DATE) {
        this.firstName = firstName;
        try {
            LocalDate.parse(ENTRY_DATE);
            this.ENTRY_DATE = ENTRY_DATE;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid entry date format");
        }
        this.assignedSocialID = ASSIGNED_SOCIAL_ID++;
        this.medicalRecords = new MedicalRecord[0];
        this.familyConnections = new FamilyRelation[0];
        this.personalBelongings = new Supply[0];
        counter++;
    }
    

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getComments() {
        return comments;
    }

    public MedicalRecord[] getMedicalRecords() {
        return medicalRecords;
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public int getAssignedSocialID() {
        return assignedSocialID;
    }

    public Supply[] getPersonalBelongings() {
        return personalBelongings;
    }

    public FamilyRelation[] getFamilyConnections() {
        return familyConnections;
    }

    public String getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        try {
            LocalDate.parse(dateOfBirth);
            this.dateOfBirth = dateOfBirth;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date of birth format");
        }
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setMedicalRecords(MedicalRecord[] medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public void setPersonalBelongings(Supply[] personalBelongings) {
        this.personalBelongings = personalBelongings;
    }
    
    public void setFamilyConnections(FamilyRelation[] familyConnections) {
        this.familyConnections = familyConnections;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void addPersonalBelonging(Supply supply) {
        Supply[] newBelongings = new Supply[personalBelongings.length + 1];
        System.arraycopy(personalBelongings, 0, newBelongings, 0, personalBelongings.length);
        newBelongings[personalBelongings.length] = supply;
        personalBelongings = newBelongings;
    }

    public void removePersonalBelonging(Supply supply) {
        int index = -1;
        for (int i = 0; i < personalBelongings.length; i++) {
            if (personalBelongings[i].equals(supply)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Supply[] newBelongings = new Supply[personalBelongings.length - 1];
            for (int i = 0, j = 0; i < personalBelongings.length; i++) {
                if (i != index) {
                    newBelongings[j++] = personalBelongings[i];
                }
            }
            personalBelongings = newBelongings;
        }
    }

    public void addFamilyConnection(FamilyRelation familyRelation) {
        FamilyRelation[] newConnections = new FamilyRelation[familyConnections.length + 1];
        System.arraycopy(familyConnections, 0, newConnections, 0, familyConnections.length);
        newConnections[familyConnections.length] = familyRelation;
        familyConnections = newConnections;
    }

    public void removeFamilyConnection(FamilyRelation familyRelation) {
        int index = -1;
        for (int i = 0; i < familyConnections.length; i++) {
            if (familyConnections[i].equals(familyRelation)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            FamilyRelation[] newConnections = new FamilyRelation[familyConnections.length - 1];
            for (int i = 0, j = 0; i < familyConnections.length; i++) {
                if (i != index) {
                    newConnections[j++] = familyConnections[i];
                }
            }
            familyConnections = newConnections;
        }
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        MedicalRecord[] newRecords = new MedicalRecord[medicalRecords.length + 1];
        System.arraycopy(medicalRecords, 0, newRecords, 0, medicalRecords.length);
        newRecords[medicalRecords.length] = medicalRecord;
        medicalRecords = newRecords;
    }
}