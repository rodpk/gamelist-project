package br.com.rodpk.gamelist.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.rodpk.gamelist.model.dto.UserRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper=false)
public class User extends BaseEntity{
    
    @Id @Column(name = "user_id")  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 256)
    private String name;
    
    @Column(nullable = false, length = 256)
    private String email;
    
    @Column(nullable = false, length = 20)
    private String nickname;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String perms;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "file_id")
    private File image;
    
    @OneToMany(mappedBy = "user")
    private Set<UserGames> games;

    public static User of(UserRequest request) {
        var user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setNickname(request.getNickname());
        user.setPassword(request.getPassword());
        user.setPerms("gamelist.mainpage.read;gamelist.mainpage.write;gamelist.userpage.read;gamelist.userpage.write;");
        return user;
    }
}
