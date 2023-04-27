package com.example.simplemvccrud.Service.ServiceImpl;

import com.example.simplemvccrud.DTO.UserDTO;
import com.example.simplemvccrud.Model.Users;
import com.example.simplemvccrud.Repository.UserRepository;
import com.example.simplemvccrud.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private HttpServletRequest request;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, HttpServletRequest request) {
        this.userRepository = userRepository;
        this.request = request;
    }
    @Override
    public UserDTO login(UserDTO userDTO){
        Users user = userRepository.findByUsernameAndPassword(userDTO.getUsername(),userDTO.getPassword())
                .orElseThrow(()->new RuntimeException("User not found"));
        UserDTO mappedUser = mapToUser(user);
        HttpSession session = request.getSession();
        session.setAttribute("id",mappedUser.getUserId());
        return mappedUser;
    }
    @Override
    public UserDTO signup(UserDTO userDTO){
        Users user = userRepository.save(mapToUserDTO(userDTO));
        return mapToUser(user);
    }
    @Override
    public UserDTO update( Long id){
        Users user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        return mapToUser(user);
    }
    @Override
    public void delete(Long userId){
        userRepository.deleteById(userId);
    }

    private Users mapToUserDTO(UserDTO userdto){
        Users user = Users.builder()
                .userId(userdto.getUserId())
                .username(userdto.getUsername())
                .password(userdto.getPassword())
                .Role(userdto.getRole())
                .build();
        return user;
    }
    private UserDTO mapToUser(Users user){
        UserDTO userDTO = UserDTO.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .password(user.getPassword())
                .Role(user.getRole())
                .build();
        return userDTO;
    }

}
