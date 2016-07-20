package org.test.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.test.spring.model.Record;
import org.test.spring.service.RecordService;

@Controller
public class MyController {

    private RecordService recordService;

    @Autowired(required = true)
    @Qualifier(value = "recordService")
    public void setRecordService(RecordService recordService) {
        this.recordService = recordService;
    }

    @RequestMapping(value = "second", method = RequestMethod.GET)
    public String listRecords(Model model) {
        model.addAttribute("record", new Record());
        model.addAttribute("listRecords", this.recordService.listRec());
        return "second";
    }

    @RequestMapping(value = "third")
    public String addForm(Model model) {
        model.addAttribute("record", new Record());
        return "third";
    }

    @RequestMapping("/remove/{id}")
    public String removeRecords(@PathVariable("id") int id) {
        this.recordService.removeRec(id);
        return "redirect:/second";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public String addRecord(@ModelAttribute("record") Record record) {
        if (record.getId() == 0) {
            this.recordService.addRec(record);
        } else {
            this.recordService.updateRec(record);
        }
        return "redirect:/second";
    }

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
    public String editRecord(@PathVariable("id") int id, Model model) {
        model.addAttribute("record", recordService.getRecById(id));
        return "third";
    }

}
