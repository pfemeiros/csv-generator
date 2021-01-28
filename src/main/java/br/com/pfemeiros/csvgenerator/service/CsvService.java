package br.com.pfemeiros.csvgenerator.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

public interface CsvService {

    void upload(MultipartFile file);
    ByteArrayInputStream download();

}
