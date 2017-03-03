package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.CustomerMaster;

@Repository
public interface CustomerMasterRepository extends JpaRepository<CustomerMaster,Integer>{
	//検索
	@Query("SELECT c FROM CustomerrMaster c where c.email = :uEmail")
	public List<CustomerMaster> findByUserEmail(@Param("uEmail") String userEmail);

}
