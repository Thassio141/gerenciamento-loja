package com.gerenciamento.loja.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gerenciamento.loja.dto.page.PageDTO;
import com.gerenciamento.loja.dto.produto.ProdutoCreateDTO;
import com.gerenciamento.loja.dto.produto.ProdutoDTO;
import com.gerenciamento.loja.entity.ProdutoEntity;
import com.gerenciamento.loja.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ObjectMapper objectMapper;

    public PageDTO<ProdutoDTO> listarProdutosPaginado(Integer pagina, Integer tamanho) {

        Pageable solicitacaoPagina = PageRequest.of(pagina, tamanho);
        Page<ProdutoEntity> produto = produtoRepository.findAll(solicitacaoPagina);
        List<ProdutoDTO> produtoDTO = produto.getContent().stream()
                .map(x -> objectMapper.convertValue(x, ProdutoDTO.class))
                .toList();

        return new PageDTO<>(produto.getTotalElements(),
                produto.getTotalPages(),
                pagina,
                tamanho,
                produtoDTO);
    }

    public ProdutoDTO adicionaProduto(ProdutoCreateDTO produtoCreateDTO){
        ProdutoEntity produto = objectMapper.convertValue(produtoCreateDTO, ProdutoEntity.class);
        produto.setDisponibilidade(Boolean.TRUE);
        produtoRepository.save(produto);
        return objectMapper.convertValue(produto, ProdutoDTO.class);
    }

    public ProdutoDTO editarProduto(Long idProduto, ProdutoCreateDTO produtoCreateDTO){
        ProdutoEntity produtoRecuperado = buscarPorId(idProduto);
        produtoRecuperado.setNomeProduto(produtoCreateDTO.getNomeProduto());
        produtoRecuperado.setDescricaoProduto(produtoCreateDTO.getDescricaoProduto());
        produtoRecuperado.setCategoria(produtoCreateDTO.getCategoria());
        produtoRecuperado.setCodigoBarras(produtoCreateDTO.getCodigoBarras());
        produtoRecuperado.setPreco(produtoCreateDTO.getPreco());
        produtoRecuperado.setQuantidade(produtoCreateDTO.getQuantidade());
        produtoRecuperado.setUrlImagem(produtoCreateDTO.getUrlImagem());
        produtoRepository.save(produtoRecuperado);
        return objectMapper.convertValue(produtoRecuperado,ProdutoDTO.class);
    }

    public void removerProduto(Long idProduto) {
        ProdutoEntity produtoRecuperado = buscarPorId(idProduto);
        produtoRecuperado.setDisponibilidade(Boolean.FALSE);
        produtoRepository.save(produtoRecuperado);
    }

    public ProdutoEntity buscarPorId(Long idProduto){
         return produtoRepository.findById(idProduto).orElseThrow();
    }

    public ProdutoDTO buscarPorIdDTO(Long idProduto){
        ProdutoEntity produto = produtoRepository.findById(idProduto).orElseThrow();
        return objectMapper.convertValue(produto,ProdutoDTO.class);
    };
}
