package com.tsugaruweb.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsugaruweb.entity.*;

@Transactional
@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster,Integer>{
	//検索
	@Query("SELECT u FROM UserMaster u where u.email = :uEmail")
	public List<UserMaster> findByUserEmail(@Param("uEmail") String userEmail);

}
