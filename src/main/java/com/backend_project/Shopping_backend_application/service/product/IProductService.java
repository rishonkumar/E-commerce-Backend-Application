package com.backend_project.Shopping_backend_application.service.product;

import com.backend_project.Shopping_backend_application.dto.ProductDto;
import com.backend_project.Shopping_backend_application.model.Product;
import com.backend_project.Shopping_backend_application.request.AddProductRequest;
import com.backend_project.Shopping_backend_application.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {

    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product>getProductsByBrand(String brand);
    List<Product>getProductsByCategoryAndBrand(String category, String brand);
    List<Product>getProductsByName(String name);
    List<Product>getProductsByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);

    List<ProductDto> getConvertedProduct(List<Product> products);

    ProductDto convertToDto(Product product);
}
