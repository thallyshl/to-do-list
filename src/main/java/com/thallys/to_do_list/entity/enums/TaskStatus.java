package com.thallys.to_do_list.entity.enums;

/**
 * Enum que representa os possíveis estados de uma tarefa no sistema.
 * Utilizado para controlar o ciclo de vida das tarefas.
 */
public enum TaskStatus {
    
    /**
     * Tarefa recém criada, ainda não iniciada
     */
    PENDING("Pendente"),

    /**
     * Tarefa em execução/andamento
     */
    IN_PROGRESS("Em Progresso"),

    /**
     * Tarefa completada com sucesso
     */
    COMPLETED("Completada"),

    /**
     * Tarefa cancelada antes da conclusão
     */
    CANCELLED("Cancelada"),

    /**
     * Tarefa pausada temporariamente
     */
    ON_HOLD("Em Espera");

    private final String description;

    /**
     * Construtor do enum
     * @param description Descrição legível do status
     */
    TaskStatus(String description) {
        this.description = description;
    }

    /**
     * Retorna a descrição legível do status
     * @return String contendo a descrição do status
     */
    public String getDescription() {
        return this.description;
    }
}