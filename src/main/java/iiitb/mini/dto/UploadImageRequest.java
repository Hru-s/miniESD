package iiitb.mini.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record UploadImageRequest(

        @JsonProperty("file")
        MultipartFile file
){}


