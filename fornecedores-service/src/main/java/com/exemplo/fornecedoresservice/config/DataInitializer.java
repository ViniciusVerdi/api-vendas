package com.exemplo.fornecedoresservice.config;

import com.exemplo.fornecedoresservice.repository.FornecedorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.exemplo.fornecedoresservice.model.Fornecedor;

@Component
public class DataInitializer implements CommandLineRunner {

    private final FornecedorRepository FornecedorRepository;

    public DataInitializer(FornecedorRepository FornecedorRepository) {
        this.FornecedorRepository = FornecedorRepository;
    }

    @Override
    public void run(String... args) {
        FornecedorRepository.save(
            new Fornecedor("Ana Souza", "12.345.678/0001-90")
        );
        FornecedorRepository.save(
            new Fornecedor("Bruno Lima", "23.456.789/0001-01")
        );
        FornecedorRepository.save(
            new Fornecedor("Carla Mendes", "34.567.890/0001-12")
        );
        FornecedorRepository.save(
            new Fornecedor("Diego Rocha", "45.678.901/0001-23")
        );
        FornecedorRepository.save(
            new Fornecedor("Elisa Prado", "56.789.012/0001-34")
        );
        FornecedorRepository.save(
            new Fornecedor("Felipe Nunes", "67.890.123/0001-45")
        );
        FornecedorRepository.save(
            new Fornecedor("Gabriela Reis", "78.901.234/0001-56")
        );
        FornecedorRepository.save(
            new Fornecedor("Henrique Alves", "89.012.345/0001-67")
        );
        FornecedorRepository.save(
            new Fornecedor("Isabela Cruz", "90.123.456/0001-78")
        );
        FornecedorRepository.save(
            new Fornecedor("Joao Vieira", "01.234.567/0001-89")
        );
    }
}
