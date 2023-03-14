package me.stepanov.crm.controller;

import me.stepanov.crm.domain.Role;
import me.stepanov.crm.dto.RoleDto;
import me.stepanov.crm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/create")
    public RoleDto create(@RequestBody RoleDto roleDto) {
        return roleService.create(roleDto);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(Long id) {
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody RoleDto roleDto){
        roleService.update(roleDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byId")
    public Role getById(Long id){
        return roleService.getById(id);
    }

    @GetMapping("/getAll")
    public List<RoleDto> getAll(){
        return roleService.getAll();
    }
}
