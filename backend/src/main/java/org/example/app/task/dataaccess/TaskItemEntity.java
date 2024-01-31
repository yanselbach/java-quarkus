package org.example.app.task.dataaccess;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.app.general.dataaccess.ApplicationPersistenceEntity;

import java.time.LocalDateTime;
@Entity
    @Table(name = "TASK_LIST")
    public class TaskItemEntity
            extends ApplicationPersistenceEntity {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "COMPLETED")
    private boolean completed;

    @Column(name = "STARRED")
    private boolean starred;

    @Column(name = "DEADLINE")
    private LocalDateTime deadline;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}



