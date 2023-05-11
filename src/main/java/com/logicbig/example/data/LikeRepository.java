package com.logicbig.example.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {
    List<Likes> findByIdd(long idd);
}
