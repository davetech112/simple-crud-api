package com.example.simplemvccrud.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Builder
@Data
@RequiredArgsConstructor
public class UserDTO {
    private Long userId;
    private String username;
    private String password;
    private Enum Role;


}
