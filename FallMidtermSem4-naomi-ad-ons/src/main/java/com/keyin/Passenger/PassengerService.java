package com.keyin.Passenger;

import com.keyin.Aircraft.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return(List<Passenger>) passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger passenger) {
        Passenger existingPassenger = getPassengerById(id);
        if (existingPassenger != null) {
            existingPassenger.setFirstName(passenger.getFirstName());
            existingPassenger.setLastName(passenger.getLastName());
            existingPassenger.setPhoneNumber(passenger.getPhoneNumber());
            existingPassenger.setAircraft(passenger.getAircraft());
            return passengerRepository.save(existingPassenger);
        } else {
            return null;
        }s
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
    //hello world
    public List<Aircraft> getAircraftsByPassengerId(Long id) {
        Passenger passenger = getPassengerById(id);
        if (passenger != null) {
            return passenger.getAircraft();
        } else {
            return null;
        }
    }
}
