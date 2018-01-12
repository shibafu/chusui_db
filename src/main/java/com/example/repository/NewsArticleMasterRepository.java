package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.NewsArticleMaster;

public interface NewsArticleMasterRepository extends JpaRepository<NewsArticleMaster,Integer>{

}
