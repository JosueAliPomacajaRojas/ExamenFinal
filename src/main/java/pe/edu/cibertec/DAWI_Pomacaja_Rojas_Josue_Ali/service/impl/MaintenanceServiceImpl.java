package pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.dto.CarAddDto;
import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.dto.CarDetailDto;
import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.dto.CarDto;
import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.entity.Car;
import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.repository.CarRepository;
import pe.edu.cibertec.DAWI_Pomacaja_Rojas_Josue_Ali.service.MaintenanceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> list = new ArrayList<CarDto>();

        Iterable<Car> iterable = carRepository.findAll();

        iterable.forEach(car -> {
            list.add(new CarDto(car.getCarId(),
                    car.getModel(),
                    car.getOwnerName(),
                    car.getEngineType(),
                    car.getColor(),
                    car.getLicensePlate()
                    ));
        });
        return list;

    }

    @Override
    public Optional<CarDetailDto> getCarById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car ->
                new CarDetailDto(
                        car.getCarId(),
                        car.getMake(),
                        car.getModel(),
                        car.getYear(),
                        car.getLicensePlate(),
                        car.getOwnerName(),
                        car.getPurchaseDate(),
                        car.getMileage(),
                        car.getColor()
                )
        );
    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carDto.carId());
        return optional.map(car ->
        {
            car.setModel(carDto.model());
            car.setOwnerName(carDto.ownerName());
            car.setEngineType(carDto.engineType());
            car.setColor(carDto.color());
            car.setLicensePlate(carDto.licensePlate());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean deleteCarById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean addCar(CarAddDto carAddDto) throws Exception {
        Optional<Car> optional = carRepository.findById(carAddDto.id());
        if (optional.isPresent())
            return false;
        else {
            Car car = new Car();
            car.setMake(carAddDto.make());
            car.setModel(carAddDto.model());
            car.setYear(carAddDto.year());
            car.setVin(carAddDto.vin());
            car.setLicensePlate(carAddDto.licensePlate());
            car.setOwnerName(carAddDto.ownerName());
            car.setOwnerContact(carAddDto.ownerContact());
            car.setPurchaseDate(carAddDto.purchaseDate());
            car.setMileage(carAddDto.mileage());
            car.setEngineType(carAddDto.engineType());
            car.setColor(carAddDto.color());
            car.setInsuranceCompany(carAddDto.insuranceCompany());
            car.setInsurancePolicyNumber(carAddDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(new Date());
            car.setServiceDueDate(new Date());
            carRepository.save(car);
            return true;
        }
    }
}
