package com.alejosilvalau.cloud.photos.app.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.*;

import org.springframework.stereotype.*;

import com.alejosilvalau.cloud.photos.app.model.Photo;

@Service
public class PhotosService {
    private Map<String, Photo> db = new HashMap<>() {
    {
      put("1", new Photo());
    }
  };

  public Collection<Photo> findAll() {
    return db.values();
  }

  public Photo getOne(String id) {
    return db.get(id);
  }

  public Photo remove(String id) {
    return db.remove(id);
  }

  public Photo save(String fileName, String contentType, byte[] data) {
    Photo photo = new Photo();
    photo.setId(UUID.randomUUID().hashCode());
    photo.setFileName(fileName);
    photo.setData(data);
    photo.setContentType(contentType);
    db.put(photo.getId().toString(), photo);
    return photo;
  }
}
