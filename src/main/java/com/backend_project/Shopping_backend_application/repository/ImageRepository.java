package com.backend_project.Shopping_backend_application.repository;

import com.backend_project.Shopping_backend_application.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {


    List<Image> findByProductId(Long id);
}
