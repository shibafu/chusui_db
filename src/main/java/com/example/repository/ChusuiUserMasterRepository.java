package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	//Eメールで検索するメソッド
	@Query("SELECT c FROM ChusuiUserMaster c where c.userEmail = :uEmail")
	public List<ChusuiUserMaster> findByUserEmail(@Param("uEmail") String userEmail);

	//Eメールで検索するメソッド まだ作ってないよ
	//c.userFirstName = :uUserFitstname  c.userPassword = :uUserPassword c.userEmail = :uEmail c.enabled = :uEnabled c.authority = :uAuthority
	@Query("update ChusuiUserMaster set "
			+ " userLastname = :uUserLastname, "
			+ " userFirstName = :uUserFirstname, "
			+ " userPassword = :uUserPassword, "
			+ " userEmail = :uEmail, "
			+ " enabled = :uEnabled, "
			+ " authority = :uAuthority "
			+ " where userEmail = :befEmail ")
	@Modifying(clearAutomatically = true) //Updateに必要
	public Integer updateByEmail(
			@Param("uUserLastname") String userLastname,
			@Param("uUserFirstname") String userFitstname,
			@Param("uUserPassword") String userPassword,
			@Param("uEmail") String userEmail,
			@Param("uEnabled") Boolean uEnabled,
			@Param("uAuthority") String uAuthority,
			@Param("befEmail") String befEmail);
}
