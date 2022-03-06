package ir.maktab.hospital.entity;

public class SurgeryDoctor implements BaseEntity<Long> {

    private Long id;
    private int surgeryId;
    private int doctorId;

    public SurgeryDoctor(Long id, int surgeryId, int doctorId) {
        this.id = id;
        this.surgeryId = surgeryId;
        this.doctorId = doctorId;
    }

    public SurgeryDoctor(int surgeryId, int doctorId) {
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

    public int getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(int surgeryId) {
        this.surgeryId = surgeryId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
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
