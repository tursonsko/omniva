package app.smartive.omniva.service;

import app.smartive.omniva.configuration.HostAddressConfig;
import app.smartive.omniva.model.Location;
import app.smartive.omniva.model.LocationDto;
import app.smartive.omniva.repository.LocationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.*;

import static java.util.stream.Collectors.toList;


@Service
public class ApiClientService {

    private final HostAddressConfig hostAddressConfig;
    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    private final LocationRepository locationRepository;
    private final List<LocationDto> locationDtoList;

    public ApiClientService
    (
        HostAddressConfig hostAddressConfig,
        WebClient webClient,
        ObjectMapper objectMapper,
        LocationRepository locationRepository,
        List<LocationDto> locationDtoList
    ) {
        this.hostAddressConfig = hostAddressConfig;
        this.webClient = webClient;
        this.objectMapper = objectMapper;
        this.locationRepository = locationRepository;
        this.locationDtoList = locationDtoList;
    }

    @PostConstruct
    public void saveJsonToDataBase() {

        List<LocationDto> locationDtosList = locationDtoList;
        List<Location> list = locationDtosList
                .stream()
                .map(location -> objectMapper.convertValue(location, Location.class))
                .collect(toList());

        locationRepository.saveAll(list);
    }

//    @Scheduled(fixedDelay = 86400000L) /*one day in miliseconds*/
    @Scheduled(fixedDelay = 10000L)
    public void updateEntity() {

        List<Location> entityList = locationRepository.findAll();
        List<LocationDto> locationDtosList = locationDtoList;

        entityList.forEach(location -> {
            Optional<LocationDto> matchingDtoWithEntity = locationDtosList.stream()
                    .filter(locationDto -> Objects.equals(location.getName(), locationDto.getName()))
                    .findFirst();
            if(matchingDtoWithEntity.isPresent()) {
                location.setZip(matchingDtoWithEntity.get().getZip());
                location.setName(matchingDtoWithEntity.get().getName());
                location.setType(matchingDtoWithEntity.get().getType());
                location.setA0_name(matchingDtoWithEntity.get().getA0_name());
                location.setA1_name(matchingDtoWithEntity.get().getA1_name());
                location.setA2_name(matchingDtoWithEntity.get().getA2_name());
                location.setA3_name(matchingDtoWithEntity.get().getA3_name());
                location.setA4_name(matchingDtoWithEntity.get().getA4_name());
                location.setA5_name(matchingDtoWithEntity.get().getA5_name());
                location.setA6_name(matchingDtoWithEntity.get().getA6_name());
                location.setA7_name(matchingDtoWithEntity.get().getA7_name());
                location.setA8_name(matchingDtoWithEntity.get().getA8_name());
                location.setX_coordinate(matchingDtoWithEntity.get().getX_coordinate());
                location.setY_coordinate(matchingDtoWithEntity.get().getY_coordinate());
                location.setService_hours(matchingDtoWithEntity.get().getService_hours());
                location.setTemp_service_hours(matchingDtoWithEntity.get().getService_hours());
                location.setTEMP_SERVICE_HOURS_UNTIL(matchingDtoWithEntity.get().getTEMP_SERVICE_HOURS_UNTIL());
                location.setTEMP_SERVICE_HOURS_2(matchingDtoWithEntity.get().getTEMP_SERVICE_HOURS_2());
                location.setTEMP_SERVICE_HOURS_2_UNTIL(matchingDtoWithEntity.get().getTEMP_SERVICE_HOURS_2_UNTIL());
                location.setComment_est(matchingDtoWithEntity.get().getComment_est());
                location.setComment_eng(matchingDtoWithEntity.get().getComment_eng());
                location.setComment_rus(matchingDtoWithEntity.get().getComment_rus());
                location.setComment_lav(matchingDtoWithEntity.get().getComment_lav());
                location.setComment_lit(matchingDtoWithEntity.get().getComment_lit());
                location.setModified(matchingDtoWithEntity.get().getModified());
            }
        });

        locationRepository.saveAll(entityList);
    }
}