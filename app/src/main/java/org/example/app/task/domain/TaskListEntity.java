package org.example.app.task.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.example.app.general.domain.ApplicationPersistenceEntity;
import org.example.app.task.common.TaskList;

/**
 * {@link TaskList} implementation as {@link ApplicationPersistenceEntity}.
 */
@Entity
@Table(name = "TASK_LIST")
public class TaskListEntity extends ApplicationPersistenceEntity implements TaskList {

  private String title;

  @Override
  public String getTitle() {

    return this.title;
  }

  @Override
  public void setTitle(String title) {

    this.title = title;
  }

}
