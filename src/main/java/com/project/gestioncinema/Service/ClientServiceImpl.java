package com.project.gestioncinema.Service;

import com.project.gestioncinema.Entities.Client;
import com.project.gestioncinema.Repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepo clientRepository;
    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientbyId(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }

    @Override
    public Client updateClient(Long id, Client updatedClient) {

        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        existingClient.setNom(updatedClient.getNom());
        existingClient.setEmail(updatedClient.getEmail());
        existingClient.setTelephone(updatedClient.getTelephone());

        return clientRepository.save(existingClient);
    }
}
