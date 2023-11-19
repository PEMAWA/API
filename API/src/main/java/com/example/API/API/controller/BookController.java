package com.example.API.API.controller;
import com.example.API.API.model.Book;
import com.example.API.API.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    private static Logger logger= LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books=bookRepository.findAll();
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @GetMapping(value = "/{bookId}")
    public ResponseEntity<Book> getBook(Long bookId){
        Optional<Book> book=bookRepository.findById(bookId);
        if(!book.isPresent()){
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Book>(book.get(),HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") Long bookId){
        Optional<Book> book=bookRepository.findById(bookId);
        if(!book.isPresent()){
            return new ResponseEntity<String>("Book not found",HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<String>("Book deleted",HttpStatus.OK);
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        book=bookRepository.saveAndFlush(book);
        return new ResponseEntity<Book>(book,HttpStatus.CREATED);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        book=bookRepository.saveAndFlush(book);
        return new ResponseEntity<Book>(book,HttpStatus.ACCEPTED);
    }
}
