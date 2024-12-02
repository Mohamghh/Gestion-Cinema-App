package com.project.gestioncinema.Service;


import com.project.gestioncinema.Entities.Client;

import java.util.List;

public interface ClientService {

    Client saveClient(Client client);
    Client getClientbyId(Long id);
    List<Client> getAllClients();
    void deleteClient(Long id);
    Client updateClient(Long id, Client client);
}
