package ir.maktab.hospital.entity;

public class DoctorEntity extends BaseEntity {

    private String name;
    private String profession;
    private String seniority;

    public DoctorEntity(int id, String name, String profession, String seniority) {
        super(id);
        this.name = name;
        this.profession = profession;
        this.seniority = seniority;
    }

    public DoctorEntity(String name, String profession, String seniority) {
        this.name = name;
        this.profession = profession;
        this.seniority = seniority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", seniority='" + seniority + '\'' +
                '}';
    }

}
