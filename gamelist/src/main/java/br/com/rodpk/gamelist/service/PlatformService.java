package br.com.rodpk.gamelist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodpk.gamelist.config.exception.EntityNotFoundException;
import br.com.rodpk.gamelist.model.Platform;
import br.com.rodpk.gamelist.model.dto.PlatformRequest;
import br.com.rodpk.gamelist.model.dto.PlatformResponse;
import br.com.rodpk.gamelist.model.enums.PlatformEnum;
import br.com.rodpk.gamelist.repository.PlatformRepository;

@Service
public class PlatformService {

    @Autowired
    private PlatformRepository repository;

    private Logger log = Logger.getLogger("PlatformService");

    public PlatformResponse findById(Integer id) {
        Platform platform = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
        var response = PlatformResponse.of(platform);
        log.info("null");
        return response;
    }

    public Platform save(PlatformRequest request) {
        validateAtributes(request);
        var platform = repository.save(Platform.of(request));
        log.info(String.format("platform %s saved successfully", platform.getName()));
        return platform;
    }

    public List<PlatformResponse> findAll() {
        return repository.findAll().stream().map(PlatformResponse::of).collect(Collectors.toList());
    }
    
    private void validateAtributes(PlatformRequest request) {

    }
    

    public void saveAllPlatformsInDatabase() {    
        List<Platform> platforms = new ArrayList<>();
        for (PlatformEnum platform : PlatformEnum.class.getEnumConstants()) {
            platforms.add(new Platform(platform));
        }
        repository.saveAll(platforms);
        log.info("all platforms saved successfully");
    }
}
