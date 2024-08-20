package com.base_java.baselts.mapper;

import com.base_java.baselts.dto.response.response_file.DataResponseDownloadFile;
import com.base_java.baselts.entity.media.MediaFile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MediaFileMapper {
    DataResponseDownloadFile toMediaResponse(MediaFile file);
}
