package br.com.rodpk.gamelist.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.rodpk.gamelist.model.enums.CategoryEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Category extends BaseEntity{
    @Id @Column(name = "category_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @ManyToMany(mappedBy = "categories")
    private Set<Game> games;

    public Category(CategoryEnum category) {
        this.name = category;
    }
}
