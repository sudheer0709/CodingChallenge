package org.example.service;

import org.example.entity.NearestLocationDetails;

public interface PharmacyService {
    NearestLocationDetails findNearestLocation(double latitude, double longitude);
}
