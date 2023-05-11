package com.logicbig.example.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeasService {

    private final IdeaRepository ideaRepository;
    @Autowired
    private LikeService likeService;

    @Autowired
    public IdeasService(IdeaRepository ideaRepository){
        this.ideaRepository = ideaRepository;
    }

    public Ideas addIdeas(Ideas ideas) { return ideaRepository.save(ideas);}

    public Ideas getIdea(String keyWords){
        return ideaRepository.findByKeyWords(keyWords).get(0);
    }
    public List<Ideas> getAllIdeas(){
        return ideaRepository.findAll();
    }
    public Ideas updateIdeas(Ideas ideas){
        if(ideaRepository.findByKeyWords(ideas.getKeyWords()).size() == 0){
            return ideaRepository.save(ideas);
        }
        return null;
    }
    public void deleteIdea(Long name){
        ideaRepository.deleteById(name);
    }

    public void flush() {
        ideaRepository.flush();
    }

    public void changueEdit(Ideas ideas){
        ideas.setEdit(!ideas.isEdit());
        addIdeas(ideas);
    }

    public void changueEstado(Ideas ideas, String estado){
        estado= (estado.isEmpty()) ? ideas.getEstado() : estado;
        ideas.setEstado(estado);
        changueEdit(ideas);
    }

    public void changueLike(Ideas ideas, String username){
        int valor = validationLike(ideas.getName(),username);
        ideas.setLikesCount(ideas.getLikesCount()+valor);
        addIdeas(ideas);
    }

    public int validationLike(String ideaName,String username){
        int valor = 0;
        boolean existLike = userLike(ideaName, username);

        if (existLike) {
            valor = -1;
        } else {
            valor = 1;
            likeService.addLike(ideaName, username);
        }
        return valor;
    }

    public boolean userLike(String ideaName,String username) {
        boolean bandera = false;
        for (Likes i: likeService.getAllLikes() ){
            if (i.getUsername().equals(username) && i.getDescription().equals(ideaName)) {
                likeService.deleteLike(i.getIdd());
                bandera = true;
                break;
            }
        }
        return bandera;
    }
}