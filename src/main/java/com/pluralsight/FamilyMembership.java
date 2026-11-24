package com.pluralsight;

import java.math.BigDecimal;

public class FamilyMembership extends Membership {
    private int extraMembers;

    public FamilyMembership(String memberName, int months, BigDecimal baseRate, int extraMembers) {
        super(memberName, months, baseRate);
        this.extraMembers = extraMembers;
    }

    public int getExtraMembers() {
        return extraMembers;
    }

    public void setExtraMembers(int extraMembers) {
        this.extraMembers = extraMembers;
    }

    @Override
    public BigDecimal getMonthlyPrice() {
        BigDecimal extramemberCost = new BigDecimal("12.50")
                .multiply(BigDecimal.valueOf(extraMembers));
        //makes it so every membership after the first is cheaper and is added that way
        BigDecimal monthlyPrice = getBaseRate().add(extramemberCost);
        //after 3 extra members get a 10% iscount on anything after
        if (extraMembers >= 3) {
            monthlyPrice = monthlyPrice.multiply(new BigDecimal("0.90"));
        }

        return monthlyPrice;
    }

    @Override
    public String toString() {
        return "Family | " + getMemberName() + " | " + getMonths() + " months" + " | extra members: " + extraMembers;
    }
}