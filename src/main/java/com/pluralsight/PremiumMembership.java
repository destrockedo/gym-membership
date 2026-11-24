package com.pluralsight;

import java.math.BigDecimal;

public class PremiumMembership extends Membership {
    private int guestPasses;

    public PremiumMembership(String memberName, int months, BigDecimal baseRate, int guestPasses) {
        super(memberName, months, baseRate);
        this.guestPasses = guestPasses;
    }

    public int getGuestPasses() {
        return guestPasses;
    }

    public void setGuestPasses(int guestPasses) {
        this.guestPasses = guestPasses;
    }

    @Override
    //adding premium charge to base
    public BigDecimal getMonthlyPrice() {
        return getBaseRate().add(new BigDecimal("18.50"));
    }

    @Override
    //If choosing signing up for more than a year there is no sign uo fee
    public BigDecimal getSignUpFee() {
        if (getMonths() >= 12) {
            return new BigDecimal("0.00");
        }

        return super.getSignUpFee();
    }

    public void useGuestPass() {
        if (guestPasses > 0) {
            //removes 1 guess pass
            guestPasses--;

            System.out.println(getMemberName()
                    + "Passes left: " + guestPasses);
        } else {
            System.out.println(getMemberName()
                    + " you have no guest pass!");
        }
    }

    @Override
    public String toString() {
        return "Premium | " + getMemberName() + " | " + getMonths() + " months" + " | guest passes: " + guestPasses;
    }
}