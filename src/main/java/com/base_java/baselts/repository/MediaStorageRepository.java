package com.base_java.baselts.repository;

import com.base_java.baselts.entity.media.MediaStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaStorageRepository extends JpaRepository<MediaStorage,String> {
}
