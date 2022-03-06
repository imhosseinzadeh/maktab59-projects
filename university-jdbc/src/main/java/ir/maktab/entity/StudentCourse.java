package ir.maktab.entity;

public class StudentCourse extends BaseEntity<Integer> {

    private Integer studentId;
    private Integer courseId;
    private String courseName;
    private Integer courseUnit;

    public StudentCourse(Integer studentId, Course course) {
        this.studentId = studentId;
        this.courseId = course.getId();
        this.courseName = course.getName();
        this.courseUnit = course.getUnit();
    }

    public StudentCourse(Integer id, Integer studentId, Course course) {
        super(id);
        this.studentId = studentId;
        this.courseId = course.getId();
        this.courseName = course.getName();
        this.courseUnit = course.getUnit();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(Integer courseUnit) {
        this.courseUnit = courseUnit;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + getId() +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }

}
