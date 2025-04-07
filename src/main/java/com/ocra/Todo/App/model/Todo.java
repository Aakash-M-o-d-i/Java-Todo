package com.ocra.Todo.App.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Entity
@Table(name="todo")
public class Todo {
    // variable = id, title, date, status
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column
    private String title;

    @Column
    private Date date;

    @Column
    private String status;

    @Column
    private String description;
    public Todo(Long Id, String title, String description,Date date, String status){
        this.Id = Id;
        this.title = title;
        this.date = date;
        this.status = status;
        this.description = description;
    }

    public Todo(){
        // TODO Auto-generated constructor stub
    }

    // Getter and Setter of variable
    public void setId(Long id) {
        Id = id;
    }
    public Long getId(){
        return Id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return date;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
