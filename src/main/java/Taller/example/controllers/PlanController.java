package Taller.example.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Taller.example.models.Plans;
import Taller.example.services.PlansService;

@RestController
@RequestMapping ("/api/plans")
public class PlanController {

    @Autowired
    private PlansService plansService;

    @PostMapping
    private ResponseEntity<Plans> savePlan (@RequestBody Plans plans) {
        
        Plans tempPlan = plansService.create(plans);

        try {

            return ResponseEntity.created(new URI("/api/plans"+tempPlan.getId())).body(tempPlan);

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }   
    }

    @GetMapping
    private ResponseEntity<List<Plans>> listarTodo () {
        return ResponseEntity.ok(plansService.getAllPlans());
    }

    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<Plans>> getById (@PathVariable ("id") Long id) {
        if(plansService.findById(id).isPresent())
        {
            return ResponseEntity.ok(plansService.findById(id));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
    }

    
}
