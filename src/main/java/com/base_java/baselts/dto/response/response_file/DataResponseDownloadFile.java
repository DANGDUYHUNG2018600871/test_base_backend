package com.base_java.baselts.dto.response.response_file;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataResponseDownloadFile {
    UUID id;
    UUID fileKey;
    String name;
    String path;
    String extension;
    String mimeType;
    String mediaType;
}
