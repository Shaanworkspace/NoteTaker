package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Random;

@Entity
@Table(name="noteTaker")
public class note {
    public note() {
        super();
    }

    @Override
    public String toString() {
        return "note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }

    public note( String title, String content, Date date) {
        this.id = new Random().nextInt(1000);
        this.title = title;
        this.content = content;
        this.date = date;
    }

    @Id
    private int id;
    private String title;
    private String content;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
