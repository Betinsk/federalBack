package com.toDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toDoList.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Se necessário, adicione métodos personalizados de consulta aqui
}
