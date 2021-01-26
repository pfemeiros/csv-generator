package br.com.pfemeiros.csvgenerator.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/files")
public class CsvController {

    @ApiOperation("Dowload CSV File")
    @GetMapping
    public ResponseEntity<byte[]> download() {
        return null;
    }

    @ApiOperation("Upload CSV File")
    @GetMapping
    public ResponseEntity<byte[]> upload() {
        return null;
    }

}
