package ir.maktab.dao;

import ir.maktab.config.AppDataSource;
import ir.maktab.entity.Course;
import ir.maktab.exception.DataNotFoundException;
import ir.maktab.exception.ModificationDataException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao implements BaseDao<Course, Integer> {

    @Override
    public void save(Course entity) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO course(name, unit) VALUES (?, ?)")
        ) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getUnit());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not insert data to db");
        }

    }

    @Override
    public void update(Integer id, Course newEntity) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE course SET name = ?, unit = ? WHERE id = ?")
        ) {
            ps.setString(1, newEntity.getName());
            ps.setInt(2, newEntity.getUnit());
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM course WHERE id = ?")
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not delete data from db");
        }
    }

    @Override
    public Course loadById(Integer id) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM course WHERE id = ?")
        ) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                resultSet.next();
                int courseId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int unit = resultSet.getInt("unit");
                return new Course(courseId, name, unit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data in db");
        }
    }

    @Override
    public List<Course> loadAll() {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM course");
             ResultSet resultSet = ps.executeQuery()
        ) {
            List<Course> courses = new ArrayList<>();
            while (resultSet.next()) {
                int courseId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int unit = resultSet.getInt("unit");
                courses.add(new Course(courseId, name, unit));
            }
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data in db");
        }
    }

}
