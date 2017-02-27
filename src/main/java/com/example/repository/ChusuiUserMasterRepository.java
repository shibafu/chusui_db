package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.ChusuiUserMaster;

@Transactional//updateクエリに必要なアノテーション
@Repository
public interface ChusuiUserMasterRepository extends JpaRepository<ChusuiUserMaster, Integer>{

//	/**
//	 * このメソッドをDAOというらしい。
//	 * @param UserEmail ユーザーEメール。名前と同じ
//	 * @return　ChusuiUserMasterエンティティ。
//	 */
	//Eメールで検索するメソッド
	@Query("SELECT c FROM ChusuiUserMaster c where c.userEmail = :uEmail")
	public List<ChusuiUserMaster> findByUserEmail(@Param("uEmail") String userEmail);

	//Eメールで検索するメソッド まだ作ってないよ
	//c.userFirstName = :uUserFitstname  c.userPassword = :uUserPassword c.userEmail = :uEmail c.enabled = :uEnabled c.authority = :uAuthority
	//省力系のコードが動かない。カラム指定はエンティティのフィールド名で。
	@Modifying //Updateに必要
	@Query("update ChusuiUserMaster a set "
			+ " a.userLastName = :uUserLastname, "
			+ " a.userFirstName = :uUserFirstname, "
			+ " a.userPassword = :uUserPassword, "
			+ " a.userEmail = :uEmail, "
			+ " a.enabled = :uEnabled, "
			+ " a.authority = :uAuthority "
			+ " where a.userEmail = :befEmail ")
	public Integer updateByEmail(
			@Param("uUserLastname") String userLastname,
			@Param("uUserFirstname") String userFitstname,
			@Param("uUserPassword") String userPassword,
			@Param("uEmail") String userEmail,
			@Param("uEnabled") Boolean uEnabled,
			@Param("uAuthority") String uAuthority,
			@Param("befEmail") String befEmail);
}
