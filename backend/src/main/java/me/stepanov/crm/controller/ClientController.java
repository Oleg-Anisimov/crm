package me.stepanov.crm.controller;

import me.stepanov.crm.domain.Client;
import me.stepanov.crm.dto.ClientDto;
import me.stepanov.crm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ClientDto create(@RequestBody ClientDto clientDto) {
        return clientService.create(clientDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Client client){
        clientService.update(client);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public Client getById(Long id){
        return clientService.getById(id);
    }

    @GetMapping("/byAll")
    public List<ClientDto> getAll(){
        return clientService.getAll();
    }


}
