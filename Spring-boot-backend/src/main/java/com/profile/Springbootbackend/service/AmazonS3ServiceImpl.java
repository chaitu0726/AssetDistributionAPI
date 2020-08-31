package com.profile.Springbootbackend.service;


import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.profile.Springbootbackend.model.AssetRecord;
import com.profile.Springbootbackend.model.Assets;
import com.profile.Springbootbackend.util.SessionHandling;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.profile.Springbootbackend.util.ProfileConstants.*;

@Component
public class AmazonS3ServiceImpl implements AmazonS3Service 
{

	
    private String awsS3AudioBucket;
    private AmazonS3 amazonS3;
    //private static final Logger logger = LoggerFactory.getLogger(AmazonS3ServiceImpl.class);

    @Autowired
    public AmazonS3ServiceImpl(Region awsRegion, AWSCredentialsProvider awsCredentialsProvider, String awsS3AudioBucket) 
    {
        this.amazonS3 = AmazonS3ClientBuilder.standard()
                .withCredentials(awsCredentialsProvider)
                .withRegion(awsRegion.getName()).build();
        this.awsS3AudioBucket = awsS3AudioBucket;
    }
    
    @Autowired
    SessionHandling sessionHandling;
 /*   
    @Async
    public int uploadFileToS3Bucket(MultipartFile multipartFile,String email) 
    {
        String fileName = multipartFile.getOriginalFilename();
       
        try {
           
            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(multipartFile.getBytes());
            fos.close();

            PutObjectRequest putObjectRequest = new PutObjectRequest(this.awsS3AudioBucket,email+".png", file);

           this.amazonS3.putObject(putObjectRequest);
            //removing the file created in the server
            file.delete();
        } catch (IOException | AmazonServiceException ex) {
            logger.error("error [" + ex.getMessage() + "] occurred while uploading [" + fileName + "] ");
            return NOT_OK;
        }
		return OK;
        
    }

    @Async
    public void deleteFileFromS3Bucket(String fileName) 
    {
        try {
            amazonS3.deleteObject(new DeleteObjectRequest(awsS3AudioBucket, fileName));
        } catch (AmazonServiceException ex) {
            logger.error("error [" + ex.getMessage() + "] occurred while removing [" + fileName + "] ");
        }
    }
*/
	@Override
	public boolean readFile() {

		S3Object s3object = this.amazonS3.getObject(new GetObjectRequest(this.awsS3AudioBucket,CSV_FILE));
		//BufferedReader reader = new BufferedReader(new InputStreamReader(s3object.getObjectContent()));
		CSVParser fileParser;
		Map<String,AssetRecord> assetRecordMap = new HashMap<String,AssetRecord>();
		try {
			
			fileParser = new CSVParser(new InputStreamReader(s3object.getObjectContent()),CSVFormat.TDF.withCommentMarker(','));
			List<CSVRecord> records = fileParser.getRecords();
			for(CSVRecord record : records)
			{
				 for (int i = 0; i < record.size(); i++) {
			           String temp =  record.get(i);
			        String[] assetRecordString = temp.split(",");
			        
			        AssetRecord assetRecord = new AssetRecord();
			        assetRecord.setAssetKey(assetRecordString[0]);
			        assetRecord.setAssetType(assetRecordString[1]);
			        assetRecord.setAssetInfo(assetRecordString[2]);
			        
			        assetRecordMap.put(assetRecordString[0], assetRecord);
			       
				}
			}
			fileParser.close();
			this.sessionHandling.setAssetRecordsMap(assetRecordMap);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		return true;
	}
	@Override
	public int updateCSVFile(Assets asset) {
		String newLine = asset.getAssetkey()+","+asset.getAssetType()+","+asset.getAssetName();
		S3Object s3object = this.amazonS3.getObject(new GetObjectRequest(this.awsS3AudioBucket,CSV_FILE));
		
		
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader( s3object.getObjectContent()));
			StringBuilder config = new StringBuilder();
			String line;
			while ((line = input.readLine()) != null) 
			{
				config.append(line);
				config.append("\r\n");
			}
			config.append(newLine);
			File file = new File(CSV_FILE);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(String.valueOf(config).getBytes());
			fos.close();
			PutObjectRequest putObjectRequest = new PutObjectRequest(this.awsS3AudioBucket,CSV_FILE, file);

	        this.amazonS3.putObject(putObjectRequest);
	            //removing the file created in the server
	         file.delete();
			
		} catch (IOException  | AmazonServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}