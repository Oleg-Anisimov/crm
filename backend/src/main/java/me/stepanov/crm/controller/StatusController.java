package me.stepanov.crm.controller;

import me.stepanov.crm.domain.Status;
import me.stepanov.crm.dto.StatusDto;
import me.stepanov.crm.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statuses")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping("/create")
    public StatusDto create(@RequestBody StatusDto statusDto) {
        return statusService.create(statusDto);
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody StatusDto dto) {
        statusService.delete(dto.getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody StatusDto statusDto){
        statusService.update(statusDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public StatusDto getById(@PathVariable Long id){
        return statusService.getById(id);
    }

    @GetMapping
    public List<StatusDto> getAll(){
        return statusService.getAll();
    }
}
