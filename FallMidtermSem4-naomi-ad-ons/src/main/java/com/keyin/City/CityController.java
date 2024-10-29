package com.keyin.City;



import com.keyin.Airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/city/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }
    //hello world
    @GetMapping("/cityAirports/{id}")
    public List<Airport> getAirportsByCityId(@PathVariable Long id) {
        return cityService.getAirportsByCityId(id);
    }
    @PostMapping("/cities")
    public City createCity(@RequestBody City newCity) {
        return cityService.createCity(newCity);
    }

    @PutMapping("/city/{id}")
    public City updateCity(@PathVariable Long id, @RequestBody City updatedCity) {
        return cityService.updateCity(id, updatedCity);
    }

    @DeleteMapping("/city/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}
