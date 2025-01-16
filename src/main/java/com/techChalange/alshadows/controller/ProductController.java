package com.techChalange.alshadows.controller;

import com.techChalange.alshadows.model.Product;
import com.techChalange.alshadows.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // Injection du service ProductService via le constructeur
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Récupérer tous les produits
    @Operation(summary = "Récupère tous les produits", description = "Retourne une liste de tous les produits disponibles")
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();  // Retourne la liste de tous les produits
    }

    // Récupérer un produit par son identifiant
    @Operation(summary = "Récupère un produit par son ID", description = "Retourne un produit en fonction de son identifiant unique")
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);  // Retourne le produit correspondant à l'id ou vide si non trouvé
    }

    // Créer un nouveau produit
    @Operation(summary = "Crée un nouveau produit", description = "Permet de créer un nouveau produit avec les détails fournis")
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);  // Crée et retourne le produit créé
    }

    // Mettre à jour un produit existant
    @Operation(summary = "Met à jour un produit existant", description = "Met à jour les informations d'un produit basé sur son ID")
    @PutMapping("/{id}")
    public Optional<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);  // Retourne le produit mis à jour ou vide si non trouvé
    }

    // Supprimer un produit
    @Operation(summary = "Supprime un produit", description = "Supprime le produit correspondant à l'ID fourni")
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);  // Supprime le produit correspondant à l'id
    }
}
