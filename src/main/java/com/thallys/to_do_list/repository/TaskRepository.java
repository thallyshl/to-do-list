package com.thallys.to_do_list.repository;

import com.thallys.to_do_list.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para operações de persistência da entidade {@link Task}.
 * Fornece métodos CRUD padrão herdados de {@link JpaRepository}.
 * 
 * @author Thallys
 * @version 1.0
 * @since 2025-04-19
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    /**
     * Métodos herdados do JpaRepository incluem:
     * - findAll(): Lista todas as tarefas
     * - findById(Long id): Busca uma tarefa pelo ID
     * - save(Task task): Salva ou atualiza uma tarefa
     * - deleteById(Long id): Remove uma tarefa pelo ID
     * - count(): Retorna o número total de tarefas
     */
    
}