package com.alejosilvalau.cloud.photos.app.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.*;

import org.springframework.stereotype.*;

import com.alejosilvalau.cloud.photos.app.model.Photo;
import com.alejosilvalau.cloud.photos.app.repository.PhotosRepository;

@Service
public class PhotosService {
  private final PhotosRepository photosRepository;

  public PhotosService(PhotosRepository photosRepository) {
    this.photosRepository = photosRepository;
  }

  public Iterable<Photo> findAll() {
    return photosRepository.findAll();
  }

  public Photo getOne(Integer id) {
    return photosRepository.findById(id).orElse(null);
  }

  public void remove(Integer id) {
    photosRepository.deleteById(id);
  }

  public Photo save(String fileName, String contentType, byte[] data) {
    Photo photo = new Photo();
    photo.setFileName(fileName);
    photo.setData(data);
    photo.setContentType(contentType);
    photosRepository.save(photo);
    return photo;
  }
}
