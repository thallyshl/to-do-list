package com.thallys.to_do_list.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.thallys.to_do_list.entity.enums.TaskStatus;
import jakarta.persistence.*;

/**
 * Entidade que representa uma tarefa no sistema.
 * Esta classe utiliza JPA para persistência e Lombok para redução de boilerplate.
 *
 * @author Thallys
 * @version 1.0
 * @since 2025-04-18
 */
@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    /**
     * Identificador único da tarefa
     */
    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * Título da tarefa - campo obrigatório com tamanho máximo de 255 caracteres
     */
    @Column(nullable = false, length = 255)
    private String title;

    /**
     * Descrição detalhada da tarefa - campo opcional armazenado como TEXT
     */
    @Column(columnDefinition = "TEXT")
    private String description;

    /**
     * Status atual da tarefa
     * @see TaskStatus para os possíveis valores
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    /**
     * Data e hora de criação da tarefa - preenchido automaticamente
     */
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Data e hora da última atualização - atualizado automaticamente
     */
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}