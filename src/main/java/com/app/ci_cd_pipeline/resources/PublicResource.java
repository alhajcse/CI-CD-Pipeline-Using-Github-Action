package com.app.ci_cd_pipeline.resources;

import com.app.ci_cd_pipeline.dto.MessageTemplateDto;
import com.app.ci_cd_pipeline.dto.SendMessageDto;
import com.app.ci_cd_pipeline.service.SendMessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.app.ci_cd_pipeline.utils.ResponseBuilder.*;
import static org.springframework.http.ResponseEntity.ok;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/public")
@Tag(name = "Public API")
public class PublicResource {

    private final SendMessageService service;


    @PostMapping("/message")
    @Operation(summary = "Send message", description = "Send message")
    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
    public ResponseEntity<JSONObject> sendMessage(@RequestBody SendMessageDto dto) {

        service.sendMessage(dto);
        return ok(success("","Send Message Successfully").getJson());
    }


    @PostMapping("/create-template")
    @Operation(summary = "Create message template", description = "Create message template")
    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
    public String createMessageTemplate(@RequestBody MessageTemplateDto request) {
        return service.createMessageTemplate(request);
    }


}
