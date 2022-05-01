package br.com.rodpk.gamelist.service.logs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.rodpk.gamelist.model.UserGames;
import br.com.rodpk.gamelist.model.logs.GameLog;

public class GameLogService {
    

    //repository

    public void saveInformation() {
        GameLog log = new GameLog();

        List<UserGames> list = new ArrayList<>(); // list of userGames?
        HashMap<String, Integer> statusData = sortStatusData(list);
        HashMap<String, Integer> reviewData = sortReviewData(list);

        log.setPlayersCompleted(statusData.get("completed"));
        log.setPlayersDropped(statusData.get("dropped"));
        log.setPlayersPlaying(statusData.get("playing"));
        log.setPlayersWantingToPlay(statusData.get("wantToPlay"));
        log.setGoodReviews(reviewData.get("good"));
        log.setNeutralReviews(reviewData.get("neutral"));
        log.setBadReviews(reviewData.get("bad"));
        
        Integer totalReviews = reviewData.get("good") + reviewData.get("neutral") + reviewData.get("bad");
        log.setTotalReviews(totalReviews);

        // logRepository.save(log);

    }



    private HashMap<String, Integer> sortStatusData(List<UserGames> list) {
        
        HashMap<String, Integer> info = new HashMap<>();
        Integer droppedQuantity = 0;
        Integer completedQuantity = 0;
        Integer gamingQuantity = 0;
        Integer wantToPlayQuantity = 0;

        for(UserGames userGame : list) {
            switch(userGame.getStatus()) {
                case COMPLETED:
                    completedQuantity += 1;
                    info.put("completed", completedQuantity);
                break;

                case DROPPED:
                    droppedQuantity += 1;
                    info.put("dropped", droppedQuantity);
                break;

                case GAMING:
                    gamingQuantity +=1;
                    info.put("gaming", gamingQuantity);
                break;

                case WANT_TO_PLAY:
                    wantToPlayQuantity +=1;
                    info.put("wantToPlay", wantToPlayQuantity);
                break;
                
                default:
                break;
            }
        }
        return info;
    }

    private HashMap<String, Integer> sortReviewData(List<UserGames> list) {

        HashMap<String, Integer> info = new HashMap<>();
        Integer goodReviews = 0;
        Integer neutralReviews = 0;
        Integer badReviews = 0;

        for(UserGames userGame : list) {

            if (userGame.getScore() != null) {
                if (userGame.getScore() >= 7 && userGame.getScore() <= 10) {
                    goodReviews +=1;
                    info.put("good", goodReviews);
                } else if(userGame.getScore() >= 5 && userGame.getScore() <= 6) {
                    neutralReviews += 1;
                    info.put("neutral", neutralReviews);
                } else if (userGame.getScore() >= 0 && userGame.getScore() <= 4) {
                    badReviews += 1;
                    info.put("bad", badReviews);
                }
            }
        }
        return info;
    }

    

    
}
