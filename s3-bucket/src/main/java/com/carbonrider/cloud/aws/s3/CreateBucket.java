package com.carbonrider.cloud.aws.s3;


import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class CreateBucket {

    public static final String AWS_ACCESS_KEY = "MDXHZT4421EQTDJWZ09Y";

    public static final String AWS_SECRET_KEY = "uij8TjcGgpIw9P82EHBp1zh7eEz4yCdeppLH7qIW";

    public static void main(String[] args) {
        // S3 endpoint parameters.
        final String s3Endpoint = "https://s3.ap-southeast-2.wasabisys.com";
        final String region = "ap-southeast-2";

        // Use the following code if you would like to add your access and secret keys in the code.
         AWSCredentialsProvider credentials =
                 new AWSStaticCredentialsProvider(
                         new BasicAWSCredentials(AWS_ACCESS_KEY,AWS_SECRET_KEY));

        // Use the following code to fetch the aws profile credentials.
//        AWSCredentialsProvider credentials = new
//
//                ProfileCredentialsProvider("wasabi");

        // connect to Wasabi s3
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new

                        AwsClientBuilder.EndpointConfiguration(s3Endpoint, region))
                .withCredentials(credentials)
                .build();
//s3.deleteBucket("java-bucket-rv");
//        s3.createBucket("java-bucket-rv");
        s3.doesBucketExistV2("java-bucket-rv");
        final String bucketName = "java-bucket-rv";
        final String keyName = "1.TKCT_PYC_04.docx";
        final String filePath = "C:\\Users\\PC05\\Downloads\\1.TKCT_PYC_04.docx";

        // Upload object to bucket
        s3.putObject(bucketName,keyName,new File(filePath));
        System.out.println("success create bucket");
    }


}
