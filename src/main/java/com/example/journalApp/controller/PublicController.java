package com.example.journalApp.controller;

import com.example.journalApp.entity.UserEntry;
import com.example.journalApp.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserEntryService userEntryService;
//    @GetMapping("/health-check")
//    public String health_check(){
//        return "Hello";
//    }

    @PostMapping("/create-user")
    public void createuser(@RequestBody UserEntry userEntry ){
        userEntryService.saveNewEntry(userEntry);
    }

}
