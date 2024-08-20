package com.example.nhom10.service;

import com.example.nhom10.DTO.UserDTO;
import com.example.nhom10.dao.UserRepository;
import com.example.nhom10.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<UserDTO> getAll() {

        List<User> userList = userRepository.findAll();


        List<UserDTO> userDTOList = userList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return userDTOList;
    }


    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getFullName(), user.getRole());
    }
}
