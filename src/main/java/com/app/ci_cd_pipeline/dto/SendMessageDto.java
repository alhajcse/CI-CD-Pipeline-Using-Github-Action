package com.app.ci_cd_pipeline.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class SendMessageDto {

    private String message;
    private Set<ToNumberDto> toNumberDtos;



}
