package com.profile.Springbootbackend.service;

public interface AmazonS3Service
{
	/*public int uploadFileToS3Bucket(MultipartFile multipartFile, String email);

    void deleteFileFromS3Bucket(String fileName);*/
    
   public boolean readFile();
}