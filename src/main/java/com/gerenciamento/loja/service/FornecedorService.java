package com.gerenciamento.loja.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gerenciamento.loja.dto.fornecedor.FornecedorDTO;
import com.gerenciamento.loja.dto.page.PageDTO;
import com.gerenciamento.loja.dto.fornecedor.FornecedorCreateDTO;
import com.gerenciamento.loja.entity.FornecedorEntity;
import com.gerenciamento.loja.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedorService {

    private ObjectMapper objectMapper;
    private FornecedorRepository fornecedorRepository;

    public PageDTO<FornecedorDTO> listarFornecedorPaginado(Integer pagina, Integer tamanho) {

        Pageable solicitacaoPagina = PageRequest.of(pagina, tamanho);
        Page<FornecedorEntity> fornecedor = fornecedorRepository.findAll(solicitacaoPagina);
        List<FornecedorDTO> fornecedorDTO = fornecedor.getContent().stream()
                .map(x -> objectMapper.convertValue(x, FornecedorDTO.class))
                .toList();

        return new PageDTO<>(fornecedor.getTotalElements(),
                fornecedor.getTotalPages(),
                pagina,
                tamanho,
                fornecedorDTO);
    }

    public FornecedorDTO adicionaProduto(FornecedorCreateDTO fornecedorCreateDTO){
        FornecedorEntity fornecedor = objectMapper.convertValue(fornecedorCreateDTO, FornecedorEntity.class);
        fornecedor.setAtivo(Boolean.TRUE);
        fornecedorRepository.save(fornecedor);
        return objectMapper.convertValue(fornecedor, FornecedorDTO.class);
    }

    public FornecedorDTO editarProduto(Long idFornecedor, FornecedorCreateDTO fornecedorCreateDTO){
        FornecedorEntity fornecedorRecuperado = buscarPorId(idFornecedor);
        fornecedorRecuperado.setEmailFornecedor(fornecedorCreateDTO.getEmailFornecedor());
        fornecedorRecuperado.setNomeFornecedor(fornecedorCreateDTO.getNomeFornecedor());
        fornecedorRecuperado.setTelefoneFornecedor(fornecedorCreateDTO.getTelefoneFornecedor());
//        fornecedorRecuperado.setProdutosFornecidos(fornecedorCreateDTO.getPreco());
//        fornecedorRecuperado.setEnderecoFornecedor(fornecedorCreateDTO.getQuantidade());
        fornecedorRepository.save(fornecedorRecuperado);
        return objectMapper.convertValue(fornecedorRecuperado,FornecedorDTO.class);
    }

    public void removerFornecedor(Long idFornecedor) {
        FornecedorEntity fornecedorRecuperado = buscarPorId(idFornecedor);
        fornecedorRecuperado.setAtivo(Boolean.FALSE);
        fornecedorRepository.save(fornecedorRecuperado);
    }

    public FornecedorEntity buscarPorId(Long idFornecedor){
        return fornecedorRepository.findById(idFornecedor).orElseThrow();
    }

    public FornecedorDTO buscarPorIdDTO(Long idFornecedor){
        FornecedorEntity fornecedor = fornecedorRepository.findById(idFornecedor).orElseThrow();
        return objectMapper.convertValue(fornecedor,FornecedorDTO.class);
    };
}
