package br.com.pfemeiros.csvgenerator.controller;

import br.com.pfemeiros.csvgenerator.service.CsvService;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("files")
public class CsvController {

    private final CsvService csvService;

    public CsvController(CsvService csvService) {
        this.csvService = csvService;
    }

    @ApiOperation("Dowload CSV File")
    @GetMapping
    public ResponseEntity<Resource> download() {
        String filename = "students.csv";
        InputStreamResource file = new InputStreamResource(csvService.download());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }

    @ApiOperation("Upload CSV File")
    @PostMapping
    public void upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            csvService.upload(file);
        }
    }

}
