package com.thallys.to_do_list.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thallys.to_do_list.dto.TaskDTO;
import com.thallys.to_do_list.entity.Task;
import com.thallys.to_do_list.repository.TaskRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Serviço responsável pela lógica de negócio relacionada às tarefas.
 * Implementa operações CRUD e regras de negócio específicas para {@link Task}.
 *
 * @author Thallys
 * @version 1.0
 * @since 2025-04-19
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    /**
     * Recupera todas as tarefas cadastradas.
     * 
     * @return Lista de todas as tarefas
     * @throws RuntimeException se ocorrer erro na recuperação dos dados
     */
    @Transactional(readOnly = true)
    public List<TaskDTO> getAllTasks() {
        try {
            log.info("Buscando todas as tarefas");
            List<Task> tasks = taskRepository.findAll();
            return tasks.stream().map(task -> new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt(),
                task.getUpdatedAt()
                )).collect(Collectors.toList());
            } catch (Exception e) {
            log.error("Erro ao buscar tarefas", e);
            throw new RuntimeException("Falha ao recuperar tarefas", e);
        }
    }
    
    /**
     * Busca uma tarefa pelo seu ID.
     * 
     * @param id ID da tarefa a ser buscada
     * @return Optional contendo a tarefa, se encontrada
     * @throws RuntimeException se ocorrer erro na busca
     */
    @Transactional(readOnly = true)
    public Optional<Task> getTaskById(Long id) {
        try {
            log.info("Buscando tarefa com ID: {}", id);
            return taskRepository.findById(id);
        } catch (Exception e) {
            log.error("Erro ao buscar tarefa com ID: {}", id, e);
            throw new RuntimeException("Falha ao recuperar tarefa", e);
        }
    }
    
    /**
     * Salva uma nova tarefa ou atualiza uma existente.
     * 
     * @param task Tarefa a ser salva ou atualizada
     * @return Tarefa salva com ID gerado (se nova)
     * @throws RuntimeException se ocorrer erro na operação
     */
    @Transactional
    public Task saveTask(Task task) {
        try {
            log.info("Salvando tarefa: {}", task);
            return taskRepository.save(task);
        } catch (Exception e) {
            log.error("Erro ao salvar tarefa", e);
            throw new RuntimeException("Falha ao salvar tarefa", e);
        }
    }
    
    /**
     * Remove uma tarefa pelo seu ID.
     * 
     * @param id ID da tarefa a ser removida
     * @throws RuntimeException se ocorrer erro na remoção
     */
    @Transactional
    public void deleteTask(Long id) {
        try {
            log.info("Removendo tarefa com ID: {}", id);
            taskRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Erro ao remover tarefa com ID: {}", id, e);
            throw new RuntimeException("Falha ao remover tarefa", e);
        }
    }
}