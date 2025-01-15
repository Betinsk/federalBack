package com.example.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;



@Service
public class AWSService {
	
	@Value("${aws.bucket.name}")
	private String bucketName;
	
	@Autowired
	private AmazonS3 s3Client;

	
	public String uploadImg(MultipartFile multipartFile) {
		String filename = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
		
		try {
			File file = this.convertMultipartToFile(multipartFile);
			s3Client.putObject(bucketName, filename, file);
			file.delete();
			return s3Client.getUrl(bucketName, filename).toString();
		} catch (Exception e) {
			System.out.println("Erro ao subir arquivo");
			return null;
		}
 		
	}

	
	private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {
		File convFile = new File(multipartFile.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(multipartFile.getBytes());
		fos.close();
		return convFile;
		
	}
	
}
