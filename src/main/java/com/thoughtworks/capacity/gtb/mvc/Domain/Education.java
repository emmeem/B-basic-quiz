package com.thoughtworks.capacity.gtb.mvc.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Education {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer userId;

    private Integer year;

    @Length(min=1,max=128)
    private String title;

    @Length(min=1, max=2048)
    private String description;
}
