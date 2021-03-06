package ir.maktab.hospital.dao;

import ir.maktab.hospital.config.AppDataSource;
import ir.maktab.hospital.entity.SurgeryDoctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurgeryDoctorDao implements BaseDao<SurgeryDoctor, Long> {

    @Override
    public void save(SurgeryDoctor surgeryDoctor) {
        final String query = "INSERT INTO SurgeryDoctor (surgery_id, doctor_id) VALUES (?, ?)";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, surgeryDoctor.getSurgeryId());
            ps.setLong(2, surgeryDoctor.getDoctorId());

            ps.executeUpdate();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

    }

    @Override
    public SurgeryDoctor findById(Long surgeryDoctorId) {
        final String query = "SELECT * FROM SurgeryDoctor WHERE id = ?";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, surgeryDoctorId);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                Long id = resultSet.getLong(1);
                Long surgeryId = resultSet.getLong(2);
                Long doctorId = resultSet.getLong(3);
                return new SurgeryDoctor(id, surgeryId, doctorId);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }

}
