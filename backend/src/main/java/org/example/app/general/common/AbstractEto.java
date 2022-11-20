package org.example.app.general.common;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Abstract base for all Entity Transfer Objects (ETO).
 */
public abstract class AbstractEto implements ApplicationEntity {

  @Schema(required = true, example = "1", description = "The id of the entity")
  private Long id;

  @Schema(required = true, example = "0", description = "The version of the entity - used to detected changes")
  private Integer version;

  @Override
  public Long getId() {

    return this.id;
  }

  @Override
  public void setId(Long id) {

    this.id = id;
  }

  @Override
  public Integer getVersion() {

    return this.version;
  }

  @Override
  public void setVersion(Integer version) {

    this.version = version;
  }

}
