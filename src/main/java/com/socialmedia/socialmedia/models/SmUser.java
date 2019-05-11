// create by: Shikhor Roy
package com.socialmedia.socialmedia.models;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "SM_USER")
@EnableAutoConfiguration
@SQLDelete(sql = "UPDATE SM_USER SET DELETED = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> 1")
public class SmUser {

  public SmUser() {
  }

  private Integer id;

  private String userName;

  private String password;

  private String smConfigTypeId;

  private Integer inactive;

  private Integer deleted;

  private SmConfigType type;

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
  @Column(name = "USERNAME", nullable = true, length = 50)
  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String name) {
    this.userName = name;
  }

  @Basic
  @Column(name = "PASSWORD", nullable = true, length = 50)
  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
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
  public SmConfigType getType() {
    return this.type;
  }

  public void setType(SmConfigType type) {
    this.type = type;
  }
}
