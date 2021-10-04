package com.gestionpatientui.gestionpatientui.service;

import com.gestionpatientui.gestionpatientui.model.Generator;
import com.gestionpatientui.gestionpatientui.repository.GeneratorProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {

    @Autowired
    private GeneratorProxy generatorProxy ;

    public int getTriggerTerm(String patId){
        return generatorProxy.getTriggerTerm(patId);
    }

}
