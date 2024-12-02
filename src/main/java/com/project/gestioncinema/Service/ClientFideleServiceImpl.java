package com.project.gestioncinema.Service;

import com.project.gestioncinema.Entities.ClientFidele;
import com.project.gestioncinema.Repository.ClientFideleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientFideleServiceImpl implements ClientFideleService {

    @Autowired
    private ClientFideleRepo clientFideleRepository;


    @Override
    public ClientFidele saveClientFidele(ClientFidele clientFidele) {
        return clientFideleRepository.save(clientFidele);
    }

    @Override
    public ClientFidele getClientFidele(Long id) {
        Optional<ClientFidele> clientFidele = clientFideleRepository.findById(id);
        return clientFidele.orElseThrow(() -> new RuntimeException("Client fidèle not found"));
    }

    @Override
    public List<ClientFidele> getAllClientsFideles() {
        return clientFideleRepository.findAll();
    }

    @Override
    public void deleteClientFidele(Long id) {
        clientFideleRepository.deleteById(id);

    }

    @Override
    public ClientFidele updateClientFidele(Long id, ClientFidele updatedClientFidele) {

        ClientFidele existingClientFidele = clientFideleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client fidèle not found"));

        existingClientFidele.setNom(updatedClientFidele.getNom());
        existingClientFidele.setEmail(updatedClientFidele.getEmail());
        existingClientFidele.setTelephone(updatedClientFidele.getTelephone());
        existingClientFidele.setStatutAbonnement(updatedClientFidele.getStatutAbonnement());
        existingClientFidele.setPointsFidelite(updatedClientFidele.getPointsFidelite());

        return clientFideleRepository.save(existingClientFidele);
    }


}
