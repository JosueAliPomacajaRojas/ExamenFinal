package pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;
    private String make;
    private String model;
    private Integer year;
    private String vin;
    private String licensePlate;
    private String ownerName;
    private String ownerContact;
    private Date purchaseDate;
    private Integer mileage;
    private String engineType;
    private String color;
    private String insuranceCompany;
    private String insurancePolicyNumber;
    private Date registrationExpirationDate;
    private Date serviceDueDate;
}