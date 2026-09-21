package com.exemplo.fornecedoresservice.controller;

import com.exemplo.fornecedoresservice.dtos.integrations.ProdutoDTO;
import com.exemplo.fornecedoresservice.dtos.requests.FornecedorRequestDTO;
import com.exemplo.fornecedoresservice.dtos.responses.FornecedorResponseDTO;
import com.exemplo.fornecedoresservice.interfaces.ProdutoInterface;
import com.exemplo.fornecedoresservice.service.FornecedorService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService service;
    private final ProdutoInterface produtoInterface;

    public FornecedorController(FornecedorService service, ProdutoInterface produtoInterface) {
        this.service = service;
        this.produtoInterface = produtoInterface;
    }

    @GetMapping()
    public ResponseEntity<List<FornecedorResponseDTO>> listarTodos() {
        List<FornecedorResponseDTO> lista = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> obterPorId(
        @PathVariable long id
    ) {
        FornecedorResponseDTO fornecedor = service.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(fornecedor);
    }

    @PostMapping()
    public ResponseEntity<FornecedorResponseDTO> salvar(
        @RequestBody FornecedorRequestDTO fornecedorRequestDTO
    ) {
        FornecedorResponseDTO fornecedor = service.salvar(fornecedorRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedor);
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoInterface.listarProdutos());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(
        IllegalArgumentException exception
    ) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            exception.getMessage()
        );
    }
}
