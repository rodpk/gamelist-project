package br.com.rodpk.gamelist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "user_profile")
@EqualsAndHashCode(callSuper=false)
public class UserProfile extends BaseEntity{

    @Id @Column(name = "user_profile_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private User user;


    @Lob
    @Column(name = "image")
    private byte[] image; // string mesmo? - tratar anexo de imagens

    @Column(nullable = false, length = 20)
    private String nickname;
    
}
