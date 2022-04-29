package br.com.rodpk.gamelist.model.dto;

import br.com.rodpk.gamelist.model.File;
import lombok.Data;

@Data
public class FileResponse {
    private String id;
    private String name;
    private long size;
    private String url;
    private String contentType;

    public FileResponse(File file) {
        this.id = file.getId();
        this.name = file.getName();
        this.size = file.getSize();
        this.contentType = file.getContentType();
    }

}
