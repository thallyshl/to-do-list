package com.thallys.to_do_list.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.thallys.to_do_list.service.TaskService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Collections;

import org.springframework.web.bind.annotation.GetMapping;

import com.thallys.to_do_list.dto.TaskDTO;

/**
 * Controller REST para gerenciar operações relacionadas a tarefas.
 * Expõe endpoints para interagir com a entidade Task.
 *
 * @author Thallys
 * @version 1.0
 * @since 2025-04-19
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskService taskService;

    /**
     * Endpoint para buscar todas as tarefas.
     * 
     * @return ResponseEntity contendo a lista de TaskDTO e o status HTTP.
     *         Retorna 200 OK com a lista se bem-sucedido.
     *         Retorna 500 Internal Server Error se ocorrer um erro.
     */
    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        try {
            log.info("Recebida requisição para buscar todas as tarefas");
            List<TaskDTO> tasks = taskService.getAllTasks();
            return ResponseEntity.ok(tasks); // Retorna 200 OK com a lista de tarefas
        } catch (Exception e) {
            log.error("Erro ao buscar todas as tarefas", e);
            // Retorna 500 Internal Server Error com uma lista vazia ou null no corpo
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Collections.emptyList()); // Ou .body(null) ou uma mensagem de erro
        }
    }
    
    // TODO: Adicionar outros endpoints (GET por ID, POST, PUT, DELETE)
}