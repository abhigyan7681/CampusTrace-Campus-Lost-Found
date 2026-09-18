package com.campustrace.model;

public class Claim {
    private int claimId;
    private int itemId;
    private int claimantId;
    private String proofDescription;
    private ClaimStatus status;

    public Claim(int claimId, int itemId, int claimantId,
                 String proofDescription, ClaimStatus status) {
        this.claimId = claimId;
        this.itemId = itemId;
        this.claimantId = claimantId;
        this.proofDescription = proofDescription;
        this.status = status;
    }

    public int getClaimId() { return claimId; }
    public int getItemId() { return itemId; }
    public int getClaimantId() { return claimantId; }
    public String getProofDescription() { return proofDescription; }
    public ClaimStatus getStatus() { return status; }
    public void setStatus(ClaimStatus status) { this.status = status; }

    public String toString() {
        return "Claim{id=" + claimId + ", itemId=" + itemId
                + ", claimantId=" + claimantId + ", status=" + status
                + ", proof='" + proofDescription + "'}";
    }
}
