package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ChusuiUserMaster;

@Repository
public interface ChusuiUserMasterRepository extends JpaRepository<ChusuiUserMaster, Integer>{

//	/**
//	 * このメソッドをDAOというらしい。
//	 * @param UserEmail ユーザーEメール。名前と同じ
//	 * @return　ChusuiUserMasterエンティティ。
//	 */
//	ChusuiUserMaster findByUserEmail(String UserEmail);
}
