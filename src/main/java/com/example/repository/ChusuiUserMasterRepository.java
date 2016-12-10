package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ChusuiUserMaster;

@Repository
public interface ChusuiUserMasterRepository extends JpaRepository<ChusuiUserMaster, String>{

}
