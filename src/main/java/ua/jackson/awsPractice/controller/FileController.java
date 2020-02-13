/*
package ua.jackson.awsPractice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import ua.jackson.awsPractice.model.UploadFileResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

//    @Autowired
//    private final FileStorageService fileStorageService;

    @Autowired
    private S3Client s3Client;

//    @Autowired
//    public FileController(FileStorageService fileStorageService) {
//        this.fileStorageService = fileStorageService;
//    }


    @GetMapping
    public String hello2(){
        return "hello2";
    }

    @GetMapping("/qw")
    public String hell(HttpServletRequest httpServletRequest){

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();

        String ip = request.getRemoteAddr();

        String ipAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");
        String s = "hello" + httpServletRequest.getLocalAddr() + " " + ip;
        System.out.println(s);
        return s;
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
//        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) throws Exception {
        List<UploadFileResponse> collect = new ArrayList<>();
        for (MultipartFile multipartFile : files) {
            UploadFileResponse uploadFileResponse = uploadFile(multipartFile);
            collect.add(uploadFileResponse);
        }
        return collect;
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws Exception {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


    @GetMapping("/createBucket/{name}")
    public void createBucket2(@PathVariable String name) {
        CreateBucketRequest createBucketRequest = CreateBucketRequest.builder()
                .bucket(name.toLowerCase())
                .build();
        s3Client.createBucket(createBucketRequest);
    }

}*/
