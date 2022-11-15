package org.example.app.general.common.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Abstract base class for search criteria objects used to specify dynamic queries.
 */
public abstract class SearchCriteria {

  private int pageNumber;

  private int pageSize;

  private boolean determineTotal;

  private List<SortOrderBy> sort;

  /**
   * The constructor.
   */
  public SearchCriteria() {

    super();
    this.pageSize = 50;
  }

  /**
   * @return the {@link org.springframework.data.domain.Page} {@link org.springframework.data.domain.Page#getNumber()
   *         number}. Use {@code 0} for the first search and increment to step to the next
   *         {@link org.springframework.data.domain.Page} if more hits are available.
   */
  public int getPageNumber() {

    return this.pageNumber;
  }

  /**
   * @param pageNumber new value of {@link #getPageNumber()}.
   */
  public void setPageNumber(int pageNumber) {

    this.pageNumber = pageNumber;
  }

  /**
   * @return the {@link org.springframework.data.domain.Page} {@link org.springframework.data.domain.Page#getSize()
   *         size} or in other words the number of search hits per {@link org.springframework.data.domain.Page}.
   */
  public int getPageSize() {

    return this.pageSize;
  }

  /**
   * @param pageSize new value of {@link #getPageSize()}.
   */
  public void setPageSize(int pageSize) {

    this.pageSize = pageSize;
  }

  /**
   * @return {@code true} to determine the total number of search hits found, {@code false} otherwise. <b>ATTENTION:</b>
   *         If set to {@code true} an extra COUNT query has to be performed in the database. This can be extremely
   *         expensive regarding performance.
   */
  public boolean isDetermineTotal() {

    return this.determineTotal;
  }

  /**
   * @param determineTotal new value of {@link #isDetermineTotal()}.
   */
  public void setDetermineTotal(boolean determineTotal) {

    this.determineTotal = determineTotal;
  }

  /**
   * @return the {@link List} of {@link SortOrderBy}-objects used to sort the results.
   */
  public List<SortOrderBy> getSort() {

    if (this.sort == null) {
      this.sort = new ArrayList<>();
    }
    return this.sort;
  }

  /**
   * @param sort new value of {@link #getSort()}.
   */
  public void setSort(List<SortOrderBy> sort) {

    this.sort = sort;
  }

  /**
   * @return the {@link Pageable} from {@link #getPageNumber()} and {@link #getPageSize()}.
   */
  public Pageable asPageable() {

    return PageRequest.of(this.pageNumber, this.pageSize);
  }

}
