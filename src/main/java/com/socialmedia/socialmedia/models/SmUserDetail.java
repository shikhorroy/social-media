// create by: Shikhor Roy
package com.socialmedia.socialmedia.models;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "SM_USER_DETAIL")
@EnableAutoConfiguration
@SQLDelete(sql = "UPDATE SM_USER_DETAIL SET DELETED = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> 1")
public class SmUserDetail {

  public SmUserDetail() {
  }

  private Integer id;

  private Integer userId;

  private String gender;

  private String firstName;

  private String lastName;

  private String fatherName;

  private String motherName;

  private String email;

  private String phone;

  private String address;

  private Integer inactive;

  private Integer deleted;

  private SmUser user;

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
  @Column(name = "GENDER", nullable = true, length = 5)
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Basic
  @Column(name = "FIRST_NAME", nullable = true, length = 50)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Basic
  @Column(name = "LAST_NAME", nullable = true, length = 50)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Basic
  @Column(name = "FATHER_NAME", nullable = true, length = 100)
  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

  @Basic
  @Column(name = "MOTHER_NAME", nullable = true, length = 100)
  public String getMotherName() {
    return motherName;
  }

  public void setMotherName(String motherName) {
    this.motherName = motherName;
  }

  @Basic
  @Column(name = "EMAIL", nullable = true, length = 20)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Basic
  @Column(name = "PHONE", nullable = true, length = 20)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Basic
  @Column(name = "ADDRESS", nullable = true, length = 150)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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
  @JoinColumn(name = "SM_USER_ID", insertable = false, updatable = false)
  public SmUser getUser() {
    return this.user;
  }

  public void setUser(SmUser user) {
    this.user = user;
  }
}
