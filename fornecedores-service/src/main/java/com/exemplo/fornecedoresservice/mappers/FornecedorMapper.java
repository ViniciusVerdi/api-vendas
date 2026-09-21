package com.exemplo.fornecedoresservice.mappers;

import com.exemplo.fornecedoresservice.dtos.requests.FornecedorRequestDTO;
import com.exemplo.fornecedoresservice.dtos.responses.FornecedorResponseDTO;
import com.exemplo.fornecedoresservice.model.Fornecedor;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FornecedorMapper {
    FornecedorResponseDTO toResponse(Fornecedor fornecedor);
    List<FornecedorResponseDTO> toListResponse(List<Fornecedor> fornecedor);
    Fornecedor toEntity(FornecedorRequestDTO fornecedorRequestDTO);
}
