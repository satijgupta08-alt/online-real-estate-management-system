package com.realstate.RS.oop;

public class OOPTest {

    public static void main(String[] args) {

        PropertyService property1 =
                new ResidentialProperty("2 BHK Flat", 25000);

        PropertyService property2 =
                new LuxuryProperty(
                        "5 BHK Apartment",
                        60000,
                        "Swimming Pool"
                );

        property1.displayProperty();
        property2.displayProperty();
    }
}