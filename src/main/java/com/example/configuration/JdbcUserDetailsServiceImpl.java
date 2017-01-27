//package com.example.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.entity.ChusuiUserMaster;
//import com.example.repository.ChusuiUserMasterRepository;
//
//@Service
//public class JdbcUserDetailsServiceImpl implements UserDetailsService{
////	@Autowired
////	PasswordEncoder passwordEncoder;
//
//	@Autowired
//	private ChusuiUserMasterRepository cumRepository;
//
//	/**
//	 * オーバーライドなので名前変更できず。
//	 * ここで認証処理を行う。
//	 * @param UserEmail ユーザー名。Emailを使う。
//	 * @return UserDetails
//	 */
//	@Override
//	public UserDetails loadUserByUsername(String UserEmail) throws UsernameNotFoundException{
//		if ( UserEmail == null || UserEmail.isEmpty() ){
//			throw new UsernameNotFoundException("ユーザー名が入力されていません。");
//		}
//
//		ChusuiUserMaster cumster = cumRepository.findByUserEmail(UserEmail);
//		if(cumster == null) {
//			throw new UsernameNotFoundException(String.format("ユーザー名が見つかりません %s",UserEmail));
//		} else {
//			return  cumster.toMyUserDetail();
//		}
//	}
//}
