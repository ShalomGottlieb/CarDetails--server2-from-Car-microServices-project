package com.jb.serverA.controllers;

import com.jb.serverA.beans.Car;
import com.jb.serverA.beans.RecallDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("api")
public class apiCar {
    @Autowired
    private RestTemplate restTemplate;

    //final String carURL = "https://data.gov.il/api/3/action/datastore_search?resource_id=053cea08-09bc-40ec-8f7a-156f0677aff3&q=";
    final String carUrl = "http://localhost:8400/api/car/";
    final String handiCapUrl = "http://localhost:8200/api/car/";
    final String recallUrl="http://localhost:8500/api/car/";
    final String offRoadUrl="http://localhost:8600/api/car/";

    @GetMapping("car/{carNumber}")
    private ResponseEntity<?> getCarDetails(@PathVariable String carNumber){
        Car response = restTemplate.getForObject(carUrl+carNumber,Car.class);
       // System.out.println(response);
        //restTemplate -> handicap
        if(response!=null)
        {
            response.setHandiCap(restTemplate.getForObject(handiCapUrl+carNumber,String.class).equals("TRUE"));
            response.setRecallDetails(restTemplate.getForEntity(recallUrl+carNumber,RecallDetails[].class).getBody());
            response.setOffRoad(restTemplate.getForObject(offRoadUrl+carNumber,String.class).equals("TRUE"));
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        //System.out.println(restTemplate.getForObject(recallUrl+carNumber,String.class));
      //  response.setRecallDetails(restTemplate.getForObject(recallUrl+carNumber, RecallDetails[].class));
        return new ResponseEntity<>("[]", HttpStatus.BAD_REQUEST);
    }

}
