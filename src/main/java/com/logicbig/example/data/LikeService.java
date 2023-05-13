package com.logicbig.example.data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    private final LikeRepository likeRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public Likes addLike(String nameIdea,String username){return likeRepository.save(new Likes(nameIdea,username));}
    public Likes getLike(long idd){
        return likeRepository.findByIdd(idd).get(0);
    }
    public List<Likes> getAllLikes(){
        return likeRepository.findAll();
    }
    public Likes updateLikes(Likes likes){
        if(likeRepository.findByIdd(likes.getIdd()).size() == 0){
            return likeRepository.save(likes);
        }
        return null;
    }
    public void deleteLike(Long idd){
        likeRepository.deleteById(idd);
    }

    public void flush() {
        likeRepository.flush();
    }

    public int countLikesByIdea(String nameIdea){
        int numero = 0;
        for (Likes i: getAllLikes()){
            if (i.getDescription().equals(nameIdea)){
                numero++;
            }
        }
        return numero;
    }

}
