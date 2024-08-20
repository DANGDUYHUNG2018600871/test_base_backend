package com.base_java.baselts.service.impl;

import com.base_java.baselts.dto.request.request_file.RequestDownloadFile;
import com.base_java.baselts.dto.request.request_file.RequestUploadPhoto;
import com.base_java.baselts.dto.response.response_file.DataResponseDownloadFile;
import com.base_java.baselts.dto.response.response_file.DataResponseUploadPhoto;
import com.base_java.baselts.entity.media.MediaFile;
import com.base_java.baselts.entity.media.MediaFolder;
import com.base_java.baselts.exception.AppException;
import com.base_java.baselts.exception.ErrorCode;
import com.base_java.baselts.mapper.MediaFileMapper;
import com.base_java.baselts.repository.MediaFileRepository;
import com.base_java.baselts.repository.MediaFolderRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MediaService {
    MediaFileRepository mediaFileRepository;
    HttpServletRequest httpServletRequest;
    MediaFileMapper mediaFileMapper;
    MediaFolderRepository mediaFolderRepository;

    public DataResponseDownloadFile handleDownloadFile(String id){
        String ownerId=getOwnerId();
        MediaFile file= mediaFileRepository.findById(id).orElseThrow(()->new AppException(ErrorCode.MEDIA_FILE_NOT_EXISTED));

        return mediaFileMapper.toMediaResponse(file);
    }

    //lay ID của người dùng hiện tại
    private String getOwnerId(){
        return Optional.ofNullable(httpServletRequest)
                .map(req->req.getUserPrincipal().getName())
                .orElse(null);
    }

    private List<MediaFolder> getMediaFolders(String keywords, String parentFolderId, String owner) {
        return mediaFolderRepository.findAllByParentIdAndDeleted(parentFolderId, false).stream()
                .filter(x -> (keywords == null || x.getName().contains(keywords)) &&
                        (owner == null || owner.equals(x.getOwner()) || x.getOwner() == null))
                .collect(Collectors.toList());
    }
    public DataResponseUploadPhoto handleUploadPhoto(RequestUploadPhoto request){
        String ownerId=getOwnerId();

        return null;
    }

    private MediaFile saveFileAsync(String folderId, String fileName, String path, InputStream stream, boolean isTransient, String owner, boolean isReplaceIfExists){
        MediaFile file=null;
        // Kiểm tra xem file đã tồn tại chưa nếu được yêu cầu thay thế
        if(isReplaceIfExists){
            file=mediaFileRepository.findByNameAndFolderId(fileName,folderId).orElseThrow(()->new AppException(ErrorCode.MEDIA_FILE_NOT_EXISTED));
        }
        // Lấy thông tin thư mục media
        MediaFolder folder=mediaFolderRepository.findById(folderId).orElse(null);

        return null;
    }


    //thêm ảnh vào file trong project
//    public UserResponse uploadUserPhoto(Long userId, MultipartFile file) throws IOException {
//        User user = userResponsitory.findById(userId)
//                .orElseThrow(() -> new AppException(ErrException.USER_NO_EXISTED));
//
//        String filename = storeFile(file);
//        user.setPhoto(filename);
//        userResponsitory.save(user);
//
//        return userMapper.toUserReponse(user);
//    }

//    private String storeFile(MultipartFile file) throws IOException {
//        //Kiểm tra định dạng tệp tin.
//        if (!isMediaFile(file) || file.getOriginalFilename() == null) {
//            throw new IOException("Invalid image format");
//        }
//        //Làm sạch đường dẫn tệp tin
//        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
//        //Tạo tên tệp tin duy nhất bằng cách thêm UUID vào trước tên gốc
//        String uniqueFilename = UUID.randomUUID().toString() + "_" + filename;
//        //Đường dẫn tới thư mục lưu trữ.
//        java.nio.file.Path uploadDir = Paths.get("uploads");
//        if (!Files.exists(uploadDir)) {
//            Files.createDirectories(uploadDir);
//        }
//        java.nio.file.Path destination = Paths.get(uploadDir.toString(), uniqueFilename);
//        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
//        return uniqueFilename;
//    }

    //Kiểm tra loại nội dung của tệp tin, đảm bảo nó bắt đầu các dịnh dang
    private boolean isMediaFile(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null && (
                contentType.startsWith("image/") ||
                        contentType.equals("application/pdf") ||
                        contentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document") || // .docx
                        contentType.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation") || // .pptx, .potx
                        contentType.equals("application/x-msdownload") || // .exe, .msi
                        contentType.equals("video/mp4") || // .mp4
                        contentType.equals("audio/mpeg") || // .mp3
                        contentType.equals("text/html") // .html
        );
    }
    protected InputStream processFile(MediaFile file, UUID folderId, String fileName, InputStream inStream, boolean isTransient) {
//        if (file == null) {
//            file = new MediaFile();
//            file.setFileKey(UUID.randomUUID());
//            file.setTransient(isTransient);
//
//        }
//
//        file.setName(fileName);
//        file.setExtension(fileName.substring(fileName.lastIndexOf(".") + 1));
//        file.setMimeType(MimeTypes.mapNameToMimeType(fileName));
//
//        if (file.getMediaType() == null) {
//            file.setMediaType(mediaTypeResolver.resolve(file.getExtension(), file.getMimeType()));
//        }
//
//        if (inStream != null && file.getMediaType().equals("Image") && processImage(file, inStream)) {
//            file.setSize((int) inStream.available());
//        }

        return inStream;


    }

    protected boolean processImage(MediaFile file, InputStream inStream, OutputStream[] outStream, Dimension[] size) {
//        outStream[0] = null;
//        size[0] = new Dimension();
//
//        Dimension originalSize = ImageHeader.getDimensions(inStream, file.getMimeType());
//
//        if (!_imageProcessor.isSupportedImage(file.getExtension())) {
//            outStream[0] = inStream;
//            size[0] = originalSize; // e.g.: image/svg+xml
//            return true;
//        }
//
//        int maxSize = 1024;
//        int defaultImageQuality = 100;
//
//        ProcessImageQuery query = new ProcessImageQuery(inStream);
//        query.setQuality(defaultImageQuality);
//        query.setFormat(file.getExtension());
//        query.setDisposeSource(true);
//        query.setIsValidationMode(true);
//        query.setMaxSize(maxSize);
//
//        try (ProcessedResult result = _imageProcessor.processImage(query, false)) {
//            size[0] = new Dimension(result.getWidth(), result.getHeight());
//            outStream[0] = result.getOutputStream();
//            return true;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
        return false;
    }

}
