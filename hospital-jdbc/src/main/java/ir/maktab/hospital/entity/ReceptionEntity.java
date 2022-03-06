package ir.maktab.hospital.entity;

public class ReceptionEntity extends BaseEntity<Long> {

    private String receptionDate;
    private String dischargeDate;
    private Long patientId;
    private Long doctorId;

    public ReceptionEntity(Long id, String receptionDate, String dischargeDate, Long patientId, Long doctorId) {
        super(id);
        this.receptionDate = receptionDate;
        this.dischargeDate = dischargeDate;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public ReceptionEntity(String receptionDate, String dischargeDate, Long patientId, Long doctorId) {
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

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "ReceptionEntity{" +
                "id=" + getId() +
                ", receptionDate='" + receptionDate + '\'' +
                ", dischargeDate='" + dischargeDate + '\'' +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                '}';
    }

}
