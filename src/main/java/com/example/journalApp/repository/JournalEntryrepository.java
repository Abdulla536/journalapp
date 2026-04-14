package com.example.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.journalApp.entity.JournalEntry;

public interface JournalEntryrepository extends MongoRepository<JournalEntry, ObjectId> {
}
