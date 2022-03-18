package com.carbonrider.cloud.aws.s3;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;

public class CreateBucket {

    public static final String AWS_ACCESS_KEY = System.getenv("AWS_ACCESS_KEY");

    public static final String AWS_SECRET_KEY = System.getenv("AWS_SECRET_KEY");

    public static void main(String[] args) {
        AwsCredentials credentials = AwsBasicCredentials.create(AWS_ACCESS_KEY, AWS_SECRET_KEY);

        S3Client s3Client = S3Client.builder().region(Region.of("us-east-1")).credentialsProvider(
                StaticCredentialsProvider.create(credentials)
        ).build();

        CreateBucketRequest bucketRequest = CreateBucketRequest.builder().bucket("carbonrider-new-aws").build();

        s3Client.createBucket(bucketRequest);

        System.out.println("Bucket created !!!");
    }
}
