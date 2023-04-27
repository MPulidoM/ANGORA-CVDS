package com.logicbig.example.bean;

import com.logicbig.example.data.Ideas;
import com.logicbig.example.data.IdeasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean(name = "ideasBean")
public class IdeasBean {

    @Autowired
    private IdeasService ideaService;
    private String use;
    private String name;
    private String topic;
    private String description;
    private LocalDate fecha;
    private String proponent;
    private String ocupacion;
    private String keyWords;
    private String proponentArea;
    private String message;

    public IdeasService getIdeaService() {
        return ideaService;
    }

    public void setIdeaService(IdeasService ideaService) {
        this.ideaService = ideaService;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void addIdea() {

        ideaService.addIdeas(new Ideas( name, topic, description, UserBean.username, ocupacion, keyWords, proponentArea));
        message = " ";
    }


    public List<Ideas> consultKeywords (String keywords){
        List<Ideas> ideas = new ArrayList<>();
        for ( Ideas idea: ideaService.getAllIdeas()){
            if (idea.getKeyWords().equals(keywords)){
                ideas.add(idea);
            }
        }
        return ideas;
    }

    public List<Ideas> groupedByIdeas (String proponentArea){
        List<Ideas> ideas = new ArrayList<>();
        for ( Ideas idea: ideaService.getAllIdeas()){
            if (idea.getProponentArea().equals(proponentArea)){
                ideas.add(idea);
            }
        }
        return ideas;
    }
}
