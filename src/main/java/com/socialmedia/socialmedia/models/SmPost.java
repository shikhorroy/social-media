// create by: Shikhor Roy
package com.socialmedia.socialmedia.models;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.joda.time.LocalDate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "SM_POST")
@EnableAutoConfiguration
@SQLDelete(sql = "UPDATE SM_POST SET DELETED = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> 1")
public class SmPost {

  public SmPost() {
  }

  private Integer id;

  private Integer userId;

  private String status;

  private LocalDate postedOn;

  private LocalDate modifiedOn;

  private String privacy;

  private Integer smAppConfigId;

  private Integer inactive;

  private Integer deleted;

  private SmUser user;

  private SmAppConfig location;

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
  @Column(name = "SM_USER_ID", nullable = true)
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Basic
  @Column(name = "STATUS", nullable = true, length = 4000)
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Basic
  @Column(name = "POSTED_ON", nullable = true)
  public LocalDate getPostedOn() {
    return postedOn;
  }

  public void setPostedOn(LocalDate postedOn) {
    this.postedOn = postedOn;
  }

  @Basic
  @Column(name = "MODIFIED_ON", nullable = true)
  public LocalDate getModifiedOn() {
    return modifiedOn;
  }

  public void setModifiedOn(LocalDate modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  @Basic
  @Column(name = "PRIVACY", nullable = true, length = 10)
  public String getPrivacy() {
    return privacy;
  }

  public void setPrivacy(String privacy) {
    this.privacy = privacy;
  }

  @Basic
  @Column(name = "SM_APP_CONFIG_ID", nullable = true)
  public Integer getSmAppConfigId() {
    return smAppConfigId;
  }

  public void setSmAppConfigId(Integer smAppConfigId) {
    this.smAppConfigId = smAppConfigId;
  }

  @ManyToOne
  @JoinColumn(name = "SM_USER_ID", insertable = false, updatable = false)
  public SmUser getUser() {
    return user;
  }

  public void setUser(SmUser user) {
    this.user = user;
  }

  @ManyToOne
  @JoinColumn(name = "SM_APP_CONFIG_ID", insertable = false, updatable = false)
  public SmAppConfig getLocation() {
    return location;
  }

  public void setLocation(SmAppConfig location) {
    this.location = location;
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
}
