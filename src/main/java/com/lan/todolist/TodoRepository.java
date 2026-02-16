package com.lan.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("SELECT t FROM Todo t ORDER BY " +
            "CASE t.priority " +
            "WHEN 'High' THEN 1 " +
            "WHEN 'Medium' THEN 2 " +
            "WHEN 'Low' THEN 3 " +
            "ELSE 4 END ASC")
    List<Todo> findAllSortedByPriority();
}