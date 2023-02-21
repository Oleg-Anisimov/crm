package me.stepanov.crm.controller;

import me.stepanov.crm.domain.Deal;
import me.stepanov.crm.dto.DealDto;
import me.stepanov.crm.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/deal")
public class DealController {
    @Autowired
    private DealService dealService;

    @PostMapping("/create")
    public DealDto create(@RequestBody DealDto dealDto) {
        return dealService.create(dealDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        dealService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody DealDto dealDto){
        dealService.update(dealDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public Deal getById(Long id){
        return dealService.getById(id);
    }

    @GetMapping("/byAll")
    public List<DealDto> getAll(){
        return dealService.getAll();
    }
}
