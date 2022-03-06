package ir.maktab.presentation.cmd;

import ir.maktab.entity.Course;
import ir.maktab.presentation.ui.Input;
import ir.maktab.service.StudentService;

import java.util.List;

public class ShowStudentCourseCmd implements MenuCommand {

    private final StudentService studentService = new StudentService();

    @Override
    public int select() {
        return 3;
    }

    @Override
    public void execute() {
        System.out.println("Enter studentId :");
        List<Course> courseList = studentService.loadCourses(Input.getInt());
        int num = 1;
        System.out.println("===Student Courses===");
        for (Course course : courseList) {
            System.out.format("%d)" + course + "\n", num++);
        }
        System.out.println();
    }
}
