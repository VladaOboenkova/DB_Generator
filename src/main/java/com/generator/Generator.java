package com.generator;

import com.entity.*;
import com.service.*;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Generator {

    Random r = new Random();

    private final int personInfoNumber;
    private final int clientNumber;
    private final int positionNumber;
    private final int tourStaffNumber;
    private final int countryNumber;
    private final int cityNumber;
    private final int hotelNumber;
    private final int typeOfFoodNumber;
    private final int typeOfRoomNumber;
    private final int tourNumber;
    private final int addServiceNumber;
    private final int orderNumber;
    private final int touristsNumber;
    private final int tourAddServiceNumber;
    private final int choosenServiceNumber;
    private final int insuranceNumber;
    private final int insuranceTypeNumber;
    private final int insuranceOptionNumber;
    private final int personInsuranceNumber;
    private final int insuranceCaseNumber;
    private final LocalDate foundationDate = LocalDate.of(2018, 2, 18);
    private final LocalDate oldestPerson = LocalDate.now().minusYears(80);
    private final LocalDate youngestPerson = LocalDate.now().minusYears(1);

    public Generator(int personInfoNumber, int clientNumber, int positionNumber, int tourStaffNumber,
                     int countryNumber, int cityNumber, int hotelNumber, int typeOfFoodNumber, int typeOfRoomNumber,
                     int tourNumber, int addServiceNumber, int orderNumber, int touristsNumber,
                     int tourAddServiceNumber, int choosenServiceNumber, int insuranceNumber, int insuranceTypeNumber,
                     int insuranceOptionNumber, int personInsuranceNumber, int insuranceCaseNumber) {
        this.personInfoNumber = personInfoNumber;
        this.clientNumber = clientNumber;
        this.positionNumber = positionNumber;
        this.tourStaffNumber = tourStaffNumber;
        this.countryNumber = countryNumber;
        this.cityNumber = cityNumber;
        this.hotelNumber = hotelNumber;
        this.typeOfFoodNumber = typeOfFoodNumber;
        this.typeOfRoomNumber = typeOfRoomNumber;
        this.tourNumber = tourNumber;
        this.addServiceNumber = addServiceNumber;
        this.orderNumber = orderNumber;
        this.touristsNumber = touristsNumber;
        this.tourAddServiceNumber = tourAddServiceNumber;
        this.choosenServiceNumber = choosenServiceNumber;
        this.insuranceNumber = insuranceNumber;
        this.insuranceTypeNumber = insuranceTypeNumber;
        this.insuranceOptionNumber = insuranceOptionNumber;
        this.personInsuranceNumber = personInsuranceNumber;
        this.insuranceCaseNumber = insuranceCaseNumber;
    }

    public void generatePersonInfo(PersonInfoService personInfoService) {
        for (int i = 0; i < this.personInfoNumber; i++) {
            PersonInfo personInfo = new PersonInfo();
            double middleNameDouble = r.nextDouble();
            String middle_name;
            if (middleNameDouble >= 0.05) {
                middle_name = DataGeneration.generateWord(20, true, false, r);
            } else {
                middle_name = null;
            }
            personInfo.setSurname(DataGeneration.generateWord(20, true, false, r));
            personInfo.setName(DataGeneration.generateWord(20, true, false, r));
            personInfo.setMiddle_name(middle_name);
            personInfo.setDob(DataGeneration.generateDateBetween(oldestPerson, youngestPerson).toLocalDate());
            String phone;
            int age = Period.between(personInfo.getDob(), LocalDate.now()).getYears();
            if (age < 5){
                phone = null;
            } else if (age < 14) {
                double phoneDouble = r.nextDouble();
                if (phoneDouble >= 0.3) {
                    phone = DataGeneration.generatePhone(r);
                } else{
                    phone = null;
                }
            } else {
                phone = DataGeneration.generatePhone(r);
            }
            personInfo.setPhone(phone);
            String email;
            if (age >= 15){
                double emailDouble = r.nextDouble();
                if (emailDouble >= 0.3) {
                    email = DataGeneration.generateEmail(r);
                } else {
                    email = null;
                }
            } else {
                email = null;
            }
            personInfo.setEmail(email);
            String intl_passport_num;
            String intl_passport_series;
            if (age < 18){
                    intl_passport_num = DataGeneration.generateNumberSequence(2, r);
                    intl_passport_series = DataGeneration.generateNumberSequence(7, r);
            } else {
                double intlPassportDouble = r.nextDouble();
                if (intlPassportDouble >= 0.3){
                    intl_passport_num = DataGeneration.generateNumberSequence(2, r);
                    intl_passport_series = DataGeneration.generateNumberSequence(7, r);
                } else {
                    intl_passport_num = null;
                    intl_passport_series = null;
                }
            }
            personInfo.setIntl_passport_num(intl_passport_num);
            personInfo.setIntl_passport_series(intl_passport_series);
            personInfoService.createPersonInfo(personInfo);
        }
    }

    public void generatePosition(PositionService positionService) {
        for (int i = 0; i < this.positionNumber; i++) {
            Position position = new Position();
            position.setPosition_name(DataGeneration.generateText(4, false, false, r));
            position.setSalary(DataGeneration.generateMoney(15000, 70000, r));
            positionService.createPosition(position);
        }
    }

    public void generateTypeOfFood(TypeOfFoodService typeOfFoodService) {
        for (int i = 0; i < this.typeOfFoodNumber; i++) {
            TypeOfFood typeOfFood = new TypeOfFood();
            typeOfFood.setType_of_food(DataGeneration.generateText(2, false, false, r));
            typeOfFoodService.createTypeOfFood(typeOfFood);
        }
    }

    public void generateTypeOfRoom(TypeOfRoomService typeOfRoomService) {
        for (int i = 0; i < this.typeOfRoomNumber; i++) {
            TypeOfRoom typeOfRoom = new TypeOfRoom();
            typeOfRoom.setType_of_room(DataGeneration.generateText(2, true, true, r));
            typeOfRoomService.createTypeOfRoom(typeOfRoom);
        }
    }

    public void generateCountry(CountryService countryService) {
        for (int i = 0; i < this.countryNumber; i++) {
            Country country = new Country();
            country.setName(DataGeneration.generateText(3, false, true, r));
            country.setNeed_insurance(DataGeneration.generateBoolean(r));
            country.setVisa(DataGeneration.generateBoolean(r));
            countryService.createCountry(country);
        }
    }

    public void generateAddService(AddServiceService addServiceService) {
        for (int i = 0; i < this.addServiceNumber; i++) {
            AddService addService = new AddService();
            addService.setName(DataGeneration.generateText(4, false, false, r));
            addService.setSurcharge(DataGeneration.generateMoney(100, 10000, r));
            addServiceService.createAddService(addService);
        }
    }

    public void generateInsurance(InsuranceService insuranceService) {
        for (int i = 0; i < this.insuranceNumber; i++) {
            Insurance insurance = new Insurance();
            insurance.setName(DataGeneration.generateText(2, false, true, r));
            insurance.setOne_day_price(DataGeneration.generateMoney(200, 1000, r));
            insuranceService.createInsurance(insurance);
        }
    }

    public void generateInsuranceType(InsuranceTypeService insuranceTypeService) {
        for (int i = 0; i < this.insuranceTypeNumber; i++) {
            InsuranceType insuranceType = new InsuranceType();
            insuranceType.setName(DataGeneration.generateText(5, false, false, r));
            insuranceTypeService.createInsuranceType(insuranceType);
        }
    }

    public void generateCity(CityService cityService, CountryService countryService) {
        for (int i = 0; i < this.cityNumber; i++) {
            City city = new City();
            city.setName(DataGeneration.generateText(3, false, true, r));
            city.setId_country(countryService.findAll().get(r.nextInt(countryService.count())));
            cityService.createCity(city);
        }
    }

    public void generateHotel(HotelService hotelService, CityService cityService) {
        for (int i = 0; i < this.hotelNumber; i++) {
            Hotel hotel = new Hotel();
            hotel.setName(DataGeneration.generateText(5, true, true, r));
            hotel.setId_city(cityService.findAll().get(r.nextInt(cityService.count())));
            hotel.setStars(DataGeneration.generateNumber(1, 5, r));
            hotelService.createHotel(hotel);
        }
    }

    public void generateTour(TourService tourService,  TypeOfFoodService typeOfFoodService,
                             TypeOfRoomService typeOfRoomService, HotelService hotelService) {
        for (int i = 0; i < this.tourNumber; i++) {
            Tour tour = new Tour();
            tour.setId_hotel(hotelService.findAll().get(r.nextInt(hotelService.count())));
            tour.setId_type_of_food(typeOfFoodService.findAll().get(r.nextInt(typeOfFoodService.count())));
            tour.setId_type_of_room(typeOfRoomService.findAll().get(r.nextInt(typeOfRoomService.count())));
            tour.setNum_of_adults(DataGeneration.generateNumber(1, 6, r));
            tour.setNum_of_children(DataGeneration.generateNumber(0, 3, r));
            tour.setOne_night_price(DataGeneration.generateMoney(1000, 30000, r));
            tourService.createTour(tour);
        }
    }

    public void generateClient(ClientService clientService,
                               PersonInfoService personInfoService) {
        for (int i = 0; i < this.clientNumber; i++) {
            Client client = new Client();
            List<PersonInfo> adults = personInfoService.findAllAdults();
            client.setId_person_info(adults.get(r.nextInt(adults.size())));
            client.setPassport_num(DataGeneration.generateNumberSequence(4, r));
            client.setPassport_series(DataGeneration.generateNumberSequence(6, r));
            clientService.createClient(client);
        }
    }

    public void generateTourStaff(TourStaffService tourStaffService, PersonInfoService personInfoService,
                                   PositionService positionService) {
        for (int i = 0; i < this.tourStaffNumber; i++) {
            TourStaff tourStaff = new TourStaff();
            List<PersonInfo> adults = personInfoService.findAllAdults();
            tourStaff.setId_person_info(adults.get(r.nextInt(adults.size())));
            tourStaff.setId_position(positionService.findAll().get(r.nextInt(positionService.count() - 1) + 1));
            tourStaffService.createTourStaff(tourStaff);
        }
    }

    public void generateOrder(OrderService orderService, TourService tourService,  ClientService clientService,
                              TourStaffService tourStaffService) {
        for (int i = 0; i < this.orderNumber; i++) {
            Order order = new Order();
            LocalDate now = LocalDate.now();
            LocalDateTime order_date_time = DataGeneration.generateDateBetween(foundationDate, now);
            order.setOrder_date_time(order_date_time);
            List<Client> clientsForOrder = clientService.findAllSuitable(order.getOrder_date_time());
            order.setId_client(clientsForOrder.get(r.nextInt(clientsForOrder.size())));
            order.setId_tour(tourService.findAll().get(r.nextInt(tourService.count())));
            order.setDeparture_date(DataGeneration
                    .generateDateBetween(order_date_time.toLocalDate().plusDays(1),
                    order_date_time.toLocalDate().plusMonths(1)).toLocalDate());
            order.setNumber_of_nights(DataGeneration.generateNumber(1, 30, r));
            List<TourStaff> managers = tourStaffService.findAllManagers();
            order.setId_tour_staff(managers.get(r.nextInt(managers.size())));
            orderService.createOrder(order);
        }
    }

    public void generateTourAddService(TourService tourService, AddServiceService addServiceService,
                                       TourAddServiceService tourAddServiceService) {
        for (int i = 0; i < this.tourAddServiceNumber; i++) {
            TourAddService tourAddService = new TourAddService();
            tourAddService.setId_tour(tourService.findAll().get(r.nextInt(tourService.count())));
            tourAddService.setId_add_service(addServiceService.findAll()
                    .get(r.nextInt(addServiceService.count())));
            tourAddServiceService.createTourAddService(tourAddService);
        }
    }

    public void generateTourists(TouristsService touristsService, OrderService orderService,
                                       PersonInfoService personInfoService) {
        for (int i = 0; i < this.touristsNumber; i++) {
            Tourists tourists = new Tourists();
            tourists.setId_order(orderService.findAll().get(r.nextInt(orderService.count())));
            int numberOfAdults = tourists.getId_order().getId_tour().getNum_of_adults();
            int numberOfChildren = tourists.getId_order().getId_tour().getNum_of_children();
            int numberOfOrderTourists = numberOfAdults + numberOfChildren;
            while (touristsService.findAllForOrder(tourists.getId_order().getId()).size() == numberOfOrderTourists){
                tourists.setId_order(orderService.findAll().get(r.nextInt(orderService.count())));
                numberOfAdults = tourists.getId_order().getId_tour().getNum_of_adults();
                numberOfChildren = tourists.getId_order().getId_tour().getNum_of_children();
                numberOfOrderTourists = numberOfAdults + numberOfChildren;
            }
            int actualAmountOfAdults = 0;
            int actualAmountOfChildren = 0;
            for (Tourists t : touristsService.findAllForOrder(tourists.getId_order().getId())){
                LocalDate dob = t.getId_person_info().getDob();
                int age = Period.between(dob, LocalDate.now()).getYears();
                if (age >= 18) {
                    actualAmountOfAdults++;
                } else {
                    actualAmountOfChildren++;
                }
            }
            if (actualAmountOfAdults < numberOfAdults) {
                List<PersonInfo> adults = personInfoService.findAllWithIntlPassport(true);
                tourists.setId_person_info(adults.get(r.nextInt(adults.size())));
            } else if (actualAmountOfChildren < numberOfChildren){
                List<PersonInfo> children = personInfoService.findAllWithIntlPassport(false);
                tourists.setId_person_info(children.get(r.nextInt(children.size())));
            }
            touristsService.createTourists(tourists);
        }
    }

    public void generateChoosenService(OrderService orderService, TourAddServiceService tourAddServiceService,
                                 ChoosenServiceService choosenServiceService, AddServiceService addServiceService) {
        for (int i = 0; i < this.choosenServiceNumber; i++) {
            ChoosenService choosenService = new ChoosenService();
            choosenService.setId_order(orderService.findAll().get(r.nextInt(orderService.count())));
            Long orderId = choosenService.getId_order().getId();
            int numberOfAdults = choosenService.getId_order().getId_tour().getNum_of_adults();
            int numberOfChildren = choosenService.getId_order().getId_tour().getNum_of_children();
            int numberOfOrderTourists = numberOfAdults + numberOfChildren;
            List<Long> availableForOrder = tourAddServiceService
                    .findAddServiceForTour(orderService.findById(orderId).getId_tour().getId());
            if (availableForOrder.size() != 0) {
                choosenService.setId_add_service(addServiceService
                        .findById(availableForOrder.get(r.nextInt(availableForOrder.size()))));
                choosenService.setAmount(DataGeneration.generateNumber(1, numberOfOrderTourists, r));
                choosenServiceService.createChoosenService(choosenService);
            }
        }
    }

    public void generateInsuranceOption(InsuranceService insuranceService, InsuranceTypeService insuranceTypeService,
                                        InsuranceOptionService insuranceOptionService) {
        for (int i = 0; i < this.insuranceOptionNumber; i++) {
            InsuranceOption insuranceOption = new InsuranceOption();
            insuranceOption.setId_insurance(insuranceService.findAll().get(r.nextInt(insuranceService.count())));
            insuranceOption.setId_insurance_type(insuranceTypeService.findAll()
                    .get(r.nextInt(insuranceTypeService.count())));
            insuranceOption.setSum_insured(DataGeneration.generateMoney(1000, 200000, r));
            insuranceOptionService.createInsuranceOption(insuranceOption);
        }
    }

    public void generatePersonInsurance(InsuranceService insuranceService, TouristsService touristsService,
                                        PersonInsuranceService personInsuranceService) {
        for (int i = 0; i < this.personInsuranceNumber; i++) {
            PersonInsurance personInsurance = new PersonInsurance();
            personInsurance.setId_insurance(insuranceService.findAll().get(r.nextInt(insuranceService.count())));
            personInsurance.setTourists(touristsService.findAll().get(r.nextInt(touristsService.count())));
            personInsurance.setPolicy_num(DataGeneration.generatePolicyNumber(r));
            personInsuranceService.createPersonInsurance(personInsurance);
        }
    }

    public void generateInsuranceCase(PersonInsuranceService personInsuranceService,
                                      InsuranceOptionService insuranceOptionService,
                                      InsuranceCaseService insuranceCaseService) {
        for (int i = 0; i < this.insuranceCaseNumber; i++) {
            InsuranceCase insuranceCase = new InsuranceCase();
            insuranceCase.setId_person_insurance(personInsuranceService.findAll()
                    .get(r.nextInt(personInsuranceService.count())));
            Long insuranceId = insuranceCase.getId_person_insurance().getId_insurance().getId();
            Map<InsuranceType, BigDecimal> insuranceTypesAndCosts = insuranceOptionService
                    .findInsuranceTypesAndCostsForInsurance(insuranceId);
            Set<InsuranceType> insuranceTypeSet = insuranceTypesAndCosts.keySet();
            int item = r.nextInt(insuranceTypeSet.size());
            int j = 0;
            InsuranceType pickedInsuranceType = new InsuranceType();
            for(InsuranceType it : insuranceTypeSet) {
                if (j == item) {
                    pickedInsuranceType = it;
                }
                j++;
            }
            insuranceCase.setId_insurance_type(pickedInsuranceType);
            insuranceCase.setDescription(DataGeneration.generateText(10, false, false, r));
            insuranceCase.setPayout(DataGeneration.generateMoney(100,
                    insuranceTypesAndCosts.get(pickedInsuranceType).intValue(), r));
            insuranceCaseService.createInsuranceCase(insuranceCase);
        }
    }


}
