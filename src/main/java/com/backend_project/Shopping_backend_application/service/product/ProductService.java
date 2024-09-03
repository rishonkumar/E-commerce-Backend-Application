package com.backend_project.Shopping_backend_application.service.product;

import com.backend_project.Shopping_backend_application.exceptions.ProductNotFoundException;
import com.backend_project.Shopping_backend_application.model.Category;
import com.backend_project.Shopping_backend_application.model.Product;
import com.backend_project.Shopping_backend_application.repository.CategoryRepository;
import com.backend_project.Shopping_backend_application.repository.ProductRepository;
import com.backend_project.Shopping_backend_application.request.AddProductRequest;
import com.backend_project.Shopping_backend_application.request.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;


    @Override
    public Product addProduct(AddProductRequest request) {
        //check category is found in the DB
        //if yes set it as the new product category
        // if no then save it as a new category
        // then set as the new product category
        Category category = Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName()))
                .orElseGet(() -> {
                    Category newCategory = new Category(request.getCategory().getName());
                    return categoryRepository.save(newCategory);
                });
        request.setCategory(category);
        return productRepository.save(createProduct(request,category));
    }

    private Product createProduct(AddProductRequest request, Category category) {
        return new Product(
                request.getName(),
                request.getBrand(),
                request.getPrice(),
                request.getInventory(),
                request.getDescription(),
                category
        );
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id).ifPresentOrElse(productRepository::delete, () -> {
            throw new ProductNotFoundException("Product not found");
        });

    }

    @Override
    public Product updateProduct(ProductUpdateRequest request, Long productId) {

        Product product = productRepository.findById(productId)
                .map(existingProduct -> updateExisitngProduct(existingProduct,request))
                .map(productRepository::save)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        return product;

    }

    private Product updateExisitngProduct(Product exisitingProduct, ProductUpdateRequest productUpdateRequest) {
        exisitingProduct.setName(productUpdateRequest.getName());
        exisitingProduct.setBrand(productUpdateRequest.getBrand());
        exisitingProduct.setPrice(productUpdateRequest.getPrice());
        exisitingProduct.setInventory(productUpdateRequest.getInventory());
        exisitingProduct.setDescription(productUpdateRequest.getDescription());


        Category category = categoryRepository.findByName( productUpdateRequest.getCategory().getName());
        if(category != null) {
            exisitingProduct.setCategory(category);
        }
        return exisitingProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        return productRepository.findByCategoryNameAndBrand(category, brand);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand, name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        return productRepository.countByBrandAndName(brand, name);
    }
}
