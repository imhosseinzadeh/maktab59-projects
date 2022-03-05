package ir.maktab.hospital.entity;

public class ReceptionEntity extends BaseEntity {

    private String receptionDate;
    private String dischargeDate;
    private int patientId;
    private int doctorId;

    public ReceptionEntity(int id, String receptionDate, String dischargeDate, int patientId, int doctorId) {
        super(id);
        this.receptionDate = receptionDate;
        this.dischargeDate = dischargeDate;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public ReceptionEntity(String receptionDate, String dischargeDate, int patientId, int doctorId) {
        this.receptionDate = receptionDate;
        this.dischargeDate = dischargeDate;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public String getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(String receptionDate) {
        this.receptionDate = receptionDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "Reception{" +
                "receptionNumber=" + getId() +
                ", receptionDate='" + receptionDate + '\'' +
                ", dischargeDate='" + dischargeDate + '\'' +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                '}';
    }

}
