package com.tsugaruweb.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.tsugaruweb.entity.Author;
import com.tsugaruweb.repository.AuthorRepository;

@Component
public class JdbcAuthorDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	AuthorRepository auRepository;

	public final Integer DBUPDATE_SUCCESSED = 0;
	public final Integer DBUPDATE_FAILURE = 1;

	public Author findByUsermail(String x_email){
		List<Author> result = auRepository.findByEmail(x_email);

		//Ifで条件分岐するのめんどいのでオプショナル型で
		Author findedAuthor = Optional.ofNullable(result)
				.map(resultLamdaVar -> resultLamdaVar.get(0))
				.orElseThrow(null);

		return findedAuthor;
	}

	/**
	 * ユーザー登録アクセス
	 * @param x_cuUserRegisterエンティティに書き込む情報
	 * 	1,名前2,姓3,パスワードハッシュ,4.Eメール
	 * @return
	 */
	public Integer AuthorRegister(List<String>x_cuUserRegister){
		//エンティティ作成
		//姓　名　パスワード　Eメールの順番
		Author a = new Author();
		a.setAuthorFirstname(x_cuUserRegister.get(0));
		a.setAuthorFirstname(x_cuUserRegister.get(1));
		a.setPassword(x_cuUserRegister.get(2));
		a.setEmail(x_cuUserRegister.get(3));
		a.setAuthority("ROLE_ADMIN");
		a.setEnabled(true);

		//書き込み
		if(auRepository.saveAndFlush(a) != null){
			return DBUPDATE_SUCCESSED;
		}else{
			return DBUPDATE_FAILURE;
		}
	}
}
