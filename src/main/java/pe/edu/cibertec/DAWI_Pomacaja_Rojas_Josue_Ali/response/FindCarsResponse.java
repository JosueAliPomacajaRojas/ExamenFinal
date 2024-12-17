package pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.response;

import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.dto.CarDto;

import java.util.List;

public record FindCarsResponse(String code,
                               String error,
                               List<CarDto> cars) {
}
