package com.alejosilvalau.cloud.photos.app.downloads;

import org.springframework.web.bind.annotation.*;

import com.alejosilvalau.cloud.photos.app.Photos.PhotosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@RestController
public class DownloadController {
  @Autowired
  private PhotosService photosService;
  
  @GetMapping("/downloads/{id}")
  public ResponseEntity<byte[]> download(@PathVariable String id){
    byte[] data = new byte[0];
    HttpHeaders headers = new HttpHeaders();

    return new ResponseEntity<>(data, headers, HttpStatus.OK);
  }
}
