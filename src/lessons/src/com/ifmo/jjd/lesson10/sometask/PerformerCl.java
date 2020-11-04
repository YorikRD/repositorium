package com.ifmo.jjd.lesson10.sometask;

import java.util.Objects;

public class PerformerCl {
    private String pName;
    private String pCountry;

    public PerformerCl(String pName, String pCountry) {
      setpName(pName);
      setpCountry(pCountry);
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        Objects.requireNonNull(pName,"Performer name must be nonnull");
        this.pName = pName;
    }

    public String getpCountry() {
        return pCountry;
    }

    public void setpCountry(String pCountry) {
        Objects.requireNonNull(pCountry,"Performer name must be nonnull");
        this.pCountry = pCountry;
    }
}
