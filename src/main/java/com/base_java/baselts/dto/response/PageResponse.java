package com.base_java.baselts.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageResponse<T> {
    // tổng số trang
    int totalPages;
    // size
    int pageSize;
    // tổng số element
    long totalElements;

    @Builder.Default
    private List<T> data= Collections.emptyList();
}
