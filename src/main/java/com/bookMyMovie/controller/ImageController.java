package com.bookMyMovie.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bookMyMovie.model.Image;
import com.bookMyMovie.services.ImageService;

@RestController
public class ImageController {
	
	@Autowired
	private ImageService imageService;

	@GetMapping("/images/{imageId}")
	public Image getImage(@PathParam("imageId") String imageId) {
		return new Image();
	}
	
	@GetMapping("/imagessss")
	public String addImage() throws FileNotFoundException {
		return imageService.storeImage();
	}
	
	@PostMapping("/images/{imageId}")
	public String storeImage(@PathParam("imageId") String imageId) {
		return "Posted...";
	}
}
