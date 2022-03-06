package ir.maktab.hospital.entity;

public class BedEntity implements BaseEntity<Long> {

    private Long id;
    private String type;
    private Long departmentId;

    public BedEntity(Long id, String type, Long departmentId) {
        this.id = id;
        this.type = type;
        this.departmentId = departmentId;
    }

    public BedEntity(String type, Long departmentId) {
        this.type = type;
        this.departmentId = departmentId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", type='" + type + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }

}
