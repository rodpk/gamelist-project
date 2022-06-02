package br.com.rodpk.gamelist.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequest {
    
    private String name;
    private String email;
    private String nickname;
    private String password;

}
