package com.logicbig.example.bean;

import com.logicbig.example.data.*;
import org.apache.catalina.User;
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
    @Autowired
    private UserService userService;
    private String use;
    private String name;
    private String topic;
    private String description;
    private LocalDate fecha;
    private String proponent;
    private String ocupacion;
    private String keyWords;
    private String proponentArea;

    private String estado;
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
        return this.keyWords;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void addIdea() {
        Users user = userService.getUser(UserBean.username);
        ideaService.addIdeas(new Ideas( name, topic, description, user.getUsername(), user.getRol(), keyWords, user.getArea()));
        message = " ";
    }


    public List<Ideas> consultKeywords (){
        List<Ideas> ideas = new ArrayList<>();
        if (keyWords != null) {
            for (Ideas idea : ideaService.getAllIdeas()) {
                if (idea.getKeyWords().contains(keyWords)) {
                    System.out.println("-----------------------; " + keyWords + idea.getName());
                    ideas.add(idea);
                }
            }
        }
        return ideas;
    }

    public List<Ideas> consultTopics (){
        List<Ideas> ideas = new ArrayList<>();
        if (topic != null) {
            for (Ideas idea : ideaService.getAllIdeas()) {
                if (idea.getTopic().contains(topic)) {
                    System.out.println("-----------------------; " + topic + idea.getName());
                    ideas.add(idea);
                }
            }
        }
        return ideas;
    }
    public List<Ideas> groupedByIdeas (String proponentArea){
        List<Ideas> ideas = new ArrayList<>();
        for ( Ideas idea: ideaService.getAllIdeas()){
            if ( idea.getProponentArea().equals(proponentArea)){
                ideas.add(idea);
            }
        }
        return ideas;
    }

    public String chargueIdea(Ideas ideas){
        this.name = ideas.getName();
        this.description = ideas.getDescription();
        this.proponent = ideas.getProponent();
        this.proponentArea = ideas.getProponentArea();
        this.keyWords = ideas.getKeyWords();
        this.topic = ideas.getTopic();
        this.fecha = ideas.getFecha();
        return "idea.xhtml?faces-redirect=true";
    }

}
