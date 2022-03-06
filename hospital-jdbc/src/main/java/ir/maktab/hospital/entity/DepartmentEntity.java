package ir.maktab.hospital.entity;

public class DepartmentEntity implements BaseEntity<Long> {

    private Long id;
    private String name;
    private String type;

    public DepartmentEntity(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public DepartmentEntity(String name, String type) {
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
