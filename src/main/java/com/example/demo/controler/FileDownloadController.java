package com.example.demo.controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class to download a file.
 */
@RestController
public class FileDownloadController {
    /**
     * Download a file.
     * @return The expected file.
     * @throws IOException When failed.
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadFile() throws IOException  {
        String filename = "/var/tmp/db.txt";
        File file = new File(filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/txt"))
                .body(resource);
    }
}
