package com.nhnacademy.shoppingmall.user.service.impl;

import com.nhnacademy.shoppingmall.user.exception.UserAlreadyExistsException;
import com.nhnacademy.shoppingmall.user.exception.UserNotFoundException;
import com.nhnacademy.shoppingmall.user.service.UserService;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String userId){
        //todo#4-1 회원조회
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        //todo#4-2 회원등록

        if(userRepository.countByUserId(user.getUserId()) >= 1){
            throw new UserAlreadyExistsException("해당 아이디의 사용자가 이미 존재합니다, 다른 아이디를 사용해주십시오");
        }

        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        //todo#4-3 회원수정
        if(userRepository.countByUserId(user.getUserId()) == 1){
            userRepository.update(user);
        }
        else {
            throw new UserNotFoundException("해당 아이디의 사용자는 존재하지 않습니다");
        }
    }

    @Override
    public void deleteUser(String userId) {
        //todo#4-4 회원삭제

        if(userRepository.countByUserId(userId) == 1){
            userRepository.deleteByUserId(userId);
        }
        else {
            throw new UserNotFoundException("해당 아이디의 사용자는 존재하지 않습니다");
        }


    }

    @Override
    public User doLogin(String userId, String userPassword) {
        //todo#4-5 로그인 구현, userId, userPassword로 일치하는 회원 조회
        User user = userRepository.findByUserIdAndUserPassword(userId,userPassword).orElse(null);

        if(Objects.isNull(user)){
                throw new UserNotFoundException("해당 아이디의 회원이 존재하지 않거나 비밀번호가 일치하지 않습니다");
        }

        userRepository.updateLatestLoginAtByUserId(userId, LocalDateTime.now());

        return user;
    }

}
