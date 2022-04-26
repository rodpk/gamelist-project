package br.com.rodpk.gamelist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodpk.gamelist.model.Platform;
import br.com.rodpk.gamelist.model.dto.PlatformRequest;
import br.com.rodpk.gamelist.model.dto.PlatformResponse;
import br.com.rodpk.gamelist.model.enums.PlatformEnum;
import br.com.rodpk.gamelist.repository.PlatformRepository;

@Service
public class PlatformService {

    @Autowired
    PlatformRepository repository;

    public PlatformResponse findById(Integer id) {
        Platform platform = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        var response = PlatformResponse.of(platform);
        return response;
    }

    public Platform save(PlatformRequest request) {
        validateAtributes(request);
        var platform = repository.save(Platform.of(request));

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
        // repository.save(new Platform(platform));
        repository.saveAll(platforms);
    }
}
