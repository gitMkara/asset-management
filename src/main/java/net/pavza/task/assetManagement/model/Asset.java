package net.pavza.task.assetManagement.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "Asset")
public class Asset {
  @Id
  private String id;
  private UUID serialNo = UUID.randomUUID();
  private String name;
  private Date assignDate = new Date();

  public Asset(String name) {
    this.name = name;
  }
}
