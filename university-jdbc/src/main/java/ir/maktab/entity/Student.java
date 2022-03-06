package ir.maktab.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student implements BaseEntity<Integer> {
    private Integer id;
    private String name;
    private String familyName;
    private Major major;
    private Set<Course> courses;

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.familyName = builder.familyName;
        this.major = builder.major;
        this.courses = builder.courses;
    }

    public static StudentBuilder builder(Major major) {
        return new StudentBuilder(major);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        if (courses == null) {
            courses = new HashSet<>();
        }
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", major=" + major +
                ", courses=" + courses +
                '}';
    }

    public static class StudentBuilder {
        private Integer id;
        private String name;
        private String familyName;
        private Major major;
        private Set<Course> courses;

        //mandatory items
        private StudentBuilder(Major major) {
            this.major = major;
        }

        public StudentBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder familyName(String familyName) {
            this.familyName = familyName;
            return this;
        }

        public StudentBuilder major (Major major){
            this.major = major;
            return this;
        }

        public StudentBuilder courses(Set<Course> courses) {
            this.courses = courses;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

}
