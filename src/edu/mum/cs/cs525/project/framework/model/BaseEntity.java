package edu.mum.cs.cs525.project.framework.model;

import java.time.LocalDate;

public abstract class BaseEntity {
    private Long id;

    private String createdBy;
    private String changedBy;
    private LocalDate createdDate;
    private LocalDate changedDate;

    public BaseEntity(){

    }

    public BaseEntity(Long id, String createdBy, String changedBy, LocalDate createdDate, LocalDate changedDate) {
        this.id = id;
        this.createdBy = createdBy;
        this.changedBy = changedBy;
        this.createdDate = createdDate;
        this.changedDate = changedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(LocalDate changedDate) {
        this.changedDate = changedDate;
    }
}
