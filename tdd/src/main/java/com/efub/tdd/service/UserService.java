package com.efub.tdd.service;

import com.efub.tdd.domain.User;
import com.efub.tdd.dto.UserResponseDto;
import com.efub.tdd.dto.UserSaveRequestDto;
import com.efub.tdd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto findById(Long id){
        //User entity = userRepository.findById(id).orElseThrow(() -> new
        //        IllegalArgumentException("해당 사용자가 없습니다. id = "+id));
        User entity = userRepository.getById(id);
        return new UserResponseDto(entity);
    }

    public User save(UserSaveRequestDto requestDTO){
        return userRepository.save(requestDTO.toEntity());
    }
}