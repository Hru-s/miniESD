package iiitb.mini.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ModifyRequest(

    @JsonProperty("oldId")
    Long oldId,
    @NotNull(message = "newId required")
    @NotEmpty(message = "newId required")
    @NotBlank(message = "newId required")
    @JsonProperty("newId")
    Long newId,

    @NotNull(message = "first name cannot be blank")
    @NotEmpty(message = "first name cannot be blank")
    @NotBlank(message = "first name cannot be blank")
    @JsonProperty("first_name")
    String firstName,

    @NotNull(message = "last name cannot be blank")
    @NotEmpty(message = "last name cannot be blank")
    @NotBlank(message = "last name cannot be blank")
    @JsonProperty("last_name")
    String lastName,

    @NotNull(message = "email name cannot be blank")
    @NotEmpty(message = "email name cannot be blank")
    @NotBlank(message = "email name cannot be blank")
    @JsonProperty("email")
    String email,

    @NotNull(message = "title name cannot be blank")
    @NotEmpty(message = "title name cannot be blank")
    @NotBlank(message = "title name cannot be blank")
    @JsonProperty("title")
    String title
){}
