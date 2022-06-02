package br.com.rodpk.gamelist.model.dto;

import br.com.rodpk.gamelist.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private Integer id;
    private String name;
    private String nickname;
    private String email;
    public static UserResponse of(User u) {
        var response = new UserResponse();
        response.setEmail(u.getEmail());
        response.setId(u.getId());
        response.setName(u.getName());
        response.setNickname(u.getNickname());
        return response;
    }
    
}
