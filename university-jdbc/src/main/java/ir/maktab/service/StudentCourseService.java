package ir.maktab.service;

import ir.maktab.dao.StudentCourseDao;
import ir.maktab.entity.StudentCourse;

public class StudentCourseService extends AbstractCrudService<StudentCourse, Integer> {

    public StudentCourseService() {
        setBaseDao(new StudentCourseDao());
    }

    @Override
    public StudentCourseDao getBaseDao() {
        return (StudentCourseDao) super.getBaseDao();
    }

}
