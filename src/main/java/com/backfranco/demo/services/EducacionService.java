package com.backfranco.demo.services;

import com.backfranco.demo.models.Educacion;
import com.backfranco.demo.repository.EducacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EducacionService {
    private final EducacionRepo educacionRepo;


    @Autowired
    public EducacionService(EducacionRepo educacionRepo) {
        this.educacionRepo = educacionRepo;
    }

    public Educacion addEducacion(Educacion educacion){
        return educacionRepo.save(educacion);

    }
    public List<Educacion> buscarEducacion(){
        return educacionRepo.findAll();

    }

    public Educacion editarEducacion(Educacion educacion){
        return educacionRepo.save(educacion);

    }

    public void borrarEducacion(Long id){
        educacionRepo.deleteById(id);

    }

}