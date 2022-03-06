package ir.maktab.hospital.dao;

import ir.maktab.hospital.config.AppDataSource;
import ir.maktab.hospital.entity.BedEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BedDao implements BaseDao<BedEntity> {

    @Override
    public void save(BedEntity bed) {
        final String query = "INSERT INTO bed (type , department_id) VALUES (?, ?)";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, bed.getType());
            ps.setLong(2, bed.getDepartmentId());

            ps.executeUpdate();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

    }

    @Override
    public BedEntity findById(int bedId) {
        final String query = "SELECT * FROM bed WHERE id = ?";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, bedId);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String type = resultSet.getString(2);
                Long departmentId = resultSet.getLong(3);

                return new BedEntity(id, type, departmentId);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }

}
