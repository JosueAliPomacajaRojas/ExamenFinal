package pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.dto.CarAddDto;
import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.dto.CarDetailDto;
import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.dto.CarDto;
import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.response.*;
import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.service.MaintenanceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage-car")
public class ManageCarApi {

    @Autowired
    MaintenanceService maintenanceService;

    /**todoAll */
    @GetMapping("/all")
    public FindCarsResponse findCars(){
        try {
            List<CarDto> cars =  maintenanceService.getAllCars();
            if(!cars.isEmpty()){
                return new FindCarsResponse("01",null,cars);
            }
            else {
                return new FindCarsResponse("02","Cars not founded",null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99","An error occurred, please try again",null);
        }
    }
    /**detalles */
    @GetMapping("/detail")
    public FindCarResponse findCar(@RequestParam(value = "id", defaultValue = "0")String id){
        try {
            Optional<CarDetailDto> optional =  maintenanceService.getCarById(Integer.parseInt(id));
            return optional.map(car ->
                    new FindCarResponse("01",null, car)
            ).orElse(
                    new FindCarResponse("02","Car not founded",null)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarResponse("99","An error occurred, please try again",null);
        }
    }
    /**Acutalizacion */
    @PutMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CarDto carDto){
        try {
            if(maintenanceService.updateCar(carDto)){
                return new UpdateCarResponse("01",null);
            }else {
                return new UpdateCarResponse("02","Car not updated");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99","An error occurred, please try again");
        }
    }
    /**Eliminación */
    @DeleteMapping("/delete/{id}")
    public DeleteCarResponse deleteCar(@PathVariable String id){
        try {
            if(maintenanceService.deleteCarById(Integer.parseInt(id))) {
                return new DeleteCarResponse("01",null);
            }else {
                return new DeleteCarResponse("02","Car not founded");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99","An error occurred, please try again");
        }
    }
    /**Creado **/
    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CarAddDto carAddDto) {
        try {
            if (maintenanceService.addCar(carAddDto))
                return new CreateCarResponse("01", "Carro Creado exitosamente");
            else
                return new CreateCarResponse("02", "Car already exists");
        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "An error occurred, please try again");
        }

    }
}
