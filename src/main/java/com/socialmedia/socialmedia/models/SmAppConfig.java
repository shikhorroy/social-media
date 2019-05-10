// create by: Shikhor Roy
package com.socialmedia.socialmedia.models;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SM_APP_CONFIG")
@EnableAutoConfiguration
@SQLDelete(sql = "UPDATE SM_APP_CONFIG SET DELETED = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> 1")
public class SmAppConfig {

  public SmAppConfig() {
  }

  private Integer id;

  private String name;

  private String smConfigTypeId;

  private String description;

  private Integer inactive;

  private Integer deleted;

  private SmConfigType smConfigType;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
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
  @Column(name = "SM_CONFIG_TYPE_ID", nullable = true, length = 20)
  public String getSmConfigTypeId() {
    return smConfigTypeId;
  }

  public void setSmConfigTypeId(String smConfigTypeId) {
    this.smConfigTypeId = smConfigTypeId;
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

  @ManyToOne
  @JoinColumn(name = "SM_CONFIG_TYPE_ID", insertable = false, updatable = false)
  public SmConfigType getSmConfigType() {
    return smConfigType;
  }

  public void setSmConfigType(SmConfigType smConfigType) {
    this.smConfigType = smConfigType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SmAppConfig)) return false;
    SmAppConfig that = (SmAppConfig) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(name, that.name) &&
        Objects.equals(description, that.description) &&
        Objects.equals(inactive, that.inactive) &&
        Objects.equals(deleted, that.deleted) &&
        Objects.equals(smConfigType, that.smConfigType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, inactive, deleted, smConfigType);
  }
}
