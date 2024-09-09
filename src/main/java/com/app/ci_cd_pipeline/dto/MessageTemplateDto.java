package com.app.ci_cd_pipeline.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageTemplateDto {
    private String name;
    private String language;
    private String content;
}
