package ir.maktab.hospital.entity;

public class SurgeryDoctor extends BaseEntity {

    private int surgeryId;
    private int doctorId;

    public SurgeryDoctor(int id, int surgeryId, int doctorId) {
        super(id);
        this.surgeryId = surgeryId;
        this.doctorId = doctorId;
    }

    public SurgeryDoctor(int surgeryId, int doctorId) {
        this.surgeryId = surgeryId;
        this.doctorId = doctorId;
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
                "id=" + getId() +
                ", surgeryId=" + surgeryId +
                ", doctorId=" + doctorId +
                '}';
    }

}
