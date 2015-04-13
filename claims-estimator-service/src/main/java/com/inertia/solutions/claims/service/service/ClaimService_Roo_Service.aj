// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.inertia.solutions.claims.service.service;

import com.inertia.solutions.claims.service.domain.Claim;
import com.inertia.solutions.claims.service.service.ClaimService;
import java.math.BigInteger;
import java.util.List;

privileged aspect ClaimService_Roo_Service {
    
    public abstract long ClaimService.countAllClaims();    
    public abstract void ClaimService.deleteClaim(Claim claim);    
    public abstract Claim ClaimService.findClaim(BigInteger id);    
    public abstract List<Claim> ClaimService.findAllClaims();    
    public abstract List<Claim> ClaimService.findClaimEntries(int firstResult, int maxResults);    
    public abstract void ClaimService.saveClaim(Claim claim);    
    public abstract Claim ClaimService.updateClaim(Claim claim);    
}
