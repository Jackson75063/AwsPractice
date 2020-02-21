package ua.jackson.awsPractice.awsConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sqs.SqsClient;
import ua.jackson.awsPractice.service.SqsService;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class GlobalAwsConfig {

    @Value("${sqsQueueUrl}")
    private String queueUrl;

    @Value("${AWS_ACCESS_KEY_ID}")
    String accessKeyId;

    @Value("${AWS_SECRET_ACCESS_KEY}")
    String secretAccessKey;

    @Bean
    DynamoDbClient dynamoDbClient() {

        return DynamoDbClient.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKeyId
                        , secretAccessKey)))
                .build();
    }

    @Bean
    public AwsCredentialsProvider awsCredentialsProvider() {
        return AwsCredentialsProviderChain.builder()
                .addCredentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .build();
    }

    @Bean
    public SqsClient sqsClient(AwsCredentialsProvider credentialsProvider) throws URISyntaxException {
        final SqsClient s3Client = SqsClient.builder()
                .credentialsProvider(awsCredentialsProvider())
                .endpointOverride(new URI("http://localhost:4576")).region(Region.US_WEST_2)
                .build();
        return s3Client;
    }

    @Bean
    public S3Client s3Client(final AwsCredentialsProvider awsCredentialsProvider) throws URISyntaxException {
        final S3Client s3Client = S3Client.builder()
                .credentialsProvider(awsCredentialsProvider)
                .endpointOverride(new URI("http://localhost:4572")).region(Region.US_WEST_2)
                .build();
        return s3Client;
    }


}
