package com.thoughtworks.capacity.gtb.mvc.domain;

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
    private long userId;

    private long year;

    @Length(min=1,max=256)
    private String title;

    @Length(min=1, max=4096)
    private String description;
}
