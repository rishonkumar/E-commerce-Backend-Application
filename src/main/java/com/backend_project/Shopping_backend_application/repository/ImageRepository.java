package com.backend_project.Shopping_backend_application.repository;

import com.backend_project.Shopping_backend_application.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
