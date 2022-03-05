package ir.maktab.hospital.entity;

public class SurgeryEntity extends BaseEntity {

    private String dateTime;
    private int patientId;

    public SurgeryEntity(int id, String dateTime, int patientId) {
        super(id);
        this.dateTime = dateTime;
        this.patientId = patientId;
    }

    public SurgeryEntity(String dateTime, int patientId) {
        this.dateTime = dateTime;
        this.patientId = patientId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Surgery{" +
                "id=" + getId() +
                ", dateTime='" + dateTime + '\'' +
                ", patientId=" + patientId +
                '}';
    }

}
