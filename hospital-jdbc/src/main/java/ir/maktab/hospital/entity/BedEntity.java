package ir.maktab.hospital.entity;

public class BedEntity extends BaseEntity<Long> {

    private String type;
    private Long departmentId;

    public BedEntity(Long id, String type, Long departmentId) {
        super(id);
        this.type = type;
        this.departmentId = departmentId;
    }

    public BedEntity(String type, Long departmentId) {
        this.type = type;
        this.departmentId = departmentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "BedEntity{" +
                "id=" + getId() +
                ", type='" + type + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }

}
