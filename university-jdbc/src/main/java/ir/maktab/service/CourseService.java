package ir.maktab.service;

import ir.maktab.dao.CourseDao;
import ir.maktab.entity.Course;

public class CourseService extends AbstractCrudService<Course, Integer> {

    public CourseService() {
        setBaseDao(new CourseDao());
    }

    @Override
    public CourseDao getBaseDao() {
        return (CourseDao) super.getBaseDao();
    }
}
