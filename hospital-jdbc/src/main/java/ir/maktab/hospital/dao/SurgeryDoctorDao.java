package ir.maktab.hospital.dao;

import ir.maktab.hospital.config.AppDataSource;
import ir.maktab.hospital.entity.SurgeryDoctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurgeryDoctorDao implements BaseDao<SurgeryDoctor> {

    @Override
    public void save(SurgeryDoctor surgeryDoctor) {
        final String query = "INSERT INTO SurgeryDoctor (surgery_id, doctor_id) VALUES (?, ?)";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, surgeryDoctor.getSurgeryId());
            ps.setInt(2, surgeryDoctor.getDoctorId());

            ps.executeUpdate();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

    }

    @Override
    public SurgeryDoctor findById(int surgeryDoctorId) {
        final String query = "SELECT * FROM SurgeryDoctor WHERE id = ?";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, surgeryDoctorId);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                Long id = resultSet.getLong(1);
                int surgeryId = resultSet.getInt(2);
                int doctorId = resultSet.getInt(3);
                return new SurgeryDoctor(id, surgeryId, doctorId);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }

}
