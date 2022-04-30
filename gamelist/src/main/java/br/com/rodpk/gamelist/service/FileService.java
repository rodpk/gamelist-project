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
import br.com.rodpk.gamelist.utils.MessagesConstants;

@Service
public class FileService {
    
    @Autowired
    private FileRepository repository;

    private Logger log = Logger.getLogger("FileService");

    public String save(MultipartFile multipartFile) {

        try {
            File file = new File();
            file.setName(StringUtils.cleanPath(multipartFile.getOriginalFilename()));
            file.setContentType(multipartFile.getContentType());
            file.setData(multipartFile.getBytes());
            file.setSize(file.getSize());
    
            repository.save(file);
            log.info(MessagesConstants.FILE_UPLOADED + multipartFile.getOriginalFilename());
            return MessagesConstants.FILE_UPLOADED + multipartFile.getOriginalFilename();
        } catch(Exception ex) {
            log.severe(MessagesConstants.FILE_ERROR_UPLOADING + multipartFile.getOriginalFilename());
            log.severe(ex.getMessage());
            throw new RuntimeException(MessagesConstants.FILE_ERROR_UPLOADING + multipartFile.getOriginalFilename());
        }
    }

    public File getFile(String id) {
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
