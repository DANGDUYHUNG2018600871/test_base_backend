package com.base_java.baselts.repository;

import com.base_java.baselts.entity.media.MediaFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MediaFileRepository extends JpaRepository<MediaFile,String> {
    boolean existsByNameAndFolderId(String folderId,String name);
    Optional<MediaFile> findById(String id);

    List<MediaFile> findAllById(String[] id);

    Optional<MediaFile> findByNameAndFolderId(String fileName,String folderId);

//    List<MediaFile> findByKeywordsAndFolderIdAndOwner(String keywords, String folderId, String owner);
}
