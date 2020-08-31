package com.profile.Springbootbackend.service;

import com.profile.Springbootbackend.model.Assets;

public interface AmazonS3Service
{
	/*public int uploadFileToS3Bucket(MultipartFile multipartFile, String email);

    void deleteFileFromS3Bucket(String fileName);*/
    
   public boolean readFile();
   public int updateCSVFile(Assets asset);
}