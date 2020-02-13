/*
package ua.jackson.awsPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.s3.S3Client;

import java.io.File;
import java.nio.file.FileStore;
import java.nio.file.attribute.FileStoreAttributeView;

@RestController
public class S3Test {

    @Autowired
    private S3Client s3Client;

    @GetMapping("/as")
    public String hello(@RequestParam String name){
        return name;
    }

    @GetMapping("/add/")
    public File load(@RequestParam File multipartFile){
        FileStoreAttributeView fileStore;

        System.out.println("ADDED");
        return  multipartFile;
    }

 */
/*   @GetMapping("/{bucketName}/{multipartFile}")
    public void loadToBuckert(@PathVariable String bucketName,
                              @PathVariable MultipartFile multipartFile) throws IOException {

    *//*
*/
/*    PutObjectRequest putObjectRequest = PutObjectRequest
                .builder()
                .bucket(bucketName)
                .key("test2")
                .build();

        PutObjectResponse putObjectResponse = s3Client.putObject(putObjectRequest, Paths.get(String.valueOf(multipartFile))).toBuilder().build();

        System.out.println(putObjectResponse.versionId());
        System.out.println("");*//*
*/
/*

        s3Client.getObject(GetObjectRequest.builder().bucket(bucketName).key("key1").build(),
                ResponseTransformer.toFile(Paths.get("multiPartKey")));
    }*//*

}

*/
