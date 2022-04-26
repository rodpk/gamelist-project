package br.com.rodpk.gamelist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodpk.gamelist.model.Platform;
import br.com.rodpk.gamelist.model.dto.PlatformRequest;
import br.com.rodpk.gamelist.model.dto.PlatformResponse;
import br.com.rodpk.gamelist.service.PlatformService;

@RestController
@RequestMapping("/platforms")
public class PlatformController {
    

    @Autowired
    PlatformService service;


    @GetMapping("/{id}")
    public PlatformResponse findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping("populate")
    public ResponseEntity<?> populate() {
        service.saveAllPlatformsInDatabase();
        return ResponseEntity.ok("done");
    }

    @PostMapping
    public Platform save(@RequestBody PlatformRequest request) {
        return service.save(request);
    }

    @GetMapping
    public List<PlatformResponse> listAll() {
        return service.findAll();
    }

}
