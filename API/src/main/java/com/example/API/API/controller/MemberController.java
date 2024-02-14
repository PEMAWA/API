package com.example.API.API.controller;

import com.example.API.API.model.Member;
import com.example.API.API.repository.MemberRepository;
import org.hibernate.search.util.common.logging.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/pensions")
public class MemberController {

    //private  static Logger logger = LoggerFactory.getLogger(MemberController.class);
    @Autowired
    private MemberRepository memberRepository;

@PostMapping( value = "/")
    public ResponseEntity <Member> addMember(@RequestBody Member member){
        member = memberRepository.saveAndFlush(member);
        return new ResponseEntity<Member>(member, HttpStatus.CREATED);
    }
}
