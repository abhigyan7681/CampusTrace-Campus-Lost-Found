package com.campustrace.repository;

import com.campustrace.model.*;
import java.io.*;
import java.util.*;

public class ClaimRepository {
    private final File file = new File("data/claims.txt");
    private final List<Claim> claims = new ArrayList<>();

    public ClaimRepository() {
        load();
    }

    public List<Claim> findAll() {
        return new ArrayList<>(claims);
    }

    public void save(Claim claim) {
        claims.add(claim);
        persist();
    }

    public Claim findById(int id) {
        for (Claim claim : claims) {
            if (claim.getClaimId() == id) return claim;
        }
        return null;
    }

    public void persist() {
        ensureFile();
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Claim claim : claims) {
                writer.println(claim.getClaimId() + "|" + claim.getItemId() + "|"
                        + claim.getClaimantId() + "|" + clean(claim.getProofDescription())
                        + "|" + claim.getStatus());
            }
        } catch (IOException ex) {
            throw new RuntimeException("Could not save claims.");
        }
    }

    private void load() {
        ensureFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] p = line.split("\\|", -1);
                if (p.length == 5) {
                    claims.add(new Claim(Integer.parseInt(p[0]), Integer.parseInt(p[1]),
                            Integer.parseInt(p[2]), p[3], ClaimStatus.valueOf(p[4])));
                }
            }
        } catch (Exception ex) {
            System.out.println("Starting with empty claim data.");
        }
    }

    private void ensureFile() {
        File parent = file.getParentFile();
        if (!parent.exists()) parent.mkdirs();
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException ex) {
            throw new RuntimeException("Could not create claim storage.");
        }
    }

    private String clean(String value) {
        return value.replace("|", "/").replace("\\n", " ");
    }
}
