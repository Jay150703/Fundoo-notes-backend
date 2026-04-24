package com.fundoonotes.service;

import com.fundoonotes.dto.request.CreateNoteRequestDto;
import com.fundoonotes.entity.Note;

public interface NoteService {
    Note createNote(CreateNoteRequestDto dto, Long userId);
}