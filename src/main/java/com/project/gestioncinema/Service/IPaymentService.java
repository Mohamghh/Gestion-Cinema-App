package com.project.gestioncinema.Service;

public interface IPaymentService {
    String createPaymentIntent(int amount) throws Exception;
}
