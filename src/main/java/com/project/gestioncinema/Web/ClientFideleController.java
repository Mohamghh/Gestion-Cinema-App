package com.project.gestioncinema.Web;


import com.project.gestioncinema.Entities.ClientFidele;
import com.project.gestioncinema.Service.ClientFideleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clientfideles")
public class ClientFideleController {

    @Autowired
    private ClientFideleService clientFideleService;

    @PostMapping("/AddClientFidele")
    public ResponseEntity<ClientFidele> saveClientFidele(@RequestBody ClientFidele clientFidele) {
        ClientFidele savedClientFidele = clientFideleService.saveClientFidele(clientFidele);
        return ResponseEntity.ok(savedClientFidele);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientFidele> getClientFideleById(@PathVariable Long id) {
        ClientFidele clientFidele = clientFideleService.getClientFidele(id);
        return ResponseEntity.ok(clientFidele);
    }


    @GetMapping
    public ResponseEntity<List<ClientFidele>> getAllClientsFideles() {
        List<ClientFidele> clientsFideles = clientFideleService.getAllClientsFideles();
        return ResponseEntity.ok(clientsFideles);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientFidele(@PathVariable Long id) {
        clientFideleService.deleteClientFidele(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/updateClientF/{id}")
    public ResponseEntity<ClientFidele> updateClientFidele(@PathVariable Long id, @RequestBody ClientFidele updatedClientFidele) {
        ClientFidele clientFidele = clientFideleService.updateClientFidele(id, updatedClientFidele);
        return ResponseEntity.ok(clientFidele);
    }
}
