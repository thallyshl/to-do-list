package com.thallys.to_do_list.dto;

import java.time.LocalDateTime;
import com.thallys.to_do_list.entity.enums.TaskStatus;

/**
 * DTO (Data Transfer Object) para transferência de dados de tarefas.
 * Utiliza record para criar uma classe imutável com getters automáticos.
 *
 * @author Thallys
 * @version 1.0
 * @since 2025-04-19
 */
public record TaskDTO(
    Long id,
    String title,
    String description,
    TaskStatus status,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    // Métodos adicionais podem ser definidos aqui, se necessário
}