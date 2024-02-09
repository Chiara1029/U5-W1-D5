package it.chiarapuleio.resmanagement.resmanagement.entities;

import it.chiarapuleio.resmanagement.resmanagement.enums.StationType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "workstations")
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "station_type")
    private StationType stationType;
    @Column(name = "max_users")
    private int maxUsers;
    @ManyToOne
    @JoinColumn(name = "building")
    private Building building;
    private boolean isFree;
    @OneToMany(mappedBy = "workstation", cascade = CascadeType.ALL)
    private List<Booking> bookingStationList;

    public Workstation(String description, StationType stationType, int maxUsers, Building building, boolean isFree) {
        this.description = description;
        this.stationType = stationType;
        this.maxUsers = maxUsers;
        this.building = building;
        this.isFree = isFree;
    }

    @Override
    public String toString() {
        return "Workstation{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", stationType=" + stationType +
                ", maxUsers=" + maxUsers +
                ", building=" + building +
                ", isFree=" + isFree +
                '}';
    }
}
