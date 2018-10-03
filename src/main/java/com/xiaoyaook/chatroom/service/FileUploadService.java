package com.xiaoyaook.chatroom.service;

import com.xiaoyaook.chatroom.response.ResponseJson;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * created by xiaoyaook on 18-10-3
 */
public interface FileUploadService {
    ResponseJson upload(MultipartFile file, HttpServletRequest request);
}
