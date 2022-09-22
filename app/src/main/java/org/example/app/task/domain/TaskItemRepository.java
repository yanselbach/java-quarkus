package org.example.app.task.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for the {@link JpaRepository} giving database access to {@link TaskItemEntity}.
 */
public interface TaskItemRepository extends JpaRepository<TaskItemEntity, Long> {

}
