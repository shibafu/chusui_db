package com.tsugaruweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsugaruweb.entity.NewsArticleMaster;


@Transactional
@Repository
public interface NewsArticleMasterRepository extends JpaRepository<NewsArticleMaster,Integer>{

}
