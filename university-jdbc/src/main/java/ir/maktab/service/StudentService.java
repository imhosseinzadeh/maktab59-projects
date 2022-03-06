package ir.maktab.service;

import ir.maktab.dao.StudentCourseDao;
import ir.maktab.dao.StudentDao;
import ir.maktab.entity.Course;
import ir.maktab.entity.Student;
import ir.maktab.entity.StudentCourse;

import java.util.List;

public class StudentService extends AbstractCrudService<Student, Integer> {

    StudentCourseDao studentCourseDao = new StudentCourseDao();
    CourseService courseService = new CourseService();

    public StudentService() {
        setBaseDao(new StudentDao());
    }

    @Override
    public StudentDao getBaseDao() {
        return (StudentDao) super.getBaseDao();
    }

    public void addCourse(Integer studentId, int courseId) {
        Course addCourse = courseService.loadById(courseId);
        studentCourseDao.save(new StudentCourse(studentId, addCourse));
    }

    public void deleteCourse(Integer studentId, Integer courseId) {
        studentCourseDao.delete(studentId, courseId);
    }

    public boolean containsCourse(Integer studentId, Integer courseId) {
        return studentCourseDao.containsByStudentIdAndCourseId(studentId, courseId);
    }

    public List<Course> loadCourses(Integer studentId) {
        return studentCourseDao.loadAllByStudentId(studentId);
    }
}
