//package com.tsugaruweb.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.tsugaruweb.entity.*;
//
//@Transactional
//@Repository
//public interface AuthorRepository extends JpaRepository<Author, Integer> {
//
//	//IDで検索するメソッド
//	@Query("SELECT a FROM Author a where a.authorId = :uId")
//	public List<Author> findById(@Param("uId") Integer Id);
//	//Emailで検索するメソッド
//	@Query("SELECT a FROM Author a where a.email = :uEmail")
//	public List<Author> findByEmail(@Param("uEmail") String Email);
//	//Emailでアップデートするメソッド
//	@Query("UPDATE Author a SET "
//			+ " a.authorLastname = :uAuthorLastname, "
//			+ " a.authorFirstname = :uAuthorFirstname, "
//			+ " a.password = :uPassword, "
//			+ " a.email = :uEmail, "
//			+ " a.authority = :uAuthority, "
//			+ " a.enabled = :uEnabled "
//			+ " where a.email = :befEmail ")
//	public Integer updateByEmail(
//			@Param("uAuthorLastname") String authorLastname,
//			@Param("uAuthorFirstname") String authorFirstname,
//			@Param("uPassword") String password,
//			@Param("uAuthority") String authority,
//			@Param("uEmail") String email,
//			@Param("uEnabled") Boolean enabled,
//			@Param("befEmail") String befEmail);
//	//Emailでデリートするメソッド
//	@Query("DELETE FROM Author a"
//			+ " where a.email = :befEmail ")
//	public Integer deleteByEmail(
//			@Param("befEmail") String befEmail);
//}
