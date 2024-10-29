package com.keyin.Aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping("/aircraft")
    public List<Aircraft> getAllAircraft() {
        return aircraftService.findAllAircraft();
    }

    @GetMapping("/aircraft/{id}")
    public Aircraft getAircraftById(@PathVariable long id) {
        return aircraftService.findAircraftById(id);
    }

    @PostMapping("/aircraft")
    public Aircraft createAircraft(@RequestBody Aircraft newAircraft){
        return aircraftService.createAircraft(newAircraft);
    }

    @PutMapping("/aircraft/{id}")
    public Aircraft updateAircraft(@PathVariable Long id, @RequestBody Aircraft aircraft) {
        return aircraftService.updateAircraft(id, aircraft);
    }

    @DeleteMapping("/aircraft/{id}")
    public void deleteAircraft(@PathVariable long id) {
        aircraftService.deleteAircraft(id);
    }


}
