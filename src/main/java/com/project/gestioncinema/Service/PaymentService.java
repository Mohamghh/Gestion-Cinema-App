package com.project.gestioncinema.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PaymentService implements IPaymentService {

    // URL de l'API de taux de change pour récupérer le taux MAD -> USD
    private final String API_URL = "https://api.exchangerate-api.com/v4/latest/MAD";

    // Clé secrète Stripe, définie dans les propriétés Spring
    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    @Override
    public String createPaymentIntent(int amount) throws Exception {
        try {
            // Récupérer le taux de conversion MAD -> USD
            RestTemplate restTemplate = new RestTemplate();
            ExchangeRateResponse response = restTemplate.getForObject(API_URL, ExchangeRateResponse.class);

            if (response == null || !response.getRates().containsKey("USD")) {
                throw new Exception("Impossible de récupérer le taux de change.");
            }

            // Taux de conversion MAD -> USD
            double rateToUsd = response.getRates().get("USD");

            // Calculer le montant en USD centimes
            long amountInUsdCents = (long) (amount * rateToUsd * 100); // Conversion en centimes pour Stripe

            // Configurer Stripe avec la clé secrète
            Stripe.apiKey = stripeSecretKey;

            // Créer le PaymentIntent en USD
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(amountInUsdCents) // Montant en centimes (USD)
                    .setCurrency("usd") // Devise supportée par Stripe
                    .build();

            // Créer le PaymentIntent
            PaymentIntent intent = PaymentIntent.create(params);

            // Retourner le clientSecret pour l'usage côté frontend
            return intent.getClientSecret();
        } catch (StripeException e) {
            throw new Exception("Erreur lors de la création du PaymentIntent : " + e.getMessage(), e);
        } catch (Exception e) {
            throw new Exception("Une erreur est survenue : " + e.getMessage(), e);
        }
    }

    // Classe pour mapper la réponse JSON de l'API de taux de change
    public static class ExchangeRateResponse {
        private String base;
        private Map<String, Double> rates;

        public String getBase() {
            return base;
        }

        public void setBase(String base) {
            this.base = base;
        }

        public Map<String, Double> getRates() {
            return rates;
        }

        public void setRates(Map<String, Double> rates) {
            this.rates = rates;
        }
    }
}
