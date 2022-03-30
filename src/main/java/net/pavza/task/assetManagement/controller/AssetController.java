package net.pavza.task.assetManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.pavza.task.assetManagement.model.Asset;
import net.pavza.task.assetManagement.repository.AssetRepository;

@CrossOrigin(origins = "http://localhost:8080") // CORS AYARLARI ICIN
@RestController // METHOD DONUSLERININ RESPONSE BODY SI OLACAGINI SOYLER
@RequestMapping("/api") // URL LERIN NE ILE BASLIYACAGINI TANIMLAR
public class AssetController {
  @Autowired
  AssetRepository assetRepository;

  @PostMapping("/assets")
  public ResponseEntity<Asset> createTutorial(@RequestBody Asset asset) {
    try {
      Asset response = assetRepository.save(new Asset(asset.getName()));
      return new ResponseEntity<>(response, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
