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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Taller.example.models.Plans;
import Taller.example.repositories.PlansRepository;
import Taller.example.services.PlansService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping ("/api/plans")
public class PlanController {

    @Autowired
    private PlansService plansService;
    @Autowired
    private PlansRepository plansRepository;

    @PostMapping
    @ApiResponses(
        value = {
        @ApiResponse(responseCode = "200", description = "Creaste un plan"),
        @ApiResponse(responseCode = "201", description = "Se grabo exitosamente"),
        @ApiResponse(responseCode = "401", description = "No puedes hacer esto"),
    }
    )
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
    @PutMapping (value = "{id}")
    private ResponseEntity<Plans> putPlan (@PathVariable ("id") Long id,  @RequestBody Plans plans) {

        Plans updatePlan = plansService.getId(id);
        updatePlan.setDescription(plans.getDescription());
        updatePlan.setMaxFarmlandsPeruser(plans.getMaxFarmlandsPeruser());
        updatePlan.setMaxUserAllowed(plans.getMaxUserAllowed());
        updatePlan.setMonthLyPrice(plans.getMonthLyPrice());
        updatePlan.setName(plans.getName());
        final Plans plans2 = plansRepository.save(updatePlan);
        return ResponseEntity.ok(plans2);
        
    }

    
}
