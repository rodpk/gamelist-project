package br.com.rodpk.gamelist.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.BeanUtils;

import br.com.rodpk.gamelist.model.dto.PlatformRequest;
import br.com.rodpk.gamelist.model.enums.PlatformEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Platform extends BaseEntity{
    

    @Id @Column(name = "platform_id") @GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE)
    private Integer id;


    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private PlatformEnum name;

    @ManyToMany(mappedBy = "platforms")
    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Game> games;


    // if that doesnt work I can copy the atributes directly...
    public static Platform of(PlatformRequest request) {
        var platform = new Platform();
        BeanUtils.copyProperties(request, platform);
        return platform;
    }

    public Platform(PlatformEnum name) {
        this.name = name;
    }

    public Platform() {}
}
