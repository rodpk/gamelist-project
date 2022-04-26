package br.com.rodpk.gamelist.model.dto;

import br.com.rodpk.gamelist.model.Platform;
import lombok.Data;

@Data
public class PlatformResponse {
    
    private Integer id;
    private String platform;


    public static PlatformResponse of(Platform p) {
        var platform = new PlatformResponse();
        platform.setId(p.getId());
        platform.setPlatform(p.getName().value());

        return platform;
    }

    public PlatformResponse () {}
}
