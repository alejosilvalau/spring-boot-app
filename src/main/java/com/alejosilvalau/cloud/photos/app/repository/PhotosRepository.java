package com.alejosilvalau.cloud.photos.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.alejosilvalau.cloud.photos.app.model.Photo;

public interface PhotosRepository extends CrudRepository<Photo, Integer> {}
