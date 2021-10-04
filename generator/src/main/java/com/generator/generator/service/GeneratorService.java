package com.generator.generator.service;

import com.generator.generator.constant.TriggerTermConst;
import com.generator.generator.model.GeneratorModel;
import com.generator.generator.repository.GeneratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService implements GeneratorServiceInterface{

    @Autowired
    private GeneratorRepository generatorRepository ;


    @Override
    public int getTriggerTerm(String patId){
        GeneratorModel generatorModel = new GeneratorModel();
        generatorModel.setTriggerTerm(0);

        for(int i = 0 ; i < TriggerTermConst.TRIGGER_TERM_LIST.length ; i++){
            generatorModel.setTriggerTerm(generatorModel.getTriggerTerm() + generatorRepository.getCountTriggerTerm(patId,TriggerTermConst.TRIGGER_TERM_LIST[i]));
        }


        return generatorModel.getTriggerTerm();
    }

}
