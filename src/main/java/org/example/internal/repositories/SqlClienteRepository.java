package org.example.internal.repositories;

import org.example.api.database.ConnectionProvider;
import org.example.api.repositories.ClienteRepository;
import org.example.models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlClienteRepository implements ClienteRepository {
    private final ConnectionProvider connectionProvider;

    public SqlClienteRepository(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public Cliente consultar(Integer id) {
        try (final Connection con = this.connectionProvider.getConnection()) {
            final Cliente cliente = new Cliente();
            final PreparedStatement st = con.prepareStatement("SELECT * FROM clientes where cnpj = ?");
            st.setInt(1, id);
            final ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cliente.setCnpj(rs.getInt("cnpj"));
                cliente.setNome(rs.getString("nome"));
                return cliente;
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
