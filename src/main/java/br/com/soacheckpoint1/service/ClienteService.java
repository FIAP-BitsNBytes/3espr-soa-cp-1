package br.com.soacheckpoint1.service;

import br.com.soacheckpoint1.domain.Cliente;
import br.com.soacheckpoint1.dto.ClienteRequestDTO;
import br.com.soacheckpoint1.dto.ClienteResponseDTO;
import br.com.soacheckpoint1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Page<ClienteResponseDTO> list(String name, String email, Pageable pageable) {
        // Filtros simples (pode ser melhorado com Specification)
        Page<Cliente> clientes = clienteRepository.findAll(pageable);
        return clientes.map(this::toResponseDTO);
    }

    public Optional<ClienteResponseDTO> findById(Long id) {
        return clienteRepository.findById(id).map(this::toResponseDTO);
    }

    @Transactional
    public ClienteResponseDTO create(ClienteRequestDTO dto) {
        if (clienteRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setDocumento(dto.getDocumento());
        Cliente salvo = clienteRepository.save(cliente);
        return toResponseDTO(salvo);
    }

    @Transactional
    public Optional<ClienteResponseDTO> update(Long id, ClienteRequestDTO dto) {
        Optional<Cliente> opt = clienteRepository.findById(id);
        if (opt.isEmpty()) return Optional.empty();
        Cliente cliente = opt.get();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setDocumento(dto.getDocumento());
        Cliente salvo = clienteRepository.save(cliente);
        return Optional.of(toResponseDTO(salvo));
    }

    @Transactional
    public boolean delete(Long id) {
        if (!clienteRepository.existsById(id)) return false;
        clienteRepository.deleteById(id);
        return true;
    }

    private ClienteResponseDTO toResponseDTO(Cliente cliente) {
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        dto.setDocumento(cliente.getDocumento());
        return dto;
    }
}
