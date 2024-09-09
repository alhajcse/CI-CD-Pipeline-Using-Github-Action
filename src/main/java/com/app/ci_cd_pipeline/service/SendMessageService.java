package com.app.ci_cd_pipeline.service;

import com.app.ci_cd_pipeline.dto.MessageTemplateDto;
import com.app.ci_cd_pipeline.dto.SendMessageDto;

public interface SendMessageService {
     String sendMessage(SendMessageDto dto);

     String createMessageTemplate(MessageTemplateDto dto);



     }
