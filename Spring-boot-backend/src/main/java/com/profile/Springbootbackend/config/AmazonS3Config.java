package com.profile.Springbootbackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

@Configuration
public class AmazonS3Config 
{
    @Value("${aws.access.key.id}")
    private String awsKeyId;

    @Value("${aws.access.key.secret}")
    private String awsKeySecret;

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.s3.audio.bucket}")
    private String awsS3AudioBucket;
    
    @Value("${aws.end-point.url}")
    private String awsDynamoDBurl;

    @Bean(name = "awsKeyId")
    public String getAWSKeyId() {
        return awsKeyId;
    }

    @Bean(name = "awsKeySecret")
    public String getAWSKeySecret() {
        return awsKeySecret;
    }

    @Bean(name = "awsRegion")
    public Region getAWSPollyRegion() {
        return Region.getRegion(Regions.fromName(awsRegion));
    }

    @Bean(name = "awsCredentialsProvider")
    public AWSCredentialsProvider getAWSCredentials() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(this.awsKeyId, this.awsKeySecret);
        return new AWSStaticCredentialsProvider(awsCredentials);
    }

    @Bean(name = "awsS3AudioBucket")
    public String getAWSS3AudioBucket() {
        return awsS3AudioBucket;
    }
    
    @Bean
    public DynamoDBMapper awsDynamoMapper()
    {
    	return new DynamoDBMapper(amazonDynamoDbConfig());
    }
    
    @Bean(value="awsDynamo")
    public AmazonDynamoDB amazonDynamoDbConfig()
    {
    	return AmazonDynamoDBClientBuilder.standard()
    			.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsDynamoDBurl,awsRegion))
    			.withCredentials(getAWSCredentials())
    			.build();
    }
    @Bean(value="dynamoDB")
    public DynamoDB getDynamoDB()
    {
    	return new DynamoDB(amazonDynamoDbConfig());
    }
    
    @Bean(value="dynamoTable")
    public Table getTable()
    {
    	return getDynamoDB().getTable("Assets");
    }
    
    @Bean(value="dynamoTable2")
    public Table getTable2()
    {
    	return getDynamoDB().getTable("AssetsDistibution");
    			
    }
}