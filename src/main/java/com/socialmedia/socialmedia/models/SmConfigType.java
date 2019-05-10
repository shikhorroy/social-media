// create by: Shikhor Roy
package com.socialmedia.socialmedia.models;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SM_CONFIG_TYPE")
@EnableAutoConfiguration
@SQLDelete(sql = "UPDATE SM_CONFIG_TYPE SET DELETED = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> 1")
public class SmConfigType {

  public SmConfigType() {
  }

  private String id;

  private String name;

  private String description;

  private String value;

  private Integer inactive;

  private Integer deleted;

  @Id
  @Basic
  @Column(name = "ID", nullable = false, length = 20)
  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Basic
  @Column(name = "NAME", nullable = true, length = 50)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "DESCRIPTION", nullable = true, length = 100)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Basic
  @Column(name = "VALUE", nullable = true, length = 50)
  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Basic
  @Column(name = "INACTIVE", nullable = true)
  public Integer getInactive() {
    return inactive;
  }

  public void setInactive(Integer inactive) {
    this.inactive = inactive;
  }

  @Basic
  @Column(name = "DELETED", nullable = true)
  public Integer getDeleted() {
    return deleted;
  }

  public void setDeleted(Integer deleted) {
    this.deleted = deleted;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SmConfigType)) return false;
    SmConfigType that = (SmConfigType) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(name, that.name) &&
        Objects.equals(description, that.description) &&
        Objects.equals(value, that.value) &&
        Objects.equals(inactive, that.inactive) &&
        Objects.equals(deleted, that.deleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, value, inactive, deleted);
  }
}
