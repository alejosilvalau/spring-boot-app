package com.alejosilvalau.cloud.photos.app;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

  public Photo get(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

  public Photo remove(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
  }

  public void save(String id, Photo photo) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }
}
