package com.gestioneden.service;

import com.gestioneden.entity.Cliente;
import com.gestioneden.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Obtiene todos los clientes registrados
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // Busca un cliente por su identificador
    public Optional<Cliente> buscarPorId(Integer id) {
        return clienteRepository.findById(id);
    }

    // Registra o actualiza un cliente
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Elimina un cliente por su identificador
    public void eliminar(Integer id) {
        clienteRepository.deleteById(id);
    }
}