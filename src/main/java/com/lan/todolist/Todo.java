package com.lan.todolist;

import jakarta.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task;
    private String priority; //high, medium, or low priority
    private boolean completed;

    public Todo() {}

    //setters and getters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}