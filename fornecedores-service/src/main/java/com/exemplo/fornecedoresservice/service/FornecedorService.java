package com.exemplo.fornecedoresservice.service;

import com.exemplo.fornecedoresservice.dtos.requests.FornecedorRequestDTO;
import com.exemplo.fornecedoresservice.dtos.responses.FornecedorResponseDTO;
import com.exemplo.fornecedoresservice.mappers.FornecedorMapper;
import com.exemplo.fornecedoresservice.model.Fornecedor;
import com.exemplo.fornecedoresservice.repository.FornecedorRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final FornecedorMapper fornecedorMapper;

    public FornecedorService(
        FornecedorRepository fornecedorRepository,
        FornecedorMapper fornecedorMapper
    ) {
        this.fornecedorRepository = fornecedorRepository;
        this.fornecedorMapper = fornecedorMapper;
    }

    public List<FornecedorResponseDTO> listarTodos() {
        return fornecedorMapper.toListResponse(fornecedorRepository.findAll());
    }

    public FornecedorResponseDTO obterPorId(Long id) {
        return fornecedorMapper.toResponse(buscarPorId(id));
    }

    public FornecedorResponseDTO salvar(FornecedorRequestDTO fornecedorRequestDTO) {
        if (fornecedorRepository.existsByCnpj(fornecedorRequestDTO.getCnpj())) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Erro: já existe um fornecedor o CNPJ " +
                    fornecedorRequestDTO.getCnpj()
            );
        }
        Fornecedor fornecedor = fornecedorMapper.toEntity(fornecedorRequestDTO);
        Fornecedor novo = fornecedorRepository.save(fornecedor);
        return fornecedorMapper.toResponse(novo);
    }

    public Fornecedor buscarPorId(Long id) {
        return fornecedorRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Erro: não há nenhum fornecedor com id " + id
                )
            );
    }
}
