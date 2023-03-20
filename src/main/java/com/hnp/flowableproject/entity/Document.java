package com.hnp.flowableproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "usr_document")
@Entity
public class Document {

    @Id
    private int id;

    private String title;

    private String author;

    public Document() {

    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", title=" + title +
                ", author='" + author + '\'' +
                '}';
    }
}
