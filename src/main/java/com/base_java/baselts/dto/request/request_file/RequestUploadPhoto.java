package com.base_java.baselts.dto.request.request_file;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestUploadPhoto {
    String path;
    String name;

}
