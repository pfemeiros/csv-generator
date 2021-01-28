package br.com.pfemeiros.csvgenerator.service;

import org.springframework.web.multipart.MultipartFile;

public interface CsvService {

    void upload(MultipartFile file);
    byte[] download();

}
