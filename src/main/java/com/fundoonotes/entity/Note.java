package com.fundoonotes.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    // 👇 IMPORTANT (no relationship mapping)
    private Long userId;

    // Flags
    private boolean isPinned;
    private boolean isArchived;
    private boolean isTrashed;
}