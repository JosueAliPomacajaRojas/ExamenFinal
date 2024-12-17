package pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.service;

import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.dto.CarAddDto;
import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.dto.CarDetailDto;
import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface MaintenanceService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarAddDto carAddDto) throws Exception;

}
