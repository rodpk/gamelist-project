package br.com.rodpk.gamelist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "file")
public class File {

    @Id @Column(name = "file_id")     
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "content_type")
    private String contentType;
    
    @Column(name = "size")
    private long size;

    @Lob
    @Column(name = "data")
    private byte[] data;

}
