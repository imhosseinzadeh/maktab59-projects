package ir.maktab.presentation.cmd;

import ir.maktab.presentation.ui.Input;
import ir.maktab.service.CourseService;
import ir.maktab.service.StudentService;

public class AddCourseCmd implements MenuCommand {

    private final StudentService studentService = new StudentService();
    private final CourseService courseService = new CourseService();
    private final ShowUniversityCoursesCmd coursesCmd = new ShowUniversityCoursesCmd();

    @Override
    public int select() {
        return 4;
    }

    @Override
    public void execute() {
        coursesCmd.execute();
        System.out.println("Enter student id :");
        int studentId = Input.getInt();
        System.out.println("Enter course id : ");
        int addCourseId = Input.getInt();
        if (courseService.contains(addCourseId)) {
            if (!studentService.containsCourse(studentId, addCourseId)) {
                studentService.addCourse(studentId, addCourseId);
                System.out.println("---Course added---");
            } else {
                System.err.println("---course already added---");
            }
        } else {
            System.err.println("---Course not found---");
        }
    }
}
