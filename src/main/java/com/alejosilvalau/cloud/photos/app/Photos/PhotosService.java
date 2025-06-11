package com.alejosilvalau.cloud.photos.app.Photos;

import java.util.Collection;
import java.util.HashMap;
import java.util.*;

import org.springframework.stereotype.*;

@Service
public class PhotosService {
    private Map<String, Photo> db = new HashMap<>() {
    {
      put("1", new Photo("1", "hello.jpg"));
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

  public Photo save(String fileName, byte[] data) {
    Photo photo = new Photo();
    photo.setId(UUID.randomUUID().toString());
    photo.setFileName(fileName);
    photo.setData(data);
    db.put(photo.getId(), photo);
    return photo;
  }
}
