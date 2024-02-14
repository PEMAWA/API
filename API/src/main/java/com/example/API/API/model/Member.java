package com.example.API.API.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Table(name = "PNP_MEMBER")
@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Member {
    @JsonProperty(value = "MEMBER_NO" , required = false)
    @Column(name = "MEMBER_NO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "memberno_seq")
    @SequenceGenerator( name = "memberno_seq",sequenceName = "memberno_sequence",allocationSize = 1)
    @Id

    private  Long memberNo;
    @JsonProperty("member_name")
    @Column(name = "MEMBER_NAME")
    private  String Member_name;

    @JsonProperty("date_Of_Birth")
    @Column( name = "DATE_OF_BIRTH")

    private LocalDate Date_of_birth;

    @JsonProperty("join_date")
    @Column(name = "JOIN_DATE")
    private  LocalDate join_date;


    @JsonProperty("kra_pin")
    @Column(name ="KRA_PIN")
    private String kra_pin;
    @JsonProperty("tel_no")
    @Column(name ="TEL_NO")
    private String tel_no;

   // DATE_OF_BIRTH DATE,
   // JOIN_DATE DATE,
  //  KRA_PIN VARCHAR(40),
  //  TEL_NO VARCHAR2(40)

}
