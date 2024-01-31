package org.example.app.task.dataaccess;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.app.general.dataaccess.ApplicationPersistenceEntity;

@Entity
@Table(name = "TASK_LIST")
public class TaskListEntity
        extends ApplicationPersistenceEntity {

@Column(name = "TITLE")
private String title;

public String getTitle() {
    return this.title;
}

public void setTitle(String title) {
    this.title = title;
}
}
