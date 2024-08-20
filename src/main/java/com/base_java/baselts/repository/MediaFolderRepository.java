package com.base_java.baselts.repository;

import com.base_java.baselts.entity.media.MediaFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MediaFolderRepository extends JpaRepository<MediaFolder,String> {
    Optional<MediaFolder> findById(String id);
    List<MediaFolder> findAllByParentId(String parentId);

    List<MediaFolder> findAllByParentIdAndDeleted(String parentFolderId, boolean b);
}
