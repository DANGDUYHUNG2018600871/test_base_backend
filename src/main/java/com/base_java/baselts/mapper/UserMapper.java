package com.base_java.baselts.mapper;

import com.base_java.baselts.dto.request.request_user.UserCreationRequest;
import com.base_java.baselts.dto.request.request_user.UserUpdateRequest;
import com.base_java.baselts.dto.response.response_user.UserResponse;
import com.base_java.baselts.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);


}
