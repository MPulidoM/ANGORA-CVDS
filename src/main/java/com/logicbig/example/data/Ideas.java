package com.logicbig.example.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Entity
public class Ideas {

    @Id
    private String name;
    private String topic;
    private String description;
    private LocalDate fecha;
    private String proponent;
    private String ocupacion;
    private String keyWords;
    private String proponentArea;

    private String estado;

    private boolean edit;

    private int likesCount = 0;

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public void incrementLikesCount() {
        likesCount += 1;
        setLikesCount(likesCount);
        System.out.println(likesCount);
    }

    public int getLikesCount() {
        incrementLikesCount();
        System.out.println(likesCount);
        return likesCount;

    }


    public Ideas() {
    }

    public Ideas(String name, String topic,String description, String proponent, String ocupacion, String keyWords, String proponentArea) {
        this.name = name;
        this.topic = topic;
        this.description = description;
        this.topic = topic;
        this.fecha = LocalDate.now();
        this.proponent = proponent;
        this.ocupacion = ocupacion;
        this.keyWords = keyWords;
        this.proponentArea = proponentArea;
        this.estado = "pendiente";
        this.edit = false;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getProponent() {
        return proponent;
    }

    public void setProponent(String proponent) {
        this.proponent = proponent;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getProponentArea() {
        return proponentArea;
    }

    public void setProponentArea(String proponentArea) {
        this.proponentArea = proponentArea;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isEdit() {return edit;}

    public void setEdit(boolean edit) {this.edit = edit;}



    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
