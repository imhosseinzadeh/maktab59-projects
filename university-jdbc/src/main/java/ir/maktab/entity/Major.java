package ir.maktab.entity;

public class Major extends BaseEntity<Integer> {

    private String name;

    public Major(Integer id) {
        super(id);
    }

    public Major(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }

}
