package com.realstate.RS.oop;

public class ResidentialProperty implements PropertyService {

    protected String propertyType;
    protected double rent;

    public ResidentialProperty(String propertyType, double rent) {
        this.propertyType = propertyType;
        this.rent = rent;
    }

    @Override
    public void displayProperty() {
        System.out.println(
                "Residential Property: "
                + propertyType
                + " | Rent: ₹"
                + rent
        );
    }
}