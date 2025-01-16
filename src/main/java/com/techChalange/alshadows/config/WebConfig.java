package com.techChalange.alshadows.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration des paramètres CORS (Cross-Origin Resource Sharing).
 * Cette classe permet de configurer les règles de partage des ressources
 * entre le serveur backend et le frontend, en particulier pour autoriser
 * les requêtes provenant de domaines spécifiques.
 *
 * Auteur : Igor Sibemou
 * Date de création : 2025-01-15
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Méthode pour ajouter des mappings CORS pour autoriser
     * les requêtes provenant du frontend sur un domaine spécifique.
     *
     * @param registry : un objet permettant de configurer les mappings CORS.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Applique les règles CORS pour toutes les requêtes à "/api/**".
                .allowedOrigins("http://localhost:3000") // Autorise les requêtes provenant de http://localhost:3000 (frontend React).
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Autorise les méthodes HTTP : GET, POST, PUT, DELETE.
    }
}
