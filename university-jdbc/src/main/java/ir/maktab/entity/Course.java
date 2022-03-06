package ir.maktab.entity;

public class Course extends BaseEntity<Integer> {

    private String name;
    private Integer unit;

    public Course(Integer id, String name, Integer unit) {
        super(id);
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", unit=" + unit +
                '}';
    }
}
