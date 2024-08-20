package com.base_java.baselts.entity.media;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class MediaFile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String fileKey;
    String name;
    String alt;
    String title;
    String extension;
    String mimeType;
    String mediaType;
    int size;
    int pixelSize;
    String metadata;
    int width;
    int height;
    boolean isTransient;
    boolean deleted;
    boolean hidden;
    int version;
    String owner;
    String path;

    @Column(insertable = false, updatable = false)
    String folderId;

    @OneToMany(mappedBy = "mediaFile")
    Set<Download> downloads;

    @ManyToOne
    @JoinColumn(name = "folderId")
    MediaFolder mediaFolder;

    @ManyToOne
    @JoinColumn(name = "mediaStorageId")
    MediaStorage mediaStorage;
}
