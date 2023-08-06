package org.example.api.repositories;

import org.example.api.repositories.base.RepositoryBase;
import org.example.models.Cliente;
import org.example.models.VendasCliente;

import java.util.List;

public interface VendasClienteRepository extends RepositoryBase<Integer, VendasCliente> {
    public List<VendasCliente> consultarPorCliente(Cliente cliente);
}
