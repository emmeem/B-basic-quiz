package com.thoughtworks.capacity.gtb.mvc.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @Length(min=1,max=16)
    private String name;

    @Min(17)
    private long age;

    @Length(min=8,max=512)
    private String avatar;

    @Length(min=0,max=1024)
    private String description;
}
