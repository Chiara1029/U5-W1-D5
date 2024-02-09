package it.chiarapuleio.resmanagement.resmanagement.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String name;
    private String address;
    private String city;
    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private List<Workstation> workstationList;

    public Building(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.workstationList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
