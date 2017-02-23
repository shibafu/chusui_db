package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.ChusuiUserMaster;

@Repository
public interface ChusuiUserMasterRepository extends JpaRepository<ChusuiUserMaster, Integer>{

//	/**
//	 * このメソッドをDAOというらしい。
//	 * @param UserEmail ユーザーEメール。名前と同じ
//	 * @return　ChusuiUserMasterエンティティ。
//	 */
	//Queryアノテーションがおかしい
	@Query("SELECT c FROM ChusuiUserMaster c where c.userEmail = :uEmail")
	public List<ChusuiUserMaster> findByUserEmail(@Param("uEmail") String userEmail);
}
