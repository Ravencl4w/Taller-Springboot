package Taller.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import Taller.example.models.Plans;

public interface PlansRepository extends JpaRepository<Plans, Long> {
    
}
