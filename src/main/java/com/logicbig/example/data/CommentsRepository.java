package com.logicbig.example.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findByNameIdea(String nameIdea);

    List<Comments> findByIdd(Long idd);
}