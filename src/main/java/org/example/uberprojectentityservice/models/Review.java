package org.example.uberprojectentityservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter                         // lombok library provides to handle the getter and setter automatically
@Builder                                                // lombok provides hassle free to use builder design pattern
@NoArgsConstructor           // to fix Using @Builder for JPA entities without defined no-argument constructor breaks JPA specification
@AllArgsConstructor                   // lombok @Builder needs a proper constructor for this class, so to fix this we use
@Table(name = "booking_review")                                     // this give name to table on DB context
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)          // this allows for the child class of this parent class to inherit the property and display in single table
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)      // this creates separate table for parent and child classes
@Inheritance(strategy = InheritanceType.JOINED)              // this also creates separate table but make join based on primary key, no redundancy i,e no same column
public class Review extends BaseModel{

    @Column(nullable = false)
    private String content;

    private Double rating;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)    // helps to keep no db get updated without booking, its a db level check
    private Booking booking;     // we have defined a 1:1 relationship between booking and review

    @Override
    public String toString() {
        return "Review" + " "  + this.content + " " + this.rating + " " + " booking: " + this.booking.getId() + " " + this.createdAt;
    }
}
