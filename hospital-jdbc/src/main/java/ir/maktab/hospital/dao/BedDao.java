package ir.maktab.hospital.dao;

import ir.maktab.hospital.config.MyDataSource;
import ir.maktab.hospital.entity.BedEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BedDao implements BaseDao<BedEntity> {

    @Override
    public void save(BedEntity bed) {
        final String query = "INSERT INTO bed (type , department_id) VALUES (?, ?)";

        try (Connection connection = MyDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, bed.getType());
            ps.setInt(2, bed.getDepartmentId());

            ps.executeUpdate();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

    }

    @Override
    public BedEntity findById(int bedId) {
        final String query = "SELECT * FROM bed WHERE id = ?";

        try (Connection connection = MyDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, bedId);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String type = resultSet.getString(2);
                int departmentId = resultSet.getInt(3);

                return new BedEntity(id, type, departmentId);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }

}
