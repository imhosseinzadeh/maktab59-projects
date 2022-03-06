package ir.maktab.presentation.cmd;

import ir.maktab.entity.Course;
import ir.maktab.presentation.ui.Input;
import ir.maktab.service.CourseService;
import ir.maktab.service.StudentService;

import java.util.List;

public class RemoveCourseCmd implements MenuCommand {

    private final CourseService courseService = new CourseService();
    private final StudentService studentService = new StudentService();

    @Override
    public int select() {
        return 5;
    }

    @Override
    public void execute() {
        System.out.println("Enter student id");
        int studentId = Input.getInt();
        printStudentCourse(studentId);
        System.out.println("Enter course id : ");
        int courseId = Input.getInt();
        if (courseService.contains(studentId)) {
            studentService.deleteCourse(studentId, courseId);
            System.out.println("---Course removed---");
        } else {
            System.err.println("Course not found");
        }
    }

    private void printStudentCourse(int studentId) {
        List<Course> courseList = studentService.loadCourses(studentId);
        int num = 1;
        System.out.println("===Student Courses===");
        for (Course course : courseList) {
            System.out.format("%d)" + course + "\n", num++);
        }
    }
}
