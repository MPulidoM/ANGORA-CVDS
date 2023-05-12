package com.logicbig.example.data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idd;

    private String nameIdea;
    private String username;
    @Column(length=5000)
    private String comment;
    private LocalDate date;


    public Comments(String nameIdea, String username, String comment) {
        this.nameIdea = nameIdea;
        this.username = username;
        this.comment = comment;
        this.date = LocalDate.now();
    }

    public Comments() {
    }

    public long getIdd() {
        return idd;
    }

    public void setIdd(long idd) {
        this.idd = idd;
    }

    public String getNameIdea() {
        return nameIdea;
    }

    public void setNameIdea(String nameIdea) {
        this.nameIdea = nameIdea;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "idd=" + idd +
                ", nameIdea='" + nameIdea + '\'' +
                ", username='" + username + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return idd == comments.idd && Objects.equals(nameIdea, comments.nameIdea) && Objects.equals(username, comments.username) && Objects.equals(comment, comments.comment) && Objects.equals(date, comments.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idd, nameIdea, username, comment, date);
    }
}
