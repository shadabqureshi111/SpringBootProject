//package com.csm.repository;
//
//import com.csm.model.User;
//
//import lombok.Data;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//@Data
//public class SecurityUser implements UserDetails {
//
//    private  User user;
//
//    public SecurityUser(User user) {
//        this.user = user;
//    }
//
//    public SecurityUser(String username, String password, List<Object> of) {
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // You can define and return the user's authorities/roles here
//        return Collections.emptyList();
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
