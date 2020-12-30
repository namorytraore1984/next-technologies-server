package com.nexttechnologies.nexttechnologiesserver.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EntityBase {
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
