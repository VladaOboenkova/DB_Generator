package com;

import com.generator.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import com.service.*;

@ConfigurationProperties(prefix = "demo")
@Validated
    public class AppProperties {

        @Autowired
        private AddServiceService addServiceService;

        @Autowired
        private ChoosenServiceService choosenServiceService;

        @Autowired
        private CityService cityService;

        @Autowired
        private ClientService clientService;

        @Autowired
        private CountryService countryService;

        @Autowired
        private HotelService hotelService;

        @Autowired
        private InsuranceService insuranceService;

        @Autowired
        private InsuranceCaseService insuranceCaseService;

        @Autowired
        private InsuranceOptionService insuranceOptionService;

        @Autowired
        private InsuranceTypeService insuranceTypeService;

        @Autowired
        private OrderService orderService;

        @Autowired
        private PersonInfoService personInfoService;

        @Autowired
        private PersonInsuranceService personInsuranceService;

        @Autowired
        private PositionService positionService;

        @Autowired
        private TourAddServiceService tourAddServiceService;

        @Autowired
        private TouristsService touristsService;

        @Autowired
        private TourService toursService;

        @Autowired
        private TourStaffService tourStaffService;

        @Autowired
        private TypeOfFoodService typeOfFoodService;

        @Autowired
        private TypeOfRoomService typeOfRoomService;

        private Integer personInfo;
        private Integer client;
        private Integer position;
        private Integer tourStaff;
        private Integer country;
        private Integer city;
        private Integer hotel;
        private Integer typeOfFood;
        private Integer typeOfRoom;
        private Integer tour;
        private Integer addService;
        private Integer order;
        private Integer tourists;
        private Integer tourAddService;
        private Integer choosenService;
        private Integer insurance;
        private Integer insuranceType;
        private Integer insuranceOption;
        private Integer personInsurance;
        private Integer insuranceCase;

        public void generateData(int personInfo, int client, int position, int tourStaff,
                                 int country, int city, int hotel, int typeOfFood, int typeOfRoom,
                                 int tour, int addService, int order, int tourists,
                                 int tourAddService, int choosenService, int insurance, int insuranceType,
                                 int insuranceOption, int personInsurance, int insuranceCase) {
            Generator generator = new Generator(personInfo, client, position, tourStaff,
            country, city, hotel, typeOfFood, typeOfRoom, tour, addService, order, tourists, tourAddService,
            choosenService, insurance, insuranceType, insuranceOption, personInsurance, insuranceCase);
            generator.generatePersonInfo(personInfoService);
            generator.generateClient(clientService, personInfoService);
            generator.generatePosition(positionService);
            generator.generateTourStaff(tourStaffService, personInfoService, positionService);
            generator.generateCountry(countryService);
            generator.generateCity(cityService, countryService);
            generator.generateHotel(hotelService, cityService);
            generator.generateTypeOfFood(typeOfFoodService);
            generator.generateTypeOfRoom(typeOfRoomService);
            generator.generateTour(toursService, typeOfFoodService, typeOfRoomService, hotelService);
            generator.generateAddService(addServiceService);
            generator.generateOrder(orderService, toursService, clientService, tourStaffService);
            generator.generateTourists(touristsService, orderService, personInfoService);
            generator.generateTourAddService(toursService, addServiceService, tourAddServiceService);
            generator.generateChoosenService(orderService, tourAddServiceService,
                    choosenServiceService, addServiceService);
            generator.generateInsurance(insuranceService);
            generator.generateInsuranceType(insuranceTypeService);
            generator.generateInsuranceOption(insuranceService, insuranceTypeService, insuranceOptionService);
            generator.generatePersonInsurance(insuranceService, touristsService, personInsuranceService);
            generator.generateInsuranceCase(personInsuranceService, insuranceOptionService, insuranceCaseService);
        }

    public Integer getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(Integer personInfo) {
        this.personInfo = personInfo;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getTourStaff() {
        return tourStaff;
    }

    public void setTourStaff(Integer tourStaff) {
        this.tourStaff = tourStaff;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getHotel() {
        return hotel;
    }

    public void setHotel(Integer hotel) {
        this.hotel = hotel;
    }

    public Integer getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(Integer typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public Integer getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(Integer typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public Integer getTour() {
        return tour;
    }

    public void setTour(Integer tour) {
        this.tour = tour;
    }

    public Integer getAddService() {
        return addService;
    }

    public void setAddService(Integer addService) {
        this.addService = addService;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getTourists() {
        return tourists;
    }

    public void setTourists(Integer tourists) {
        this.tourists = tourists;
    }

    public Integer getTourAddService() {
        return tourAddService;
    }

    public void setTourAddService(Integer tourAddService) {
        this.tourAddService = tourAddService;
    }

    public Integer getChoosenService() {
        return choosenService;
    }

    public void setChoosenService(Integer choosenService) {
        this.choosenService = choosenService;
    }

    public Integer getInsurance() {
        return insurance;
    }

    public void setInsurance(Integer insurance) {
        this.insurance = insurance;
    }

    public Integer getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(Integer insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Integer getInsuranceOption() {
        return insuranceOption;
    }

    public void setInsuranceOption(Integer insuranceOption) {
        this.insuranceOption = insuranceOption;
    }

    public Integer getPersonInsurance() {
        return personInsurance;
    }

    public void setPersonInsurance(Integer personInsurance) {
        this.personInsurance = personInsurance;
    }

    public Integer getInsuranceCase() {
        return insuranceCase;
    }

    public void setInsuranceCase(Integer insuranceCase) {
        this.insuranceCase = insuranceCase;
    }
}
