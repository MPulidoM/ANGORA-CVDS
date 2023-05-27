package com.logicbig.example.bean;

import com.logicbig.example.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mariana Pulido Moreno
 * @author Erika Juliana Castro
 * @author SantiagoNaranjo Melo
 * @author Jordy Santiago Bautista
 * @author Ximena Alejandra RodrigueZ
 */
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
    @Column(length=5000)
    private String description;
    private LocalDate fecha;
    private String proponent;
    private String ocupacion;
    private String keyWords;
    private String proponentArea;
    private List<Ideas> ideasList = new ArrayList<>();
    private String estado;
    private String message;



    private List<Ideas> filteredIdeas = new ArrayList<>();
    public IdeasService getIdeaService() {
        return ideaService;
    }

    public void setIdeaService(IdeasService ideaService) {
        this.ideaService = ideaService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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

    public List<Ideas> getFilteredIdeas() {
        return filteredIdeas;
    }
    public void setFilteredIdeas(List<Ideas> filteredIdeas) {
        this.filteredIdeas = filteredIdeas;
    }

    public List<Ideas> getIdeasList() {return ideasList;}

    public void setIdeasList(List<Ideas> ideasList) {this.ideasList = ideasList;}

    public List<Ideas> chargueIdeas(){this.ideasList = ideaService.getAllIdeas(); return ideasList;}

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
                    //System.out.println("-----------------------; " + keyWords + idea.getName());
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
                    //System.out.println("-----------------------; " + topic + idea.getName());
                    ideas.add(idea);
                }
            }
        }
        return ideas;
    }
    public List<Ideas> groupedByIdeas (String parameter){
        List<Ideas> ideas = new ArrayList<>();
        for ( Ideas idea: ideaService.getAllIdeas()){
            if ( idea.getProponentArea().equals(parameter)){
                ideas.add(idea);
            }
            else if (idea.getEstado().equals(parameter)) {
                ideas.add(idea);
            }
        }
        return ideas;
    }

    public int maxIdea (boolean band){
        List<Integer> lista = new ArrayList<>();
        if (band) {
            lista.add( groupedByIdeas("Administracion").size());
            lista.add( groupedByIdeas("Sociales").size());
            lista.add( groupedByIdeas("Matematicas").size());
            lista.add( groupedByIdeas("Sistemas").size());
        }else {
            lista.add( groupedByIdeas("Denegada").size());
            lista.add( groupedByIdeas("Revision").size());
            lista.add( groupedByIdeas("Aprobada").size());
            lista.add( groupedByIdeas("Pendiente").size());
        }
        return maxFunction(lista);
    }

    public int maxFunction(List<Integer> list) {
        int n =  0;
        for (int i: list) {
            if (i > n) {
                n = i;
            }
        }
        return n;
    }

    public void callbackSearch() {
        //System.out.println("Valor: " + this.keyWords);
        this.setFilteredIdeas(this.consultKeywords());
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

    public void userIdeas(String prop){
        ideasList = ideaService.ideaByUsuario(prop);
    }

}
