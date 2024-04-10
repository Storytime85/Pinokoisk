//package com.storytime.pinokoiskmainapp.configuration;
//
//import lombok.Setter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.util.List;
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.util.StringUtils;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.Bucket;
//import com.amazonaws.services.s3.model.CannedAccessControlList;
//import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
//import com.amazonaws.services.s3.model.GetObjectRequest;
//import com.amazonaws.services.s3.model.ObjectListing;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.S3ObjectSummary;
//import com.amazonaws.ClientConfiguration;
//import com.amazonaws.Protocol;
//@Configuration
//@ConfigurationProperties(prefix = "ceph.config")
//@Setter
//public class CephConfig {
//    private String host;
//    private String accessKey;
//    private String secretKey;
//
//    @Bean
//    public void createS3Connection() {
//
//    }
//
//}
