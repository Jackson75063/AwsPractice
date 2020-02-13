/*
package ua.jackson.awsPractice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.exception.SdkServiceException;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.io.FileOutputStream;
import java.io.IOException;

@RestController("/w")
public class Ctrl2 {

    Logger logger = LoggerFactory.getLogger(Ctrl2.class);

    @Autowired
    S3Client s3Client;

    String bucket = "bucker1";

    String key = "key1";


    @GetMapping("/download")
    public void download() throws IOException {

        byte[] object = getObject(key);

        try (FileOutputStream stream = new FileOutputStream("lol2.txt")) {
            stream.write(object);
        }

        System.out.println("Downloaded ");
    }

//download
    private byte[] getObject(String keyName) {
        try {
            logger.info("Retrieving file from S3 for key: {}/{}", bucket, keyName);
            ResponseBytes<GetObjectResponse> s3Object = s3Client.getObject(
                    GetObjectRequest.builder().bucket(bucket).key(keyName).build(),
                    ResponseTransformer.toBytes());
            final byte[] bytes = s3Object.asByteArray();
            return bytes;
        } catch (SdkClientException ase) {
            logger.error("Caught an AmazonServiceException, which " + "means your request made it "
                    + "to Amazon S3, but was rejected with an error response" + " for some reason: " + keyName, ase);
            throw ase;
        } catch (SdkServiceException ace) {
            logger.error("Caught an AmazonClientException, which " + "means the client encountered "
                    + "an internal error while trying to " + "communicate with S3, "
                    + "such as not being able to access the network: " + keyName, ace);
            throw ace;
        }

    }

}
*/
