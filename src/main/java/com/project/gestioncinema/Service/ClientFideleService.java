package com.project.gestioncinema.Service;

import com.project.gestioncinema.Entities.ClientFidele;

import java.util.List;

public interface ClientFideleService {

    ClientFidele saveClientFidele(ClientFidele clientFidele);
    ClientFidele getClientFidele(Long id);
    List<ClientFidele> getAllClientsFideles();
    void deleteClientFidele(Long id);
    ClientFidele updateClientFidele(Long id, ClientFidele clientFidele);
}
