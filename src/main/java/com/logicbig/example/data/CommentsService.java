package com.logicbig.example.data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private List<Comments> commentsList;

    @Autowired
    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public Comments addComment(String nameIdea,String username, String comment){return commentsRepository.save(new Comments(nameIdea,username, comment));}
    public Comments getComment(long idd){
        return commentsRepository.findByIdd(idd).get(0);
    }
    public List<Comments> getAllComments(){
        return commentsRepository.findAll();
    }
    public Comments updateComments(Comments comments){
        if(commentsRepository.findByIdd(comments.getIdd()).isEmpty()){
            return commentsRepository.save(comments);
        }
        return null;
    }
    public void deleteComment(Long idd){
        commentsRepository.deleteById(idd);
    }

    public void flush() {
        commentsRepository.flush();
    }

    public List<Comments> getCommentsList(){
        return commentsList;
    }

    public List<Comments> getIdeaComments(String nameIdea){
        commentsList = new ArrayList<>();
        for (Comments i : getAllComments()) {
            if (i.getNameIdea().equals(nameIdea)){
                commentsList.add(i);
            }
        }
        return commentsList;
    }

}
