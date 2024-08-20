package com.base_java.baselts.entity.media;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class MediaFolder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;
    String slug;
    boolean canDetectTracks;
    String metaData;
    int filesCount;
    String owner;
    boolean deleted;
    boolean isPublic;
    String isProtected;
    String isPrivate;

    String parentId;

    @OneToMany(mappedBy = "mediaFolder")
    Set<MediaFile>mediaFiles;

    @ManyToOne
    @JoinColumn(name = "parentId",insertable = false,updatable = false)
    private MediaFolder parent;
}
