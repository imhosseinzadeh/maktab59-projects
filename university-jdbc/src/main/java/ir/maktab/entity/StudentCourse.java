package ir.maktab.entity;

import java.util.Objects;

public class StudentCourse implements BaseEntity<Integer> {
    private Integer id;
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
        this.id = id;
        this.studentId = studentId;
        this.courseId = course.getId();
        this.courseName = course.getName();
        this.courseUnit = course.getUnit();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourse that = (StudentCourse) o;
        return Objects.equals(id, that.id) && Objects.equals(studentId, that.studentId) && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, courseId);
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }

}
