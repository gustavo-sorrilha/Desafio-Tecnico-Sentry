package com.example.desafio.service;

import java.util.Base64;
import com.example.desafio.model.Document;
import com.example.desafio.model.dto.DocumentDTO;
import com.example.desafio.repository.DocumentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    // Listar todos os documentos paginados
    public Page<DocumentDTO> findAll(Pageable pageable) {
        return documentRepository.findAll(pageable).map(this::convertToDTO);
    }

    // Criar um novo documento
    @Transactional
    public DocumentDTO createDocument(DocumentDTO documentDTO) {
        try {
            byte[] fileData = Base64.getDecoder().decode(documentDTO.getFileBase64());
            LocalDateTime createdAt = documentDTO.getCreatedAt() != null ? documentDTO.getCreatedAt() : LocalDateTime.now();

            Document document = new Document();
            document.setNome(documentDTO.getNome());
            document.setFileData(fileData);
            document.setFileSize((long) fileData.length);
            document.setCreatedAt(createdAt);
            document.setUpdatedAt(null); 

            document = documentRepository.save(document);
            return convertToDTO(document);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Erro ao decodificar o arquivo Base64. Verifique o formato da string enviada.", e);
        }
    }

    // Buscar documento por ID
    public DocumentDTO findById(Long id) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Documento não encontrado"));

        return convertToDTO(document);
    }

    // Atualizar documento
    @Transactional
    public DocumentDTO updateDocument(Long id, DocumentDTO documentDTO) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Documento não encontrado"));

        try {
            if (documentDTO.getNome() != null) {
                document.setNome(documentDTO.getNome());
            }

            if (documentDTO.getFileBase64() != null) {
                byte[] fileData = Base64.getDecoder().decode(documentDTO.getFileBase64());
                document.setFileData(fileData);
                document.setFileSize((long) fileData.length);
            }

            document.setUpdatedAt(LocalDateTime.now());
            document = documentRepository.save(document);
            return convertToDTO(document);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Erro ao decodificar o arquivo Base64. Verifique o formato da string enviada.", e);
        }
    }

    // Deletar documento
    @Transactional
    public void deleteDocument(Long id) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Documento não encontrado"));

        documentRepository.delete(document);
    }

    // Converter para DTO
    private DocumentDTO convertToDTO(Document document) {
        String fileBase64 = document.getFileData() != null ? Base64.getEncoder().encodeToString(document.getFileData()) : null;
        return new DocumentDTO(
                document.getId(),
                document.getNome(),
                document.getFileSize(),
                document.getCreatedAt(),
                document.getUpdatedAt(),
                fileBase64 
        );
    }
}
