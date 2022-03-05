package ir.maktab.hospital.entity;

public class BedEntity extends BaseEntity {

    private String type;
    private int departmentId;

    public BedEntity(int id, String type, int departmentId) {
        super(id);
        this.type = type;
        this.departmentId = departmentId;
    }

    public BedEntity(String type, int departmentId) {
        this.type = type;
        this.departmentId = departmentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id=" + getId() +
                ", type='" + type + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }

}
