package br.com.rodpk.gamelist.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Getter
@MappedSuperclass
public class BaseEntity implements Serializable{
    
    @JsonIgnore
    @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false)
    LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    LocalDateTime updatedAt;

    @JsonIgnore
    @Column(name = "active", nullable = false)
    boolean active = true;



    @PrePersist
    public void PrePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void PreUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
