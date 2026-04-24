package com.fundoonotes.dto.request;

import lombok.Data;

@Data
public class CreateNoteRequestDto {
    private String title;
    private String content;
}