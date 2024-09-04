package com.backend_project.Shopping_backend_application.service.image;

import com.backend_project.Shopping_backend_application.dto.ImageDto;
import com.backend_project.Shopping_backend_application.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {

    Image getImageById(Long id);
    void deleteImageById(Long id);
    void updateImage(MultipartFile file, Long imageId);
    List<ImageDto> saveImages(List<MultipartFile> files, Long productId);

}
