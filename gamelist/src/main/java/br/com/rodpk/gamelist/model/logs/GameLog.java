package br.com.rodpk.gamelist.model.logs;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Data;

@Data
public class GameLog {

    @Id @Column(name = "game_log_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "want_to_play")
    private Integer playersWantingToPlay;

    @Column(name= "playing")
    private Integer playersPlaying;

    @Column(name = "completed")
    private Integer playersCompleted;

    @Column(name = "dropped")
    private Integer playersDropped;

    @Column(name = "good_reviews")
    private Integer goodReviews; // 7 or more  
    
    @Column(name = "neutral_reviews")
    private Integer neutralReviews; // 5 to 6
    
    @Column(name = "bad_reviews")
    private Integer badReviews; // 4 or less

    @Column(name = "total_reviews")
    private Integer totalReviews;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void PrePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
