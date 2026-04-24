package com.fundoonotes.service.impl;

import com.fundoonotes.dto.request.CreateNoteRequestDto;
import com.fundoonotes.entity.Note;
import com.fundoonotes.repository.NoteRepository;
import com.fundoonotes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public Note createNote(CreateNoteRequestDto dto, Long userId) {

        Note note = Note.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .userId(userId)
                .isPinned(false)
                .isArchived(false)
                .isTrashed(false)
                .build();

        return noteRepository.save(note);
    }
}