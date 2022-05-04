package br.com.rodpk.gamelist.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodpk.gamelist.model.DevelopmentTeam;
import br.com.rodpk.gamelist.model.dto.DevTeamRequest;
import br.com.rodpk.gamelist.repository.DevelopmentTeamRepository;

@Service
public class DevelopmentTeamService {

    @Autowired 
    private DevelopmentTeamRepository repository;

    public String create(List<DevTeamRequest> devs) {
        List<DevelopmentTeam> entities = devs.stream().map(DevelopmentTeam::of).collect(Collectors.toList());
        var saved = repository.saveAll(entities);
        saved.size();
        //DataIntegrityViolationException
        return "saved";
    }
    
}
