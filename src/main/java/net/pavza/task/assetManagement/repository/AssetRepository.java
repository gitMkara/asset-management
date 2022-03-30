package net.pavza.task.assetManagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.pavza.task.assetManagement.model.Asset;

public interface AssetRepository extends MongoRepository<Asset, String> {

}
