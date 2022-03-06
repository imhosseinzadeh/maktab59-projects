package ir.maktab.dao;

import ir.maktab.config.AppDataSource;
import ir.maktab.entity.Course;
import ir.maktab.entity.StudentCourse;
import ir.maktab.exception.DataNotFoundException;
import ir.maktab.exception.ModificationDataException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseDao implements BaseDao<StudentCourse, Integer> {

    @Override
    public void save(StudentCourse entity) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into student_course(student_id, course_id, course_name, course_unit)values (?, ?, ?, ?)")
        ) {
            ps.setInt(1, entity.getStudentId());
            ps.setInt(2, entity.getCourseId());
            ps.setString(3, entity.getCourseName());
            ps.setInt(4, entity.getCourseUnit());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not insert data to db");
        }
    }

    @Override
    public void update(Integer id, StudentCourse newEntity) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE student_course SET course_id = ? WHERE id = ?")
        ) {
            ps.setInt(1, newEntity.getCourseId());
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM student_course WHERE id = ?")
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }
    }

    public void delete(Integer studentId, Integer courseId) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM student_course WHERE student_id = ? AND course_id = ?")
        ) {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }
    }

    @Override
    public StudentCourse loadById(Integer id) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM student_course WHERE id = ?")
        ) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                resultSet.next();
                int rowId = resultSet.getInt("id");
                int studentId = resultSet.getInt("student_id");
                int courseId = resultSet.getInt("course_id");
                String courseName = resultSet.getString("course_name");
                int courseUnit = resultSet.getInt("course_unit");
                Course course = new Course(courseId, courseName, courseUnit);
                return new StudentCourse(rowId, studentId, course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data in db");
        }
    }

    public StudentCourse loadByStudentCourse(Integer id) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM student_course WHERE id = ?")
        ) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                resultSet.next();
                int rowId = resultSet.getInt("id");
                int studentId = resultSet.getInt("student_id");
                int courseId = resultSet.getInt("course_id");
                String courseName = resultSet.getString("course_name");
                int courseUnit = resultSet.getInt("course_unit");
                Course course = new Course(courseId, courseName, courseUnit);
                return new StudentCourse(rowId, studentId, course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data in db");
        }
    }

    @Override
    public List<StudentCourse> loadAll() {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM student_course");
             ResultSet resultSet = ps.executeQuery()
        ) {
            List<StudentCourse> studentCourses = new ArrayList<>();
            while (resultSet.next()) {
                int rowId = resultSet.getInt("id");
                studentCourses.add(loadById(rowId));
            }
            return studentCourses;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data in db");
        }
    }

    public boolean containsByStudentIdAndCourseId(Integer studentId, Integer courseId) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM student_course WHERE student_id = ? AND course_id = ?")
        ) {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data in db");
        }
        return false;
    }

    public List<Course> loadAllByStudentId(Integer studentId) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM student_course where student_id = ?")
        ) {
            ps.setInt(1, studentId);
            try (ResultSet resultSet = ps.executeQuery()) {
                List<Course> courses = new ArrayList<>();
                while (resultSet.next()) {
                    int courseId = resultSet.getInt("course_id");
                    String courseName = resultSet.getString("course_name");
                    int courseUnit = resultSet.getInt("course_unit");
                    courses.add(new Course(courseId, courseName, courseUnit));
                }
                return courses;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data in db");
        }
    }

}
