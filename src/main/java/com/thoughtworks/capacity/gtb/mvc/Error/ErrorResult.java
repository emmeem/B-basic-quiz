package com.thoughtworks.capacity.gtb.mvc.Error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {
    private String timeStamp;
    private String status;
    private String error;
    private String message;
}
