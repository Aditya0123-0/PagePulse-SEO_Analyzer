package com.pagepulse.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuditRequest {
    @NotBlank(message = "URL cannot be blank")
    @Pattern(
            regexp = "^(http|https)://.*$",
            message = "URL must start with http:// or https://"
    )
    private String url;

}
