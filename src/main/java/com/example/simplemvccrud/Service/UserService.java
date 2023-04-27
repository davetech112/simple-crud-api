package com.example.simplemvccrud.Service;

import com.example.simplemvccrud.DTO.UserDTO;

public interface UserService {
    UserDTO login(UserDTO userDTO);
    UserDTO signup(UserDTO userDTO);
    UserDTO update( Long id);
    void delete(Long userId);
}
