package ir.maktab.hospital.entity;

public class SurgeryDoctor implements BaseEntity<Long> {

    private Long id;
    private Long surgeryId;
    private Long doctorId;

    public SurgeryDoctor(Long id, Long surgeryId, Long doctorId) {
        this.id = id;
        this.surgeryId = surgeryId;
        this.doctorId = doctorId;
    }

    public SurgeryDoctor(Long surgeryId, Long doctorId) {
        this.surgeryId = surgeryId;
        this.doctorId = doctorId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", surgeryId=" + surgeryId +
                ", doctorId=" + doctorId +
                '}';
    }

}
