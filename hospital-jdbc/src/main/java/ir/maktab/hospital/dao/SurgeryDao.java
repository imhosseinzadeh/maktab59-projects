package ir.maktab.hospital.dao;

import ir.maktab.hospital.config.MyDataSource;
import ir.maktab.hospital.entity.SurgeryEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SurgeryDao implements BaseDao<SurgeryEntity> {

    @Override
    public void save(SurgeryEntity surgery) {
        final String query = "INSERT INTO surgery (date_time, patient_id) VALUES (?, ?)";

        try (Connection connection = MyDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, surgery.getDateTime());
            ps.setInt(2, surgery.getPatientId());

            ps.executeUpdate();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

    }

    @Override
    public SurgeryEntity findById(int surgeryId) {
        final String query = "SELECT * FROM surgery WHERE id = ?";

        try (Connection connection = MyDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, surgeryId);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
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
