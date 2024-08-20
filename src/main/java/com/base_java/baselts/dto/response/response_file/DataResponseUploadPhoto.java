package com.base_java.baselts.dto.response.response_file;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataResponseUploadPhoto {
    UUID id;
    UUID fileKey;
    String name;
}
