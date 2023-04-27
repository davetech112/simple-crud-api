package com.example.simplemvccrud.DTO;

import com.example.simplemvccrud.Enums.Role;
import lombok.*;

@Builder
@Data

@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String username;
    private String password;
    private Role role;


}
