package ir.maktab.hospital.dao;

import ir.maktab.hospital.config.MyDataSource;
import ir.maktab.hospital.entity.DoctorEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorDao implements BaseDao<DoctorEntity> {

    @Override
    public void save(DoctorEntity doctor) {
        final String query = "INSERT INTO doctor (name , profession, seniority) VALUES (?, ?, ?)";

        try (Connection connection = MyDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getProfession());
            ps.setString(3, doctor.getSeniority());

            ps.executeUpdate();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

    }

    @Override
    public DoctorEntity findById(int doctorId) {
        final String query = "SELECT * FROM doctor WHERE id = ?";

        try (Connection connection = MyDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, doctorId);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String profession = resultSet.getString(3);
                String seniority = resultSet.getString(4);

                return new DoctorEntity(id, name, profession, seniority);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }
}
