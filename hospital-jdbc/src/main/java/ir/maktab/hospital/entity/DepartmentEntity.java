package ir.maktab.hospital.entity;

public class DepartmentEntity extends BaseEntity<Long> {

    private String name;
    private String type;

    public DepartmentEntity(Long id, String name, String type) {
        super(id);
        this.name = name;
        this.type = type;
    }

    public DepartmentEntity(String name, String type) {
        this.name = name;
        this.type = type;
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
