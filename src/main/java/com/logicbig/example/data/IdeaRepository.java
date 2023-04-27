package com.logicbig.example.data;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IdeaRepository extends JpaRepository<Ideas, Long> {
    List<Ideas> findByKeyWords(String keyWords);
}