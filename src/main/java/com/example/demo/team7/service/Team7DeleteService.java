package com.example.demo.team7.service;
//赤坂

import org.springframework.stereotype.Service;

import com.example.demo.team7.repositories.Team7DeleteRepositories;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Team7DeleteService {

    private final Team7DeleteRepositories repository;

    public void delete(Long yoteiCd) {

        repository.deleteById(yoteiCd);
    }
    
}