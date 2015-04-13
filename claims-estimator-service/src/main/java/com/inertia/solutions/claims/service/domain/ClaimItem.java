package com.inertia.solutions.claims.service.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooMongoEntity
public class ClaimItem {

    /**
     */
    @NotNull
    private String claimItemName;

    /**
     */
    @NotNull
    private String ClaimItemDesc;

    /**
     */
    @NotNull
    private Double claimItemAmount;
}
