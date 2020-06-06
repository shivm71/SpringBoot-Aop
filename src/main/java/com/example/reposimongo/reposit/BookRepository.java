package com.example.reposimongo.reposit;

import com.example.reposimongo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepository extends MongoRepository<Book, Integer>{

}