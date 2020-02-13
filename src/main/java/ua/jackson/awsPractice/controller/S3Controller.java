/*
package ua.jackson.awsPractice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController("/zs")
public class S3Controller {

    Logger logger = LoggerFactory.getLogger(S3Controller.class);

    private int i = 0;

    String keyName = "key1";
    String bucket = "bucker1";
    File f = new File("file.txt");

    String bucketName = "bucker1";

    @Autowired
    private S3Client s3Client;


    @GetMapping
    public String get(@RequestParam(required = false, defaultValue = "User") String name) {
        return "Hello " + name + " #" + i++;
    }

    @GetMapping("/upload")
    public String upload() throws IOException {

        if(!f.exists())
            f.createNewFile();

        PutObjectResponse putObjectResponse = s3Client.putObject(PutObjectRequest.builder()
                .bucket(bucket)
                .key(keyName).build(),
                Paths.get(String.valueOf(f)));

        GetObjectRequest getObjectRequest = GetObjectRequest.builder().bucket(bucket).key(keyName).build();


        System.out.println("key : " + getObjectRequest.key());

        ResponseInputStream<GetObjectResponse> object = s3Client.getObject(getObjectRequest);
        object.response().metadata().entrySet().forEach(System.out::println);

        return "loaded";
    }


    @GetMapping("/upload2")
    public void upload(byte[] attachment) throws IOException {

        byte[] fileContent = Files.readAllBytes(f.toPath());

        upload(keyName, fileContent);
        System.out.println(" Loaded... ");
    }


    @GetMapping("/createBucket/{name}")
    public void createBucket2(@PathVariable String name) {
        CreateBucketRequest createBucketRequest = CreateBucketRequest.builder().bucket(name.toLowerCase()).build();
        s3Client.createBucket(createBucketRequest);
    }

    private String upload(String keyName, byte[] attachment) {
        logger.info("Uploading a PDF to S3 - {}", keyName);
        String bucket = "bucker1";
        PutObjectResponse putObjectResult = s3Client.putObject(
                PutObjectRequest.builder()
                        .bucket(bucket)
                        .key(keyName)
                        .contentType(MediaType.ALL.toString())
                        .contentLength((long) attachment.length)
                        .build(),

                RequestBody.fromByteBuffer(ByteBuffer.wrap(attachment)));

        final URL reportUrl = s3Client.utilities().getUrl(GetUrlRequest.builder().bucket(bucket).key(keyName).build());
        logger.info("putObjectResult = " + putObjectResult);
        logger.info("reportUrl = " + reportUrl);
        return reportUrl.toString();
    }



}
*/
