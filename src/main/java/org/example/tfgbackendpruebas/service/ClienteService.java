package org.example.tfgbackendpruebas.service;

import org.example.tfgbackendpruebas.dto.request.ClienteRequest;
import org.example.tfgbackendpruebas.dto.response.ClienteResponse;
import org.example.tfgbackendpruebas.exception.ResourceNotFoundException;
import org.example.tfgbackendpruebas.model.Cliente;
import org.example.tfgbackendpruebas.model.Usuario;
import org.example.tfgbackendpruebas.repository.ClienteRepository;
import org.example.tfgbackendpruebas.repository.UsuarioRepository;
import org.example.tfgbackendpruebas.util.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired private ClienteRepository clienteRepo;
    @Autowired private UsuarioRepository usuarioRepo;

    public List<ClienteResponse> getAll() {
        // Solo clientes con usuario activo (borrado lógico)
        return clienteRepo.findAll().stream()
                .filter(c -> c.getUsuario().isActivo())
                .map(UsuarioMapper::toClienteResponse).toList();
    }

    public ClienteResponse getById(Long id) {
        return UsuarioMapper.toClienteResponse(clienteRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado")));
    }

    public ClienteResponse getByFirebaseUid(String uid) {
        return UsuarioMapper.toClienteResponse(
                clienteRepo.findByUsuarioFirebaseUid(uid)
                        .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado")));
    }

    @Transactional
    public ClienteResponse crear(ClienteRequest req) {
        if (usuarioRepo.existsByEmail(req.getEmail()))
            throw new IllegalArgumentException("Email ya registrado");

        Usuario u = new Usuario();
        // Cliente creado manualmente por el taller: no tiene cuenta Firebase
        // Generamos UID local único para cumplir la restricción NOT NULL
        u.setFirebaseUid("local_" + UUID.randomUUID());
        u.setNombre(req.getNombre());
        u.setApellidos(req.getApellidos());
        u.setEmail(req.getEmail());
        u.setTelefono(req.getTelefono());
        u.setRol("CLIENTE");
        u.setActivo(true);
        u = usuarioRepo.save(u);

        Cliente c = new Cliente();
        c.setUsuario(u);
        return UsuarioMapper.toClienteResponse(clienteRepo.save(c));
    }

    @Transactional
    public ClienteResponse actualizar(Long id, ClienteRequest req) {
        Cliente c = clienteRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        Usuario u = c.getUsuario();
        u.setNombre(req.getNombre());
        u.setApellidos(req.getApellidos());
        u.setEmail(req.getEmail());
        u.setTelefono(req.getTelefono());
        usuarioRepo.save(u);
        return UsuarioMapper.toClienteResponse(c);
    }

    @Transactional
    public void eliminar(Long id) {
        Cliente c = clienteRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        Usuario u = c.getUsuario();
        u.setActivo(false); // Borrado lógico
        usuarioRepo.save(u);
    }
}