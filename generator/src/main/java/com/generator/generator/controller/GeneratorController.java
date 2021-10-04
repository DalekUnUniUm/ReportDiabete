package com.generator.generator.controller;

import com.generator.generator.model.GeneratorModel;
import com.generator.generator.service.GeneratorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratorController {

    @Autowired
    private GeneratorServiceInterface generatorServiceInterface ;

    @GetMapping("/generator/{patId}")
    public int getTriggerTerm(@PathVariable("patId") String patId){
        return generatorServiceInterface.getTriggerTerm(patId) ;
    }

}
