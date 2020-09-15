package com.thoughtworks.capacity.gtb.mvc.Error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {
    private String timeStamp;
    private Integer status;
    private String error;
    private String message;
}
