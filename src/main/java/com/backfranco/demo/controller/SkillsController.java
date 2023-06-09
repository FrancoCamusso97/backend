package com.backfranco.demo.controller;


import com.backfranco.demo.models.Skills;

import com.backfranco.demo.services.SkillsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"https://argentinaprogramayoprogramo.web.app"})
@RequestMapping("/skills")
public class SkillsController {
    private final SkillsService skillsService;
    public SkillsController(SkillsService skillsService){
        this.skillsService = skillsService;
    }

    @PutMapping("/update")
    public ResponseEntity<Skills> editarSkills(@RequestBody Skills skills){
        Skills updateSkills = skillsService.editarSkills(skills);
        return new ResponseEntity<>(updateSkills, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Skills>> obtenerSkills(){
        List<Skills> skills= skillsService.buscarSkills();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Skills> crearSkills(@RequestBody Skills skills){
        Skills nuevaSkills = skillsService.addSkills(skills);
        return new ResponseEntity<>(nuevaSkills, HttpStatus.OK);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarSkills(@PathVariable("id") Long id){
        skillsService.borrarSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }



}
