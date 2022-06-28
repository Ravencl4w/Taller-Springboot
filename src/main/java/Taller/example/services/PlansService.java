package Taller.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Taller.example.models.Plans;
import Taller.example.repositories.PlansRepository;


@Service
public class PlansService {

    @Autowired
    private PlansRepository plansRepository;
    
    public Plans create (Plans plans) {
        return plansRepository.save(plans);
    }

    public List<Plans> getAllPlans() {
       return plansRepository.findAll();
    }

   public void delete (Plans plans) {
    plansRepository.delete(plans);
   }

   public Optional<Plans> findById (Long id) {
    return plansRepository.findById(id);
   }
   public Plans getId(Long id) {
    return plansRepository.getById(id);
   }



}
