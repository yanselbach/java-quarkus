package org.example.app.task.dataaccess;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.example.app.general.dataaccess.ApplicationPersistenceEntity;
import org.example.app.task.common.TaskList;

/**
 * {@link TaskList} implementation as {@link ApplicationPersistenceEntity}.
 */
@Entity
@Table(name = "TASK_LIST")
public class TaskListEntity extends ApplicationPersistenceEntity implements TaskList {

  @Column
  private String title;

  @OneToMany(mappedBy = "taskList", fetch = FetchType.LAZY)
  private List<TaskItemEntity> items;

  @Override
  public String getTitle() {

    return this.title;
  }

  @Override
  public void setTitle(String title) {

    this.title = title;
  }

  /**
   * @return the {@link List} of {@link TaskItemEntity task-items} in this task-list.
   */
  public List<TaskItemEntity> getItems() {

    return this.items;
  }

  /**
   * @param taskItems the new value of {@link #getItems()}.
   */
  public void setItems(List<TaskItemEntity> taskItems) {

    this.items = taskItems;
  }

  @Override
  public String toString() {

    String result = this.title;
    Long id = getId();
    if (id == null) {
      result = result + '[' + id + ']';
    }
    return result;
  }

}