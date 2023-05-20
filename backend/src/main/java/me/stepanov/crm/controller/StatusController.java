package me.stepanov.crm.controller;

import me.stepanov.crm.domain.Status;
import me.stepanov.crm.dto.StatusDto;
import me.stepanov.crm.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping("/create")
    public StatusDto create(@RequestBody StatusDto statusDto) {
        return statusService.create(statusDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        statusService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody StatusDto statusDto){
        statusService.update(statusDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public StatusDto getById(Long id){
        return statusService.getById(id);
    }

    @GetMapping("/getAll")
    public List<StatusDto> getAll(){
        return statusService.getAll();
    }
}
