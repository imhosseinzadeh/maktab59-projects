package ir.maktab.hospital.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MyDataSource {

    private static final HikariConfig CONFIG = new HikariConfig();
    private static final HikariDataSource HIKARI_DATA_SOURCE;

    private MyDataSource() {
    }

    static {
        CONFIG.setJdbcUrl(DbConfig.URL);
        CONFIG.setUsername(DbConfig.USERNAME);
        CONFIG.setPassword(DbConfig.PASSWORD);
        CONFIG.addDataSourceProperty("cachePrepStmts", "true");
        CONFIG.addDataSourceProperty("prepStmtCacheSize", "250");
        CONFIG.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HIKARI_DATA_SOURCE = new HikariDataSource(CONFIG);
    }

    public static Connection getConnection() throws SQLException {
        return HIKARI_DATA_SOURCE.getConnection();
    }

}
