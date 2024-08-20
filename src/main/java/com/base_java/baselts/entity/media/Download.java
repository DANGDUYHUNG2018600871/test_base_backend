package com.base_java.baselts.entity.media;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Download {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    UUID downloadGuid;
    boolean useDownloadUrl;
    String downloadUrl;
    boolean isTransient;
    UUID entityId;
    String entityName;
    String fileVersion;
    String changelog;

    @Column(insertable = false, updatable = false)
    String mediaFileId;

    @ManyToOne
    @JoinColumn(name = "mediaFileId")
    MediaFile mediaFile;
}
