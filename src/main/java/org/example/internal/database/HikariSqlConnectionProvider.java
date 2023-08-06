package org.example.internal.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.api.database.ConnectionProvider;
import org.example.api.database.config.DataBaseConfig;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariSqlConnectionProvider implements ConnectionProvider {
    private HikariDataSource dataSource;

    public HikariSqlConnectionProvider(DataBaseConfig dataBaseConfig) {
        final HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:sqlserver://" + dataBaseConfig.getHost() + ";" +
                "databaseName=" + dataBaseConfig.getDatabase() +
                ";encrypt=true;trustServerCertificate=true;" +
                "user=" + dataBaseConfig.getUser() + ";password=" + dataBaseConfig.getPassword());
        config.setUsername(dataBaseConfig.getUser());
        config.setPassword(dataBaseConfig.getPassword());
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        this.dataSource = new HikariDataSource(config);

    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
