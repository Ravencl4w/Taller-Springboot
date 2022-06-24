package Taller.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "plans")
public class Plans {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, name = "id")
    private Long id;
    @Column(unique = true, nullable = false, name = "name")
    private String name;
    @Column(unique = true, nullable = false, name = "description", length = 100)
    private String description;
    @Column(name = "maxuserallowed")
    private Integer maxUserAllowed;
    @Column(name = "maxfarmlandsperuser")
    private Integer maxFarmlandsPeruser;
    @Column(unique = true, nullable = false, name = "monthlyprice")
    private Long monthLyPrice;

    public Plans () {

    }

    public Plans(Long id, String name, String description, Integer maxUserAllowed, Integer maxFarmlandsPeruser,
            Long monthLyPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.maxUserAllowed = maxUserAllowed;
        this.maxFarmlandsPeruser = maxFarmlandsPeruser;
        this.monthLyPrice = monthLyPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxUserAllowed() {
        return maxUserAllowed;
    }

    public void setMaxUserAllowed(Integer maxUserAllowed) {
        this.maxUserAllowed = maxUserAllowed;
    }

    public Integer getMaxFarmlandsPeruser() {
        return maxFarmlandsPeruser;
    }

    public void setMaxFarmlandsPeruser(Integer maxFarmlandsPeruser) {
        this.maxFarmlandsPeruser = maxFarmlandsPeruser;
    }

    public Long getMonthLyPrice() {
        return monthLyPrice;
    }

    public void setMonthLyPrice(Long monthLyPrice) {
        this.monthLyPrice = monthLyPrice;
    }
    


    
}
