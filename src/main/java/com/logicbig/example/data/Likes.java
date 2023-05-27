package com.logicbig.example.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idd;

    private String nameIdea;
    private String username;

    public Likes( String nameIdea, String username) {
        this.nameIdea = nameIdea;
        this.username = username;
    }

    public Likes() {
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

    @Override
    public String toString() {
        return "Likes{" +
                "idd=" + idd +
                ", nameIdea='" + nameIdea + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Likes likes = (Likes) o;
        return idd == likes.idd && Objects.equals(nameIdea, likes.nameIdea) && Objects.equals(username, likes.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idd, nameIdea, username);
    }
}
