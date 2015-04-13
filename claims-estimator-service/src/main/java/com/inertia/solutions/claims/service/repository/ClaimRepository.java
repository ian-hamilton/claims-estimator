package com.inertia.solutions.claims.service.repository;
import com.inertia.solutions.claims.service.domain.Claim;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoRepository;

@RooMongoRepository(domainType = Claim.class)
public interface ClaimRepository {

    List<Claim> findAll();
}
