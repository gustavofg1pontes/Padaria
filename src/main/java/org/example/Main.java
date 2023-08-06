package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.api.database.config.DataBaseConfig;
import org.example.internal.database.HikariSqlConnectionProvider;
import org.example.internal.repositories.SqlClienteRepository;
import org.example.internal.repositories.SqlVendasClienteRepository;
import org.example.services.VendasClienteService;

public class Main {
    public static void main(String[] args) {
        final Dotenv dotenv = Dotenv.configure().load();
        final DataBaseConfig dataBaseConfig = providesDatabaseConfig(dotenv);
        final HikariSqlConnectionProvider sqlConnection = new HikariSqlConnectionProvider(dataBaseConfig);
        final SqlClienteRepository sqlClienteRepository = new SqlClienteRepository(sqlConnection);
        final SqlVendasClienteRepository sqlVendasClienteRepository = new SqlVendasClienteRepository(sqlConnection);
        final VendasClienteService vendasClienteService = new VendasClienteService(sqlClienteRepository, sqlVendasClienteRepository);
        new MainFrame(vendasClienteService);
    }

    private static DataBaseConfig providesDatabaseConfig(Dotenv dotenv) {
        final DataBaseConfig databaseConfig = new DataBaseConfig();
        databaseConfig.setDatabase(dotenv.get("DATABASE"));
        databaseConfig.setHost(dotenv.get("HOST"));
        databaseConfig.setPassword(dotenv.get("PASSWORD"));
        databaseConfig.setUser(dotenv.get("USER"));
        return databaseConfig;
    }
}