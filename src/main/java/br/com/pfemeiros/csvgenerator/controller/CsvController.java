package br.com.pfemeiros.csvgenerator.controller;

import br.com.pfemeiros.csvgenerator.service.CsvService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("files")
public class CsvController {

    private final CsvService csvService;

    public CsvController(CsvService csvService) {
        this.csvService = csvService;
    }

    @ApiOperation("Dowload CSV File")
    @GetMapping
    public ResponseEntity<byte[]> download() {
        return null;
    }

    @ApiOperation("Upload CSV File")
    @PostMapping
    public void upload() {
        csvService.upload();
    }

}
