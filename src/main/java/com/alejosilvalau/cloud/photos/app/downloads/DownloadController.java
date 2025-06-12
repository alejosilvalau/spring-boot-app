package com.alejosilvalau.cloud.photos.app.downloads;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

import com.alejosilvalau.cloud.photos.app.Photos.Photo;
import com.alejosilvalau.cloud.photos.app.Photos.PhotosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@RestController
public class DownloadController {
  @Autowired
  private PhotosService photosService;
  
  @GetMapping("/downloads/{id}")
  public ResponseEntity<byte[]> download(@PathVariable String id){
    Photo photo = photosService.getOne(id);
    if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      
    byte[] data = photo.getData();
    
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.valueOf(photo.getContentType()));
    ContentDisposition build = ContentDisposition.builder("attachment").filename(photo.getFileName()).build();
    headers.setContentDisposition(build);

    return new ResponseEntity<>(data, headers, HttpStatus.OK);
  }
}
