package com.example.myroutdiscover.repository;

import com.example.myroutdiscover.model.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture,Long> {
    @Query("select p.url from Picture as p")
    List<String>findAllUrls();
}
