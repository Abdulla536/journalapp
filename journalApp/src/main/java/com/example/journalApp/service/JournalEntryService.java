package com.example.journalApp.service;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.UserEntry;
import com.example.journalApp.repository.JournalEntryrepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryrepository journalEntryrepository;
    @Autowired
    private UserEntryService userEntryService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        UserEntry userEntry=userEntryService.findByUserName(userName);
        JournalEntry saved = journalEntryrepository.save(journalEntry);
        userEntry.getJournalEntries().add(saved);
        userEntryService.saveUser(userEntry);
    }
    public void saveEntry(JournalEntry journalEntry){

        journalEntryrepository.save(journalEntry);
    }


    public List<JournalEntry> getAll(){
       return journalEntryrepository.findAll();

    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryrepository.findById(id);
    }

    @Transactional
    public  boolean deletebyid(ObjectId id, String userName){
        boolean removed=false;
        try {
            UserEntry userEntry = userEntryService.findByUserName(userName);
             removed = userEntry.getJournalEntries().removeIf(x -> x.getId().equals(id));
        if(removed) {
            userEntryService.saveUser(userEntry);
            journalEntryrepository.deleteById(id);
        }
        }
        catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error accourd");
        }
        return removed;

    }


}
// controller -->service -->repository