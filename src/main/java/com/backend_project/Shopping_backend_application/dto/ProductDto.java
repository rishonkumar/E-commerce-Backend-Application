package com.backend_project.Shopping_backend_application.dto;

import com.backend_project.Shopping_backend_application.model.Category;
import lombok.Data;

import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDto {

    private Long id;

    private String name;

    private String brand;

    private BigDecimal price;

    private int inventory;

    private String description;

    private Category category;

    private List<ImageDto> images;
}
