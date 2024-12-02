package com.project.gestioncinema.Stripe;

import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StripeConfig {
    // Récupère la clé secrète pour le backend
    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    // Initialisation de Stripe avec la clé secrète
    @Bean
    public void init() {
        // Utiliser la clé secrète pour le backend
        Stripe.apiKey = stripeSecretKey;
    }

    }
