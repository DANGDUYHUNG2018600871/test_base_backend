package com.base_java.baselts.repository;

import com.base_java.baselts.entity.media.Download;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadRepository extends JpaRepository<Download,String> {
}
