package com.bookMyMovie.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Service
public class ImageService {

	@Autowired
	private GridFsTemplate gridFsTemplate;

	@Autowired
	private GridFsOperations gridFsOperations;

	public String storeImage() throws FileNotFoundException {
		
		DBObject metaData = new BasicDBObject();
		InputStream imageFile = new FileInputStream("E:\\BookMyMovie\\React\\public\\images\\banner\\M0091.jpg");
		// String fileName = StringUtils.cleanPath(((MultipartFile)
		// imageFile).getOriginalFilename());
		metaData.put("type", "image");

		// Store file to MongoDB
		String imageFileId = gridFsOperations.store(imageFile, "logo1.png", "image/png", metaData).get().toString();

		System.out.println("ImageFileId = " + imageFileId);

		return imageFileId;
	}

}
