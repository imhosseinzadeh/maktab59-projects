package ir.maktab.hospital.dao;

import ir.maktab.hospital.config.AppDataSource;
import ir.maktab.hospital.entity.SurgeryEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurgeryDao implements BaseDao<SurgeryEntity, Long> {

    @Override
    public void save(SurgeryEntity surgery) {
        final String query = "INSERT INTO surgery (date_time, patient_id) VALUES (?, ?)";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, surgery.getDateTime());
            ps.setInt(2, surgery.getPatientId());

            ps.executeUpdate();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

    }

    @Override
    public SurgeryEntity findById(Long surgeryId) {
        final String query = "SELECT * FROM surgery WHERE id = ?";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, surgeryId);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String dateTime = resultSet.getString(2);
                int patientId = resultSet.getInt(3);
                return new SurgeryEntity(id, dateTime, patientId);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }

}
