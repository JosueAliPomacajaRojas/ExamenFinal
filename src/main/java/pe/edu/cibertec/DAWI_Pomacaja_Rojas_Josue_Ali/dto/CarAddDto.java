package pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.dto;

import java.util.Date;

public record CarAddDto (
        Integer id,
        String make,
        String model,
        Integer year,
        String vin,
        String licensePlate,
        String ownerName,
        String ownerContact,
        Date purchaseDate,
        Integer mileage,
        String engineType,
        String color,
        String insuranceCompany,
        String insurancePolicyNumber,
        Date registrationExpirationDate,
        Date serviceDueDate
){
}
