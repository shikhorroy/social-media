package com.security;

import com.socialmedia.socialmedia.daos.SmUserDao;
import com.socialmedia.socialmedia.models.SmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class AppUserDetailService implements UserDetailsService {

  @Autowired
  SmUserDao smUserDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    SmUser user = smUserDao.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
        getAuthorities(user));
  }

  private static Collection<? extends GrantedAuthority> getAuthorities(SmUser user) {
    String[] userRoles = new String[]{"USER", "ADMIN"};
    Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
    return authorities;
  }
}
