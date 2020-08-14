package org.example.service;

import org.example.entity.NearestLocationDetails;
import org.example.entity.PharmacyDetails;
import org.example.exception.LocationDetailsNotFoundException;
import org.example.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class PharmacyServiceImplementation implements PharmacyService {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    String line = "";

    @Override
    public NearestLocationDetails findNearestLocation(double latitude, double longitude) {
        savePharmacyDetails();
        List<PharmacyDetails> pharmacyDetails = (List<PharmacyDetails>) pharmacyRepository.findAll();
        if(pharmacyDetails.isEmpty()){
            throw new LocationDetailsNotFoundException("location details are not persisted to the database properly");
        }
        ArrayList<Double> distances = new ArrayList<>();

        for (PharmacyDetails p : pharmacyDetails) {
            double lat = p.getLatitude();
            double lon = p.getLongitude();
            double distance = calculateDistance(latitude, longitude, lat, lon);
            distances.add(distance);
        }

        double closestPharmacyDistance = Collections.min(distances);
        int indexOfClosestPharmacy = distances.indexOf(closestPharmacyDistance);
        PharmacyDetails closestPharmacyDetails = pharmacyDetails.get(indexOfClosestPharmacy);

        NearestLocationDetails nearestLocationDetails = new NearestLocationDetails();

        nearestLocationDetails.setName(closestPharmacyDetails.getName());
        nearestLocationDetails.setAddress(closestPharmacyDetails.getAddress());
        nearestLocationDetails.setDistance(closestPharmacyDistance);

        return nearestLocationDetails;
    }

    public double calculateDistance(double latitude, double longitude, double lat, double lon) {
        double latitudeRadians = Math.toRadians(latitude);
        double longitudeRadians = Math.toRadians(longitude);
        double latRadians = Math.toRadians(lat);
        double lonRadians = Math.toRadians(lon);

        double dlon = lonRadians - longitudeRadians;
        double dlat = latRadians - latitudeRadians;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(latRadians) * Math.cos(latitudeRadians)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 3963;

        return c * r;

    }



    public void savePharmacyDetails() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/pharmacies.csv"));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                PharmacyDetails pd = new PharmacyDetails();
                pd.setName(data[0]);
                pd.setAddress(data[1]);
                pd.setCity(data[2]);
                pd.setState(data[3]);
                pd.setZip(Integer.parseInt(data[4]));
                pd.setLatitude(Double.parseDouble(data[5]));
                pd.setLongitude(Double.parseDouble(data[6]));

                pharmacyRepository.save(pd);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
