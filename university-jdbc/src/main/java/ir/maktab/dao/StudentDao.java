package ir.maktab.dao;

import ir.maktab.config.AppDataSource;
import ir.maktab.entity.Major;
import ir.maktab.entity.Student;
import ir.maktab.exception.DataNotFoundException;
import ir.maktab.exception.ModificationDataException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements BaseDao<Student, Integer> {

    @Override
    public void save(Student entity) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO student (name, family_name, m_id_fk) VALUES(?, ?, ?)")
        ) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getFamilyName());
            ps.setInt(3, entity.getMajor().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not insert data to db");
        }
    }

    @Override
    public void update(Integer id, Student newEntity) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE student SET name = ?, family_name = ?, m_id_fk = ? WHERE id = ?")
        ) {
            ps.setString(1, newEntity.getName());
            ps.setString(2, newEntity.getFamilyName());
            ps.setInt(3, newEntity.getMajor().getId());
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM student WHERE id = ?")
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }
    }

    @Override
    public Student loadById(Integer id) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM student WHERE id = ?")
        ) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                resultSet.next();
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String familyName = resultSet.getString("family_name");
                int majorId = resultSet.getInt("m_id_fk");
                // TODO: ۳۰/۱۰/۲۱ handel major name in service
                return Student.builder(new Major(majorId))
                        .id(studentId)
                        .name(name)
                        .familyName(familyName).build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data in db");
        }
    }

    @Override
    public List<Student> loadAll() {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM student");
             ResultSet resultSet = ps.executeQuery()
        ) {

            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String familyName = resultSet.getString("family_name");
                int majorId = resultSet.getInt("m_id_fk");
                Student student = Student.builder(new Major(majorId))
                        .id(studentId)
                        .name(name)
                        .familyName(familyName).build();
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data in db");
        }
    }

}
