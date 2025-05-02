package com.javarush.util;

import com.javarush.entity.Feature;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FeaturesConverter implements AttributeConverter<Feature, String> {
    @Override
    public String convertToDatabaseColumn(Feature feature) {
        return feature.getValue();
    }

    @Override
    public Feature convertToEntityAttribute(String dbData) {
        Feature[] values = Feature.values();
        for (Feature feature : values) {
            if (feature.getValue().equals(dbData)) {
                return feature;
            }
        }
        return null;
    }
}