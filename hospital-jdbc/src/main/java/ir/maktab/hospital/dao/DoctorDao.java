package ir.maktab.hospital.dao;

import ir.maktab.hospital.config.AppDataSource;
import ir.maktab.hospital.entity.DoctorEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorDao implements BaseDao<DoctorEntity, Long> {

    @Override
    public void save(DoctorEntity doctor) {
        final String query = "INSERT INTO doctor (name , profession, seniority) VALUES (?, ?, ?)";

        try (Connection connection = AppDataSource.getConnection();
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
    public DoctorEntity findById(Long doctorId) {
        final String query = "SELECT * FROM doctor WHERE id = ?";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, doctorId);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                Long id = resultSet.getLong(1);
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
