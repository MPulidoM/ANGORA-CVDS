package com.logicbig.example.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface IdeaRepository extends JpaRepository<Ideas, Long> {
    List<Ideas> findByName(String name);

    List<Ideas> findByProponent(String proponent);
}