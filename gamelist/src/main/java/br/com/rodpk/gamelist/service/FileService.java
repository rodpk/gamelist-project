package br.com.rodpk.gamelist.service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rodpk.gamelist.config.exception.EntityNotFoundException;
import br.com.rodpk.gamelist.model.File;
import br.com.rodpk.gamelist.model.dto.FileResponse;
import br.com.rodpk.gamelist.repository.FileRepository;

@Service
public class FileService {
    
    @Autowired
    private FileRepository repository;

    private Logger log = Logger.getLogger("FileService");

    public File save(MultipartFile multipartFile) {
        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        
        try {
            File file = new File();
            file.setName(filename);
            file.setContentType(multipartFile.getContentType());
            file.setData(multipartFile.getBytes());
            file.setSize(file.getSize());
    
            log.info(String.format("file %s saved successfully", filename));
            return repository.save(file);
        } catch(Exception ex) {
            log.severe(String.format("Error trying to save %s file on database: %s", filename, ex.getMessage()));
            throw new RuntimeException(String.format("Error trying to save %s file on database: %s", filename, ex.getMessage()));
        }
    }

    public File findFile(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("not found"));
    }

    public List<FileResponse> findAllFiles() {
        return repository.findAll().stream().map(this::mapToFileResponse).collect(Collectors.toList());
    }

    private FileResponse mapToFileResponse(File file) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path(file.getId()).toUriString();
        
        FileResponse fileResponse = new FileResponse(file);
        fileResponse.setUrl(downloadURL);

        return fileResponse;
    }
}
