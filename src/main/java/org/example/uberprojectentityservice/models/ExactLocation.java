package org.example.uberprojectentityservice.models;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExactLocation extends BaseModel{

    private String latitude;
    private String longitude;
}
