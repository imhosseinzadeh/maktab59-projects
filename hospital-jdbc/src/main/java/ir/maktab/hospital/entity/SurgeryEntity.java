package ir.maktab.hospital.entity;

public class SurgeryEntity implements BaseEntity<Long> {

    private Long id;
    private String dateTime;
    private int patientId;

    public SurgeryEntity(Long id, String dateTime, int patientId) {
        this.id = id;
        this.dateTime = dateTime;
        this.patientId = patientId;
    }

    public SurgeryEntity(String dateTime, int patientId) {
        this.dateTime = dateTime;
        this.patientId = patientId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", dateTime='" + dateTime + '\'' +
                ", patientId=" + patientId +
                '}';
    }

}
