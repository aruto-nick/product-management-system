package com.geek.productmanagement.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.geek.productmanagement.entity.Admin;
import com.geek.productmanagement.service.AdminService;

//役割：①メルアド受け取り②DBから管理者を検索③Security用のUserDertailsに変換
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	//AdminServiceクラスを使えるようにする
	private final AdminService adminService;
	//AdminServiceクラスのメソッドfindByEmail()を使えるようにする
	public CustomUserDetailsService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	//loadUserByUsername()の具体的な中身を書く
	@Override
	public UserDetails loadUserByUsername(String email)
			//エラー可能性を予告
			throws UsernameNotFoundException{
		
		//①ログイン画面に入力したメルアドを元にDBから管理者検索＆adminに格納
		Admin admin = adminService.findByEmail(email);
		
		//DBに一致する管理者が無い場合
		if(admin == null) {
			throw new UsernameNotFoundException(
					"メールアドレスに一致する管理者が存在しません");
		}
		String role;
		
		//権限の設定：権限ID＝1なら「管理者」、違う場合「利用者」
		if (Integer.valueOf(1).equals(admin.getAuthorityId())) {
			role = "ADMIN";
		}else {
			role = "USER";
		}
		return User.withUsername(admin.getEmail())
				.password(admin.getPassword()).roles(role).build();
	}

}
