package com.exemplo.fornecedoresservice.dtos.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorRequestDTO {
    private String nome;
    private String cnpj;
}
