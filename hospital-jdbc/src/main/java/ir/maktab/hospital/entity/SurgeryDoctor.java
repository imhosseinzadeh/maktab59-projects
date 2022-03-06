package ir.maktab.hospital.entity;

public class SurgeryDoctor extends BaseEntity<Long> {

    private Long surgeryId;
    private Long doctorId;

    public SurgeryDoctor(Long id, Long surgeryId, Long doctorId) {
        super(id);
        this.surgeryId = surgeryId;
        this.doctorId = doctorId;
    }

    public SurgeryDoctor(Long surgeryId, Long doctorId) {
        this.surgeryId = surgeryId;
        this.doctorId = doctorId;
    }

    public Long getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(Long surgeryId) {
        this.surgeryId = surgeryId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "SurgeryDoctor{" +
                "id=" + getId() +
                ", surgeryId=" + surgeryId +
                ", doctorId=" + doctorId +
                '}';
    }

}
