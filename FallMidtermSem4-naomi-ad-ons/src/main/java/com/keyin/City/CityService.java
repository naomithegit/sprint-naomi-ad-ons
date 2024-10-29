package com.keyin.City;

import com.keyin.Airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return (List<City>) cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City city) {
        City existingCity = getCityById(id);
        if (existingCity != null) {
            existingCity.setName(city.getName());
            existingCity.setState(city.getState());
            existingCity.setPopulation(city.getPopulation());
            existingCity.setAirports(city.getAirports());
            return cityRepository.save(existingCity);
        } else {
            return null;
        }
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
    //hello world
    public List<Airport> getAirportsByCityId(Long id) {
        City city = getCityById(id);
        if (city != null) {
            return city.getAirports();
        } else {
            return null;
        }
    }
}
