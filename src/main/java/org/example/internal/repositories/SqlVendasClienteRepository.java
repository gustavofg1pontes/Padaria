package org.example.internal.repositories;

import org.example.api.database.ConnectionProvider;
import org.example.api.repositories.VendasClienteRepository;
import org.example.models.Cliente;
import org.example.models.VendasCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SqlVendasClienteRepository implements VendasClienteRepository {
    private final ConnectionProvider connectionProvider;

    public SqlVendasClienteRepository(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public List<VendasCliente> consultarPorCliente(Cliente cliente) {
        try (final Connection con = this.connectionProvider.getConnection()) {
            final List<VendasCliente> vendasPorCliente = new ArrayList<>();
            final PreparedStatement st = con
                    .prepareStatement("SELECT * FROM vendas_clientes where cnpj = ?");
            st.setInt(1, cliente.getCnpj());
            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                VendasCliente vendasCliente = new VendasCliente();
                vendasCliente.setCodigo(rs.getInt("codigo"));
                vendasCliente.setCnpj(rs.getInt("cnpj"));
                vendasCliente.setDataVenda(
                        LocalDate.parse(rs.getString("data_venda"),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                vendasCliente.setValor(rs.getFloat("valor"));
                vendasCliente.setToneladas(rs.getFloat("toneladas"));
                vendasPorCliente.add(vendasCliente);
            }
            st.close();
            return vendasPorCliente;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public VendasCliente consultar(Integer id) {
        try (final Connection con = this.connectionProvider.getConnection()) {
            final VendasCliente vendasCliente = new VendasCliente();
            final PreparedStatement st = con.prepareStatement("SELECT * FROM vendas_clientes where codigo = ?");
            st.setInt(1, id);
            final ResultSet rs = st.executeQuery();
            if (rs.next()) {
                vendasCliente.setCodigo(rs.getInt("codigo"));
                vendasCliente.setCnpj(rs.getInt("cnpj"));
                vendasCliente.setDataVenda(
                        LocalDate.parse(rs.getString("data_venda"),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                vendasCliente.setValor(rs.getFloat("valor"));
                vendasCliente.setToneladas(rs.getFloat("toneladas"));
                return vendasCliente;
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
