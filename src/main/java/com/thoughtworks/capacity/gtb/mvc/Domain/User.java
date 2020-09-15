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
public class User {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    private String name;

    private Integer age;

    private String avatar;

    private String description;
}
