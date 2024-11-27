package iiitb.mini.service;

import iiitb.mini.dto.UploadImageRequest;
import iiitb.mini.entity.Employees;
import iiitb.mini.helper.JWTHelper;
import iiitb.mini.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
@RequiredArgsConstructor
public class UpdateImage {
    private final JWTHelper jwtHelper;
    private static final String UPLOAD_DIR = "uploads/images/";

    public String saveImage(MultipartFile file, String token) throws IOException
    {
        Long id = Long.valueOf(jwtHelper.extractUsername(token));
        // Validate the directory
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Get the file and the ID
        //MultipartFile file = request.file();

        // Construct the file path
        String fileName = String.valueOf(id) + ".png";
        Path filePath = Path.of(UPLOAD_DIR, fileName);

        // Save the file
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Return the file path or confirmation
        return "File uploaded successfully: " + filePath.toString();
    }
}
