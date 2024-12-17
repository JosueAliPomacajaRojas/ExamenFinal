package pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.dto;

import java.util.Date;

public record CarDetailDto(
        Integer carId,
        String make,
        String model,
        Integer year,
        String licensePlate,
        String ownerName,
        Date purchaseDate,
        Integer mileage,
        String color) {
}
