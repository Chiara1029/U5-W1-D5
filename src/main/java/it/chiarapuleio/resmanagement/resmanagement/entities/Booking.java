package it.chiarapuleio.resmanagement.resmanagement.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "booking_list")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "booked_date")
    private Date bookedDate;
    @Column(name = "expiration_date")
    @Setter(AccessLevel.NONE)
    private Date expDate;
    @ManyToOne
    @JoinColumn(name = "workstation_id")
    private Workstation workstation;

    public Booking(User user, Date bookedDate, Workstation workstation) {
        this.user = user;
        this.bookedDate = bookedDate;
        this.expDate = bookedDate;
        this.workstation = workstation;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user=" + user +
                ", bookedDate=" + bookedDate +
                ", expDate=" + expDate +
                ", workstation=" + workstation +
                '}';
    }
}
