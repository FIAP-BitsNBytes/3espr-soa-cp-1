package br.com.soacheckpoint1.service;

import br.com.soacheckpoint1.domain.Produto;
import br.com.soacheckpoint1.dto.ProdutoRequestDTO;
import br.com.soacheckpoint1.dto.ProdutoResponseDTO;
import br.com.soacheckpoint1.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<ProdutoResponseDTO> list(String category, Boolean active, Pageable pageable) {
        Page<Produto> produtos = produtoRepository.findAll(pageable);
        return produtos.map(this::toResponseDTO);
    }

    public Optional<ProdutoResponseDTO> findById(Long id) {
        return produtoRepository.findById(id).map(this::toResponseDTO);
    }

    @Transactional
    public ProdutoResponseDTO create(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(dto.getCategoria());
        produto.setDescricao(dto.getDescricao());
        produto.setAtivo(dto.getAtivo() != null ? dto.getAtivo() : true);
        Produto salvo = produtoRepository.save(produto);
        return toResponseDTO(salvo);
    }

    @Transactional
    public Optional<ProdutoResponseDTO> update(Long id, ProdutoRequestDTO dto) {
        Optional<Produto> opt = produtoRepository.findById(id);
        if (opt.isEmpty()) return Optional.empty();
        Produto produto = opt.get();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(dto.getCategoria());
        produto.setDescricao(dto.getDescricao());
        produto.setAtivo(dto.getAtivo() != null ? dto.getAtivo() : true);
        Produto salvo = produtoRepository.save(produto);
        return Optional.of(toResponseDTO(salvo));
    }

    @Transactional
    public boolean delete(Long id) {
        if (!produtoRepository.existsById(id)) return false;
        produtoRepository.deleteById(id);
        return true;
    }

    private ProdutoResponseDTO toResponseDTO(Produto produto) {
        ProdutoResponseDTO dto = new ProdutoResponseDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        dto.setCategoria(produto.getCategoria());
        dto.setDescricao(produto.getDescricao());
        dto.setAtivo(produto.getAtivo());
        return dto;
    }
}
