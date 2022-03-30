package net.pavza.task.assetManagement.model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Asset")
public class Asset {
  @Id
  private String id;
  private UUID serialNo = UUID.randomUUID();
  private String name;
  private Date assignDate = new Date();

  public Asset() {
  }

  public Asset(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UUID getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(UUID serialNo) {
    this.serialNo = serialNo;
  }

  public Date getAssignDate() {
    return assignDate;
  }

  public void setAssignDate(Date assignDate) {
    this.assignDate = assignDate;
  }

  @Override
  public String toString() {
    return "Asset [id=" + id + ", name=" + name + ", serialNo=" + serialNo + "assignDate=" + assignDate + "]";
  }
}
