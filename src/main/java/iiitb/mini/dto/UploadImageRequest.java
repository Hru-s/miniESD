package iiitb.mini.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record UploadImageRequest(

        @NotNull(message = "newId required")
        @NotEmpty(message = "newId required")
        @NotBlank(message = "newId required")
        @JsonProperty("Id")
        Long newId,


        @NotNull(message = "title name cannot be blank")
        @JsonProperty("file")
        MultipartFile photograph
){}


