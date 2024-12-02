package com.project.gestioncinema.Web;

import com.project.gestioncinema.Service.PaymentService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/create-payment-intent")
    public String createPaymentIntent(@RequestParam int amount) {
        try {
            return paymentService.createPaymentIntent(amount);
        } catch (Exception e) {
            return "Erreur lors de la création du PaymentIntent : " + e.getMessage();
        }
    }
}
