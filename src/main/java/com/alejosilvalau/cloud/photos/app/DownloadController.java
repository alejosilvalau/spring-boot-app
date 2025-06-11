package com.alejosilvalau.cloud.photos.app;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@RestController
public class DownloadController {
  @Autowired
  private PhotosService photosService;
  
  @GetMapping("/download/{id}")
  public ResponseEntity<byte[]> download(@PathVariable String id){
    byte[] data;
    HttpHeaders headers = new HttpHeaders();

    return new ResponseEntity<>(data, headers, HttpStatus.OK);
  }
}
