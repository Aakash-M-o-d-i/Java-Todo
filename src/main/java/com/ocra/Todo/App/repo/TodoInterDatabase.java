package com.ocra.Todo.App.repo;

import com.ocra.Todo.App.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoInterDatabase extends JpaRepository<Todo, Long> {
}
