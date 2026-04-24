package com.fundoonotes.controller;

import com.fundoonotes.dto.request.CreateNoteRequestDto;
import com.fundoonotes.entity.Note;
import com.fundoonotes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public Note createNote(@RequestBody CreateNoteRequestDto dto,
                           Authentication authentication) {

        Long userId = Long.parseLong(authentication.getPrincipal().toString());

        return noteService.createNote(dto, userId);
    }
}