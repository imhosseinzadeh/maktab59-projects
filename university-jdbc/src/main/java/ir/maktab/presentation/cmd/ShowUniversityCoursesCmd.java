package ir.maktab.presentation.cmd;

import ir.maktab.entity.Course;
import ir.maktab.service.CourseService;

import java.util.List;

public class ShowUniversityCoursesCmd implements MenuCommand {

    private final CourseService courseService = new CourseService();

    @Override
    public int select() {
        return 2;
    }

    @Override
    public void execute() {
        List<Course> courseList = courseService.loadAll();
        int num = 1;
        System.out.println("===University Courses===");
        for (Course course : courseList) {
            System.out.format("%d)" + course + "\n", num++);
        }
        System.out.println();
    }
}
