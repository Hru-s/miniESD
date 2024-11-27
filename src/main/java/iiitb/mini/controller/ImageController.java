package iiitb.mini.controller;

import iiitb.mini.dto.UploadImageRequest;
import iiitb.mini.service.UpdateImage;
import jakarta.validation.Valid;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ImageController {
    @Autowired
    UpdateImage updateImage;
    @PostMapping("/upload")
        public String upload(
                @RequestParam("file") MultipartFile file ,@RequestHeader("Authorization") String token) {
        try {
            String s = updateImage.saveImage(file,token);
            return s;
        } catch (Exception e) {
            return "Error uploading file: " + e.getMessage();
        }
        //return "working";
    }
}
