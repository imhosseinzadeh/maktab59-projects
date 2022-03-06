package ir.maktab.hospital.dao;

import ir.maktab.hospital.config.AppDataSource;
import ir.maktab.hospital.entity.PatientEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDao implements BaseDao<PatientEntity> {

    @Override
    public void save(PatientEntity patient) {
        final String query = "INSERT INTO patient (address, name, age, date_of_birth, gender) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, patient.getAddress());
            ps.setString(2, patient.getName());
            ps.setInt(3, patient.getAge());
            ps.setString(4, patient.getDateOfBirth());
            ps.setString(5, patient.getGender());

            ps.executeUpdate();

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

    }

    @Override
    public PatientEntity findById(int patientId) {
        final String query = "SELECT * FROM patient WHERE id = ?";

        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, patientId);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String address = resultSet.getString(2);
                String name = resultSet.getString(3);
                int age = resultSet.getInt(4);
                String dataOfBirth = resultSet.getString(5);
                String gender = resultSet.getString(6);

                return new PatientEntity(id, address, name, age, dataOfBirth, gender);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }
}
