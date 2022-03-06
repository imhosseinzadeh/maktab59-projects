package ir.maktab.hospital.dao;

import ir.maktab.hospital.config.AppDataSource;
import ir.maktab.hospital.entity.ReceptionEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceptionDao implements BaseDao<ReceptionEntity> {

    @Override
    public void save(ReceptionEntity reception) {
        final String query = "INSERT INTO reception (reception_date , discharge_date, patient_id , doctor_id) VALUES (?, ?, ?, ?)";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, reception.getReceptionDate());
            ps.setString(2, reception.getDischargeDate());
            ps.setLong(3, reception.getPatientId());
            ps.setLong(4, reception.getDoctorId());

            ps.executeUpdate();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

    }

    @Override
    public ReceptionEntity findById(int receptionId) {
        final String query = "SELECT * FROM reception WHERE id = ?";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, receptionId);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String receptionDate = resultSet.getString(2);
                String dischargeDate = resultSet.getString(3);
                Long patientId = resultSet.getLong(4);
                Long doctorId = resultSet.getLong(5);

                return new ReceptionEntity(id, receptionDate, dischargeDate, patientId, doctorId);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }
}
