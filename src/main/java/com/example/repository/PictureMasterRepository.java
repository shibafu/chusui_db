package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.PictureMaster;


@Transactional
@Repository
public interface PictureMasterRepository extends JpaRepository<PictureMaster, Integer>{

	@Query("SELECT a FROM PictureMaster a WHERE a.id = :uId")
	public List<PictureMaster> findbyId(@Param("uId") Integer id);
	@Query("SELECT a FROM PictureMaster a WHERE a.name = :uName")
	public List<PictureMaster> findByName(@Param("uName") String name);

}
