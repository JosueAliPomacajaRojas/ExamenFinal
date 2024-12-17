package pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.response;

import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.dto.CarDetailDto;

public record FindCarResponse(String code,
                              String error,
                              CarDetailDto carDetailDto) {
}
