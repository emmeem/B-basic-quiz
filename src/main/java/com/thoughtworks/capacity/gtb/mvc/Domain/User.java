package com.thoughtworks.capacity.gtb.mvc.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Integer id;

    private String name;

    private String password;

    private String email;
}
