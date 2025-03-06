package com.example.desafio.controllers;

import com.example.desafio.model.dto.DocumentDTO;
import com.example.desafio.service.DocumentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    // Listar documentos com paginação
    @GetMapping
    public ResponseEntity<Page<DocumentDTO>> index(
            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<DocumentDTO> documentos = documentService.findAll(pageable);
        return ResponseEntity.ok(documentos);
    }

    // Criar um novo documento
    @Operation(summary = "Criar um novo documento")
    @ApiResponse(responseCode = "200", description = "Documento criado com sucesso")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<DocumentDTO> create(@RequestBody DocumentDTO documentDTO) {
        DocumentDTO savedDocument = documentService.createDocument(documentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDocument);
    }

    // Buscar um documento por ID
    @Operation(summary = "Obter um documento pelo ID")
    @ApiResponse(responseCode = "200", description = "Documento encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> show(@PathVariable Long id) {
        return ResponseEntity.ok(documentService.findById(id));
    }

    // Atualizar um documento
    @Operation(summary = "Atualizar um documento pelo ID")
    @ApiResponse(responseCode = "200", description = "Documento encontrado")
    @PutMapping("/{id}")
    public ResponseEntity<DocumentDTO> update(@PathVariable Long id, @RequestBody DocumentDTO documentDTO) {
        DocumentDTO updatedDocument = documentService.updateDocument(id, documentDTO);
        return ResponseEntity.ok(updatedDocument);
    }

    // Deletar um documento
    @Operation(summary = "Deletar um documento pelo ID")
    @ApiResponse(responseCode = "200", description = "Documento deletado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }
}
