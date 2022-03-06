package ir.maktab.hospital.dao;

import ir.maktab.hospital.config.AppDataSource;
import ir.maktab.hospital.entity.DepartmentEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDao implements BaseDao<DepartmentEntity> {

    public void save(DepartmentEntity department) {
        final String query = "INSERT INTO department (name , type) VALUES (?, ?)";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, department.getName());
            ps.setString(2, department.getType());

            ps.executeUpdate();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

    }

    public DepartmentEntity findById(int departmentId) {
        final String query = "SELECT * FROM department WHERE id = ?";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, departmentId);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String type = resultSet.getString(3);

                return new DepartmentEntity(id, name, type);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }

}
