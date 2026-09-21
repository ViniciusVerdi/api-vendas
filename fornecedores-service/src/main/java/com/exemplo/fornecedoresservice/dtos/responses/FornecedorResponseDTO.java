package com.exemplo.fornecedoresservice.dtos.responses;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorResponseDTO {
    private Long id;
    private String nome;
    private String cnpj;
}

