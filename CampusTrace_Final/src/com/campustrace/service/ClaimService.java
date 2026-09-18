package com.campustrace.service;

import com.campustrace.model.*;
import com.campustrace.repository.ClaimRepository;
import java.util.*;

public class ClaimService {
    private final ClaimRepository repository;
    private final ItemService itemService;

    public ClaimService(ClaimRepository repository, ItemService itemService) {
        this.repository = repository;
        this.itemService = itemService;
    }

    public Claim addClaim(int itemId, int claimantId, String proof) {
        int id = nextId();
        Claim claim = new Claim(id, itemId, claimantId, proof, ClaimStatus.PENDING);
        repository.save(claim);
        return claim;
    }

    public List<Claim> getAllClaims() {
        return repository.findAll();
    }

    public void updateStatus(int claimId, ClaimStatus status) {
        Claim claim = repository.findById(claimId);
        if (claim == null) throw new IllegalArgumentException("Claim not found.");
        claim.setStatus(status);
        repository.persist();
        if (status == ClaimStatus.APPROVED) {
            itemService.markReturned(claim.getItemId());
        }
    }

    private int nextId() {
        int max = 0;
        for (Claim claim : repository.findAll()) {
            if (claim.getClaimId() > max) max = claim.getClaimId();
        }
        return max + 1;
    }
}
