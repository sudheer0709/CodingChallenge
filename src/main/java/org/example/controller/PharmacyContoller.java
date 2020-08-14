package org.example.controller;

import org.example.service.PharmacyService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class PharmacyContoller {

    @Autowired
    private PharmacyService pharmacyService;

    @RequestMapping(method = RequestMethod.GET, value = "findNearestLocation/{latitude}/{longitude}")
    public String findNearestLocation(@ApiParam(value = "latitude and longitude values to know the nearest pharmacy")
                                          @PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude) {
        return pharmacyService.findNearestLocation(latitude, longitude).toString();
    }

}
