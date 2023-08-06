package org.example.services;

import org.example.api.repositories.ClienteRepository;
import org.example.api.repositories.VendasClienteRepository;
import org.example.models.Cliente;
import org.example.models.VendasCliente;

import java.util.List;

public class VendasClienteService {
    private final ClienteRepository clienteRepository;
    private final VendasClienteRepository vendasClienteRepository;

    public VendasClienteService(ClienteRepository sqlClienteRepository, VendasClienteRepository sqlVendasClienteRepository) {
        this.clienteRepository = sqlClienteRepository;
        this.vendasClienteRepository = sqlVendasClienteRepository;
    }

    public Cliente getCliente(Integer cnpj) {
        return this.clienteRepository.consultar(cnpj);
    }

    public List<VendasCliente> getVendasCliente(Integer cnpj) {
        final Cliente cliente = this.clienteRepository.consultar(cnpj);
        return this.vendasClienteRepository.consultarPorCliente(cliente);
    }

    public List<VendasCliente> getVendasCliente(Cliente cliente) {
        return this.vendasClienteRepository.consultarPorCliente(cliente);
    }
}
