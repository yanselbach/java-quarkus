package org.example.app.task.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.example.app.general.domain.ApplicationPersistenceEntity;
import org.example.app.task.common.TaskItem;
import org.example.app.task.common.TaskState;

/**
 * {@link TaskItem} implementation as {@link ApplicationPersistenceEntity}.
 */
@Entity
@Table(name = "TASK_ITEM")
public class TaskItemEntity extends ApplicationPersistenceEntity implements TaskItem {

  private String title;

  private TaskState state;

  @Override
  public String getTitle() {

    return this.title;
  }

  @Override
  public void setTitle(String title) {

    this.title = title;
  }

  @Override
  public TaskState getState() {

    return this.state;
  }

  @Override
  public void setState(TaskState state) {

    this.state = state;
  }

}
