package com.alejosilvalau.cloud.photos.app.Photos;

import java.io.IOException;
// Java core imports
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
// Spring framework imports
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PhotosController {
  @Autowired
  private PhotosService photosService;

  @GetMapping("/")
  public String hello() {
    return "Hello World";
  }

  @GetMapping("/photos")
  public Collection<Photo> findAll() {
    return photosService.findAll();
  }

  @GetMapping("/photos/{id}")
  public Photo get(@PathVariable String id) {
    Photo photo = photosService.getOne(id);
    if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    return photo;
  }

  @DeleteMapping("/photos/{id}")
  public void delete(@PathVariable String id) {
    Photo photo = photosService.remove(id);
    if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
  }
  
  @PostMapping("/photos")
  public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
    return photosService.save(file.getOriginalFilename(), file.getBytes());
  }
}
