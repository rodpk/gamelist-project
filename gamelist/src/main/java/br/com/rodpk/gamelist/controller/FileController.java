package br.com.rodpk.gamelist.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rodpk.gamelist.model.File;
import br.com.rodpk.gamelist.model.dto.FileResponse;
import br.com.rodpk.gamelist.service.FileService;


@RestController
@RequestMapping("files")
public class FileController {
    
    @Autowired
    private FileService service;

    @PostMapping
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        try {
            service.save(file);
            return ResponseEntity.status(HttpStatus.OK)
                .body(String.format("File uploaded successfully: %s", file.getOriginalFilename()));

        } catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));
        }
    }

    @GetMapping
    public List<FileResponse> list() {
        return service.findAllFiles().stream().map(this::mapToFileResponse).collect(Collectors.toList());
    }

    private FileResponse mapToFileResponse(File file) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path(file.getId()).toUriString();
        
        FileResponse fileResponse = new FileResponse(file);
        fileResponse.setUrl(downloadURL);

        return fileResponse;
    }


    @GetMapping("{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Optional<File> fileEntityOptional = service.getFile(id);

        if (!fileEntityOptional.isPresent()) return ResponseEntity.notFound().build();

        File fileEntity = fileEntityOptional.get();
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
            .contentType(MediaType.valueOf(fileEntity.getContentType()))
            .body(fileEntity.getData());
    }

}
