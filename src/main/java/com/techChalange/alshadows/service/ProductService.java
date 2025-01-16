package com.techChalange.alshadows.service;

import com.techChalange.alshadows.model.Product;
import com.techChalange.alshadows.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Récupérer tous les produits
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Récupérer un produit par son id
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Créer un nouveau produit
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Mettre à jour un produit existant
    public Optional<Product> updateProduct(Long id, Product productDetails) {
        if (productRepository.existsById(id)) {
            productDetails.setId(id);  // S'assurer que l'id ne change pas
            return Optional.of(productRepository.save(productDetails));
        } else {
            return Optional.empty();
        }
    }

    // Supprimer un produit
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }
}
