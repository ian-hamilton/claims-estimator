// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.inertia.solutions.claims.service.domain;

import com.inertia.solutions.claims.service.domain.Claim;
import java.math.BigInteger;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;

privileged aspect Claim_Roo_Mongo_Entity {
    
    declare @type: Claim: @Persistent;
    
    @Id
    private BigInteger Claim.id;
    
    public BigInteger Claim.getId() {
        return this.id;
    }
    
    public void Claim.setId(BigInteger id) {
        this.id = id;
    }
    
}