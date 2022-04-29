package br.com.rodpk.gamelist.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.rodpk.gamelist.model.File;
import br.com.rodpk.gamelist.repository.FileRepository;

@Service
public class FileService {
    
    @Autowired
    private FileRepository repository;

    public void save(MultipartFile multipartFile) throws IOException {
        File file = new File();
        file.setName(StringUtils.cleanPath(multipartFile.getOriginalFilename()));
        file.setContentType(multipartFile.getContentType());
        file.setData(multipartFile.getBytes());
        file.setSize(file.getSize());

        repository.save(file);
    }

    public Optional<File> getFile(String id) {
        return repository.findById(id);
    }

    public List<File> findAllFiles() {
        return repository.findAll();
    }
}
