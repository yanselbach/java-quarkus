package org.example.app.task.domain;

import org.example.app.general.domain.ApplicationPersistenceEntity;
import org.example.app.task.common.TaskList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * {@link TaskList} implementation as {@link ApplicationPersistenceEntity}.
 */
@Entity
@Table(name = "TASK_LIST")
public class TaskListEntity extends ApplicationPersistenceEntity implements TaskList {

  @Column
  private String title;

  @OneToMany(mappedBy = "taskListEntity")
  private List<TaskItemEntity> taskItemEntitys;

  @Override
  public String getTitle() {

    return this.title;
  }

  @Override
  public void setTitle(String title) {

    this.title = title;
  }

  public List<TaskItemEntity> getTaskItemEntitys() {
    return taskItemEntitys;
  }

  public void setTaskItemEntitys(List<TaskItemEntity> taskItems) {
    this.taskItemEntitys = taskItems;
  }
}
