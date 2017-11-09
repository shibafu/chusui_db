package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.entity.*;

@Transactional
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

	//IDで検索するメソッド
	@Query("SELECT c FROM Author a where ca.Author_id = :uEmail")
	public List<Author> findById(@Param("uEmail") Integer Id);
	//Emailで検索するメソッド
	@Query("SELECT c FROM Author a where a.email = :uEmail")
	public List<Author> findByEmail(@Param("uEmail") String Email);
	//Emailでアップデートするメソッド
	@Query("UPDATE Author a SET"
			+ " a.authorLastName = :uAuthorLastname, "
			+ " a.authorFirstName = :uAuthorFirstname, "
			+ " a.password = :uPassword, "
			+ " a.email = :uEmail, "
			+ " a.authority = :uAuthority "
			+ " a.enabled = :uEnabled, "
			+ " a.handlenaame = :uEnabled, "
			+ " a.enabled = :uEnabled, "
			+ " where a.userEmail = :befEmail ")
	public Integer updateByEmail(
			@Param("uAuthorLastname") String authorLastname,
			@Param("uAuthorFirstname") String authorFitstname,
			@Param("uPassword") String password,
			@Param("uEmail") String email,
			@Param("uEnabled") Boolean enabled,
			@Param("uAuthority") String authority,
			@Param("befEmail") String befEmail);
	//Emailでデリートするメソッド
	@Query("DELETE FROM Author a"
			+ " a.authorLastName = :uAuthorLastname, "
			+ " a.authorFirstName = :uAuthorFirstname, "
			+ " a.password = :uPassword, "
			+ " a.email = :uEmail, "
			+ " a.authority = :uAuthority "
			+ " a.enabled = :uEnabled, "
			+ " a.handlenaame = :uEnabled, "
			+ " a.enabled = :uEnabled, "
			+ " where a.userEmail = :befEmail ")
	public Integer deleteByEmail(
			@Param("uAuthorLastname") String authorLastname,
			@Param("uAuthorFirstname") String authorFitstname,
			@Param("uPassword") String password,
			@Param("uEmail") String email,
			@Param("uEnabled") Boolean enabled,
			@Param("uAuthority") String authority,
			@Param("befEmail") String befEmail);
}
