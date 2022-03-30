package net.pavza.task.assetManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.pavza.task.assetManagement.model.Asset;
import net.pavza.task.assetManagement.repository.AssetRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class AssetController {
  @Autowired
  AssetRepository assetRepository;

  @PostMapping("/assets")
  public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
    try {
      Asset response = assetRepository.save(new Asset(asset.getName()));
      return new ResponseEntity<>(response, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/assets/{id}")
  public ResponseEntity<Asset> getAssetById(@PathVariable("id") String id) {
    try {
      Optional<Asset> asset = assetRepository.findById(id);
      if (asset.isPresent()) {
        return new ResponseEntity<>(asset.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/assets")
  public ResponseEntity<List<Asset>> getAllAssets() {
    try {
      List<Asset> assetList = assetRepository.findAll();
      if (assetList.isEmpty()) {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(assetList, HttpStatus.OK);

    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/assets/{id}")
  public ResponseEntity<HttpStatus> deleteAsset(@PathVariable("id") String id) {
    try {
      assetRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
