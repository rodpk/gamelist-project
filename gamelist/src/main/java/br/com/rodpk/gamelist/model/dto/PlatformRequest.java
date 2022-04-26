package br.com.rodpk.gamelist.model.dto;

import br.com.rodpk.gamelist.model.enums.PlatformEnum;
import lombok.Data;


@Data
public class PlatformRequest {
    private PlatformEnum name;
    
}
