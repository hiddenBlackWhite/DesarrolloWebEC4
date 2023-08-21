package edu.pe.idat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.idat.model.Cliente;
import edu.pe.idat.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;

    
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    
    @Transactional
    public void eliminarClientePorId(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);

        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setFirstname(null);
            cliente.setLastname(null);
            cliente.setEmail(clienteActualizado.getEmail());
            cliente.setPhone(clienteActualizado.getPhone());

            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("No se encontró el cliente con el ID proporcionado");
        }
    }

}
