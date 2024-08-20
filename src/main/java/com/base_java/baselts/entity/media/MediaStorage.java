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
public class MediaStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Lob
    byte[] data;

    @OneToMany(mappedBy = "mediaStorage")
    Set<MediaFile> mediaFiles;
}
