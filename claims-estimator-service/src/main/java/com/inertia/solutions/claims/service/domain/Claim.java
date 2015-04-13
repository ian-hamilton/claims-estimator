package com.inertia.solutions.claims.service.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Enumerated;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

@RooJavaBean
@RooToString
@RooMongoEntity
public class Claim {

    /**
     */
    private String userId;

    /**
     */
    private Double claimTotal;

    /**
     */
    private Double claimCurrentTotal;

    /**
     */
    @Enumerated
    private ClaimType claimType;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ClaimItem> claimItems = new HashSet<ClaimItem>();
}
