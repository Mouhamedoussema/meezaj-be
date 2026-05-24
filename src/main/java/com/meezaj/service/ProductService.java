package com.meezaj.service;

import com.meezaj.model.Product;
import com.meezaj.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found: " + id));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product updated) {
        Product existing = getById(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setStory(updated.getStory());
        existing.setPrice(updated.getPrice());
        existing.setAvailableSizes(updated.getAvailableSizes());
        existing.setImageUrls(updated.getImageUrls());
        existing.setMaterial(updated.getMaterial());
        existing.setWeight(updated.getWeight());
        existing.setInStock(updated.isInStock());
        existing.setFeatured(updated.isFeatured());
        return productRepository.save(existing);
    }

    public List<Product> getFeatured() {
        return productRepository.findByFeaturedTrue();
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
