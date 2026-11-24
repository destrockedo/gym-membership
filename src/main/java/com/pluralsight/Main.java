package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Gym Memberships ===");

        // Membership henry = new Membership("Henry Clark", 3, new BigDecimal("30.00"));

        BasicMembership alice = new BasicMembership(
                "Alice Johnson", 6, new BigDecimal("30.00"), true);

        BasicMembership bob = new BasicMembership(
                "Bob Smith", 2, new BigDecimal("27.50"), false);

        PremiumMembership carol = new PremiumMembership(
                "Carol White", 12, new BigDecimal("30.00"), 2);

        PremiumMembership frank = new PremiumMembership(
                "Frank Miller", 3, new BigDecimal("30.00"), 0);

        FamilyMembership grace = new FamilyMembership(
                "Grace Lee", 12, new BigDecimal("30.00"), 3);

        FamilyMembership emma = new FamilyMembership(
                "Emma Wilson", 6, new BigDecimal("30.00"), 1);

        ArrayList<Membership> memberships = new ArrayList<>();
        //adding all memberships to list
        memberships.add(alice);
        memberships.add(bob);
        memberships.add(carol);
        memberships.add(frank);
        memberships.add(grace);
        memberships.add(emma);

        //declaring and seting variables to 0
        BigDecimal monthlyIncome = BigDecimal.ZERO;
        BigDecimal allContracts = BigDecimal.ZERO;

        // Display memberships and

        for (Membership membership : memberships) {
            System.out.println(membership);

            printCosts(membership);
            //calculate totals
            monthlyIncome = monthlyIncome.add(membership.getMonthlyPrice());
            allContracts = allContracts.add(membership.getContractTotal());
        }

        System.out.println("Totals");
        //grabs array list size
        System.out.println("Memberships: " + memberships.size());
        //%.2f for deicmal points %n new line
        System.out.printf("Monthly income: $%.2f%n", monthlyIncome);
        System.out.printf("All contracts: $%.2f%n", allContracts);


        System.out.println("--- Front desk notes ---");

        for (Membership membership : memberships) {

            //Chechking type and wethere or not it actaully is an object in the class (casting)
            if (membership instanceof BasicMembership) {
                BasicMembership basic = (BasicMembership) membership;

                if (basic.isOffPeakOnly()) {
                    System.out.println(basic.getMemberName() + " entry between 10:00am and 4:00pm");
                }

            } else if (membership instanceof PremiumMembership) {
                PremiumMembership premium = (PremiumMembership) membership;

                premium.useGuestPass();

            } else if (membership instanceof FamilyMembership) {
                FamilyMembership family = (FamilyMembership) membership;

                //plus 1 so in adds the orginal member
                int keyCards = family.getExtraMembers() + 1;

                System.out.println(family.getMemberName()
                        + " print " + keyCards + " key cards");
            }
        }



        System.out.println("Kinds");
        //get class get class of object
        //getsimplename get class name without package attached (Had to look up, got lost)
        for (Membership membership : memberships) {System.out.println(membership.getMemberName() + ": " + membership.getClass().getSimpleName());
        }
    }
//grabs all monPrice signFee and contractToal from each object and prints it
    public static void printCosts(Membership membership) {
        System.out.println("  Monthly price: $" + membership.getMonthlyPrice() + ", sign-up fee: $" + membership.getSignUpFee() + ", contract total: $" + membership.getContractTotal());
    }
}