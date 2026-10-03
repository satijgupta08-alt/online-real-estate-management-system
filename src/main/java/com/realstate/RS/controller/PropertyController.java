package com.realstate.RS.controller;

import com.realstate.RS.entity.Property;
import com.realstate.RS.repository.PropertyRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin
public class PropertyController {

    private final PropertyRepository propertyRepository;

    public PropertyController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    // Add a new property
    @PostMapping
    public Property addProperty(@RequestBody Property property) {
        return propertyRepository.save(property);
    }

    // Get all properties
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    // Get property by ID
    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable Long id) {
        return propertyRepository.findById(id).orElse(null);
    }

    // Update property
    @PutMapping("/{id}")
    public Property updateProperty(
            @PathVariable Long id,
            @RequestBody Property property) {

        Property existingProperty =
                propertyRepository.findById(id).orElse(null);

        if (existingProperty == null) {
            return null;
        }

        existingProperty.setTitle(property.getTitle());
        existingProperty.setAddress(property.getAddress());
        existingProperty.setCity(property.getCity());
        existingProperty.setPrice(property.getPrice());
        existingProperty.setDescription(property.getDescription());
        existingProperty.setPropertyType(property.getPropertyType());
        existingProperty.setAvailable(property.isAvailable());

        return propertyRepository.save(existingProperty);
    }

    // Delete property
    @DeleteMapping("/{id}")
    public String deleteProperty(@PathVariable Long id) {

        if (!propertyRepository.existsById(id)) {
            return "Property not found";
        }

        propertyRepository.deleteById(id);

        return "Property deleted successfully";
    }

    // Search properties by city
    @GetMapping("/search")
    public List<Property> searchByCity(@RequestParam String city) {
        return propertyRepository.findByCity(city);
    }
}