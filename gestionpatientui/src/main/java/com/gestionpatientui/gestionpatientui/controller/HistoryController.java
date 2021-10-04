package com.gestionpatientui.gestionpatientui.controller;

import com.gestionpatientui.gestionpatientui.model.History;
import com.gestionpatientui.gestionpatientui.model.Patient;
import com.gestionpatientui.gestionpatientui.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService ;

    private String patIdToRedirect ;

    @GetMapping("/updateNote/{id}")
    public String updateNote(@PathVariable("id") String id, Model model) {
        History h = historyService.getHistory(id);
        patIdToRedirect = h.getPatId();
        model.addAttribute("history", h);
        return "updateNoteForm";
    }


    @GetMapping("/addNotes/{patId}")
    public String addNotes(@PathVariable("patId") String patId, Model model){
        History h = new History();
        h.setPatId(patId);
        patIdToRedirect = h.getPatId();
        model.addAttribute("history", h);
        return "addNotesForm" ;
    }

    @PostMapping("/addNote")
    public ModelAndView addNote(@ModelAttribute History history){
        historyService.addNote(history);
        return new ModelAndView("redirect:/sheetPatient/"+patIdToRedirect);
    }

}
