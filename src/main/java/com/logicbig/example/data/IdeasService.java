package com.logicbig.example.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeasService {

    private final IdeaRepository ideaRepository;

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

}