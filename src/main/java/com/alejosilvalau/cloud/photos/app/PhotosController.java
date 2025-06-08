package com.alejosilvalau.cloud.photos.app;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotosController {
  private List<Photo> db = List.of(new Photo("1", "hello.jpg"));

  @GetMapping("/")
  public String hello() {
    return "Hello World";
  }

  @GetMapping("/photos")
  public List<Photo> get() {
    return db;
  }

}
