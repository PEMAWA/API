package com.example.API.API.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.*;


import java.math.BigDecimal;

@Table(name = "Books")
@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Book {

    @JsonProperty(value = "book_id",required = false)
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_id_seq")
    @SequenceGenerator(name = "book_id_seq",sequenceName = "book_id_sequence" ,allocationSize=1)
    @Id
    private Long bookId;

    @JsonProperty("book_title")
    @Column(name = "BOOK_TITLE")
    private String bookTitle;

    @JsonProperty("book_price")
    @Column(name = "BOOK_PRICE")
    private BigDecimal bookPrice;

    @JsonProperty("book_author")
    @Column(name = "BOOK_AUTHOR")
    private String bookAuthor;

}