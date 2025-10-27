package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.UserEntity;
import com.example.repository.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = appUserRepository.findByUserName(username);
        return userEntity
                .map((userInfo) -> new UserDetailsImpl(userInfo.getUserName(), userInfo.getUserPassword(), userInfo.getRoles()))
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}
