package com.backend_project.Shopping_backend_application.request;

import com.backend_project.Shopping_backend_application.model.Category;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class AddProductRequest {

    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;
}
