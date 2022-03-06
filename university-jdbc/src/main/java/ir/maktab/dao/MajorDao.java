package ir.maktab.dao;

import ir.maktab.config.AppDataSource;
import ir.maktab.entity.Major;
import ir.maktab.exception.DataNotFoundException;
import ir.maktab.exception.ModificationDataException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MajorDao implements BaseDao<Major, Integer> {

    @Override
    public void save(Major entity) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO major (name) VALUES (?)")
        ) {
            ps.setString(1, entity.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not insert data to db");
        }
    }

    @Override
    public void update(Integer id, Major newEntity) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE major SET name = ? WHERE id = ?")
        ) {
            ps.setString(1, newEntity.getName());
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not update data to db");
        }

    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM major WHERE id = ?")
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ModificationDataException("Can not delete data from db");
        }
    }

    @Override
    public Major loadById(Integer id) {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM major WHERE id = ?")
        ) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                resultSet.next();
                int majorId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return new Major(majorId, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data in db");
        }
    }

    @Override
    public List<Major> loadAll() {
        try (Connection connection = AppDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM major");
             ResultSet resultSet = ps.executeQuery()
        ) {

            List<Major> majors = new ArrayList<>();
            while (resultSet.next()) {
                int majorId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                majors.add(new Major(majorId, name));
            }
            return majors;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Can not find data in db");
        }
    }

}
