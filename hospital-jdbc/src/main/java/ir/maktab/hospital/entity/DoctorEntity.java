package ir.maktab.hospital.entity;

public class DoctorEntity implements BaseEntity<Long> {

    private Long id;
    private String name;
    private String profession;
    private String seniority;

    public DoctorEntity(Long id, String name, String profession, String seniority) {
        this.id = id;
        this.name = name;
        this.profession = profession;
        this.seniority = seniority;
    }

    public DoctorEntity(String name, String profession, String seniority) {
        this.name = name;
        this.profession = profession;
        this.seniority = seniority;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
