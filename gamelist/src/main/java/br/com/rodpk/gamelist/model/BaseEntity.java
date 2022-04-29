package br.com.rodpk.gamelist.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;

@Getter
@MappedSuperclass
public class BaseEntity implements Serializable{
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    LocalDateTime updatedAt;

    @Column(name = "fl_active", nullable = false)
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
