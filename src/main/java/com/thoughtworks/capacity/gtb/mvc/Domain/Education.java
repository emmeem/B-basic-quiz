package com.thoughtworks.capacity.gtb.mvc.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Education {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer userId;

    private Integer year;

    private String title;

    private String description;
}
