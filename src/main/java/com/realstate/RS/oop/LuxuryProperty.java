package com.realstate.RS.oop;

public class LuxuryProperty extends ResidentialProperty {

    private String facility;

    public LuxuryProperty(
            String propertyType,
            double rent,
            String facility) {

        super(propertyType, rent);
        this.facility = facility;
    }

    @Override
    public void displayProperty() {
        System.out.println(
                "Luxury Property: "
                + propertyType
                + " | Rent: ₹"
                + rent
                + " | Facility: "
                + facility
        );
    }
}