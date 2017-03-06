package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.NewsCompany;

public interface NewsCompanyRepository extends JpaRepository<NewsCompany,Integer> {

}
