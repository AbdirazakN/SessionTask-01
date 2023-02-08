package peaksoft;

import peaksoft.models.Address;
import peaksoft.models.Country;
import peaksoft.models.Programmer;
import peaksoft.models.Project;
import peaksoft.models.enums.Status;
import peaksoft.models.exceptions.BadrequestException;
import peaksoft.service.AddressService;
import peaksoft.service.CountryService;
import peaksoft.service.ProgrammerService;
import peaksoft.service.ProjectService;
import peaksoft.service.serviceImpl.AddressServiceImpl;
import peaksoft.service.serviceImpl.CountryServiceImpl;
import peaksoft.service.serviceImpl.ProgrammerServiceImpl;
import peaksoft.service.serviceImpl.ProjectServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws BadrequestException {

        /**
         * Country->
         * бир мамлекетти сактоочу метод.
         * коп мамлекеттерди сактоочу метод.
         * баарын алуучу метод.
         * id си менен табуучу метод.
         * id си менен очуруучу метод.
         * баардык мамлекеттерди очуруп салуучу метод.
         * update();
         * description ны эн узун жазылган мамлекетти табуучу метод.
         * бир мамлекетти жазсак ал мамлекеттен канчоо экенин санын чыгарышы керек.
         * Address->
         * бир адрессти сактоочу метод.
         * коп адрессти сактоочу метод.
         * эскертуу -биз адрессти сактап жатканда мамлекетин кошо берип кетишибиз керек.
         * баарын алуучу метод.
         * id си менен табуучу метод.
         * id си менен очуруучу метод.
         * баардык адрессти очуруп салуучу метод.
         * update();
         * Programmer->
         * бир программистти сактоочу метод.
         * коп программистти сактоочу метод.
         * эскертуу -биз программистти сактап жатканда адресин кошо берип кетишибиз керек жана
         * программисттин email лы уникалный болсун бирок аны сиздер @Column(unique) колдонбонуздар жана
         *  туулган жылына келе элек убакытты берсениз озунуз тузгон BadrequestExceptionнун ыргытсын
         * баарын алуучу метод.
         * id си менен табуучу метод.
         * id си менен очуруучу метод.
         * баардык программистти очуруп салуучу метод.
         * update();
         * мамлекетин жазсак ошол мамлекеттен болгон баардык программисттер чыксын.
         * эн жаш программистти жашын жана атын консолго чыгарыныз.
         * эн жашы чон программистти жашын жана атын консолго чыгарыныз.
         * Project->
         * бир проекти сактоочу метод.
         * коп проекти сактоочу метод.
         * баарын алуучу метод.
         * id си менен табуучу метод.
         * id си менен очуруучу метод.
         * баардык проекти очуруп салуучу метод.
         * update();
         * бир проектке програмистерди кошуучу метод болсун бирок бир проектте бир гана овнер болсун
         * эн кымбат проекти чыгарып бериниз
         * эн кыска убакытта жазылган проекти атын жана канча убакытта жазылганын чыгарып бериниз
         */

        // Constructors
        Address address1 = new Address("Batken", "Kelechek", 11, new Country(), new Programmer());
        Address address2 = new Address("Bishkek", "Chuy", 19, new Country(), new Programmer());
        Address address3 = new Address("Osh", "K.Datka", 45, new Country(), new Programmer());

        Country country1 = new Country("Kyrgyzstan", "Tooluu olko", List.of(new Address()));
        Country country2 = new Country("Uzbekistan", "Meimandos olko", List.of(new Address()));
        Country country3 = new Country("Russia", "En chon mamleket", List.of(new Address()));

        Programmer programmer1 = new Programmer("Akylbek Nursultan uulu", "akylbek@mail.ru",
                LocalDate.of(2005, 2, 12), Status.MIDDLE, new Address(), List.of(new Project()));
        Programmer programmer2 = new Programmer("Azamat Ismailov", "azamat@mail.ru",
                LocalDate.of(2002, 1, 22), Status.SENIOR, new Address(), List.of(new Project()));
        Programmer programmer3 = new Programmer("Kanykei Asan kyzy", "kanykei@mail.ru",
                LocalDate.of(2000, 12, 12), Status.MIDDLE, new Address(), List.of(new Project()));

        Project project1 = new Project("Book Site", "create web site to Book",
                LocalDate.of(2022, 2, 5), LocalDate.of(2022, 2, 8), 500, List.of(new Programmer()));
        Project project2 = new Project("Tiguu kursu", "create web site to Tiguu kursu",
                LocalDate.of(2022, 1, 5), LocalDate.of(2022, 1, 10), 300, List.of(new Programmer()));
        Project project3 = new Project("LMS platform", "create web site and database to LMS",
                LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 20), 800, List.of(new Programmer()));

        List<Address> addresses = new ArrayList<>(List.of(address1,address2));
        List<Project> projects = new ArrayList<>(List.of(project1,project2));
        List<Programmer> programmers = new ArrayList<>(List.of(programmer1,programmer2));
        List<Country> countries = new ArrayList<>(List.of(country1,country2));

        address1.setCountry(country1);
        address1.setProgrammer(programmer1);
        address2.setCountry(country2);
        address2.setProgrammer(programmer2);

        country1.setAddresses(addresses);
        country2.setAddresses(addresses);

        programmer1.setLocation(address1);
        programmer1.setProjects(projects);
        programmer2.setLocation(address2);
        programmer2.setProjects(projects);

        project1.setProgrammers(programmers);
        project2.setProgrammers(programmers);
        // Constructors


        // Objects
        AddressService addressService = new AddressServiceImpl();
        CountryService countryService = new CountryServiceImpl();
        ProgrammerService programmerService = new ProgrammerServiceImpl();
        ProjectService projectService = new ProjectServiceImpl();
        // Objects

        while (true) {
            System.out.println("""
                    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< WELCOME >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                                                                   |1|---> ADDRESS
                                                                   |2|---> PROGRAMMER
                                                                   |3|---> PROJECT
                                                                   |4|---> COUNTRY
                                                                   |0|---> EXIT
                                                                   """);
            int mainCommand = new Scanner(System.in).nextInt();
            if (mainCommand == 0) break;
            if (mainCommand == 1) {
                while (true) {
                    System.out.println("""
                            <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ADDRESS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                                                                       |1|---> SAVE ADDRESS
                                                                       |2|---> SAVE ALL ADDRESSES
                                                                       |3|---> GET ALL ADDRESS
                                                                       |4|---> FIND BY ID
                                                                       |5|---> REMOVE BY ID
                                                                       |6|---> REMOVE ALL ADDRESS
                                                                       |7|---> UPDATE
                                                                       |0|---> EXIT
                                                                       """);
                    int command = new Scanner(System.in).nextInt();
                    if (command == 0) break;
                    if (command == 1) System.out.println(addressService.saveAddress(address1));
                    if (command == 2) System.out.println(addressService.saveMoreAddresses(addresses));
                    if (command == 3) System.out.println(addressService.getAllAddresses());
                    if (command == 4) System.out.println(addressService.findById(new Scanner(System.in).nextLong()));
                    if (command == 5) System.out.println(addressService.removeById(new Scanner(System.in).nextLong()));
                    if (command == 6) System.out.println(addressService.removeAllAddresses());
                    if (command == 7)
                        System.out.println(addressService.update(new Scanner(System.in).nextLong(), new Address()));
                }
            }
            if (mainCommand == 2) {
                while (true) {
                    System.out.println("""
                            <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< PROGRAMMER >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                                                                       |1|---> SAVE PROGRAMMER
                                                                       |2|---> SAVE ALL PROGRAMMERS
                                                                       |3|---> GET ALL PROGRAMMERS
                                                                       |4|---> FIND BY ID
                                                                       |5|---> REMOVE BY ID
                                                                       |6|---> REMOVE ALL PROGRAMMERS
                                                                       |7|---> UPDATE
                                                                       |8|---> FIND BY COUNTRY
                                                                       |9|---> FIND YOUNG PROGRAMMER
                                                                       |10|--> FIND OLD PROGRAMMER
                                                                       |0|---> EXIT
                                                                       """);
                    int command = new Scanner(System.in).nextInt();
                    if (command == 0) break;
                    if (command == 1) System.out.println(programmerService.saveProgrammer(programmer1));
                    if (command == 2) System.out.println(programmerService.saveMoreProgrammers(programmers));
                    if (command == 3) System.out.println(programmerService.getAllProgrammers());
                    if (command == 4) System.out.println(programmerService.findById(new Scanner(System.in).nextLong()));
                    if (command == 5)
                        System.out.println(programmerService.removeById(new Scanner(System.in).nextLong()));
                    if (command == 6) System.out.println(programmerService.removeAllProgrammers());
                    if (command == 7)
                        System.out.println(programmerService.update(new Scanner(System.in).nextLong(), programmer2));
                    if (command == 8)
                        System.out.println(programmerService.findProgrammersByCountry(new Scanner(System.in).nextLine()));
                    if (command == 9) System.out.println(programmerService.findYoungProgrammer());
                    if (command == 10) System.out.println(programmerService.findOldProgrammer());
                }
            }
            if (mainCommand == 3) {
                while (true) {
                    System.out.println("""
                            <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< PROJECT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                                                                    |1|---> SAVE PROGRAMMER TO PROJECT
                                                                    |2|---> GET EXPENSIVE PROJECT
                                                                    |3|---> GET FAST ENDED PROJECT
                                                                    |0|---> EXIT
                                                                    """);
                    int command = new Scanner(System.in).nextInt();
                    if (command == 0) break;
                    if (command == 1) System.out.println(projectService.savePrToPt(programmer3, project3));
                    if (command == 2) System.out.println(projectService.getExpensiveProject());
                    if (command == 3) System.out.println(projectService.getFastEndedProject());
                }
            }
            if (mainCommand == 4) {
                while (true) {
                    System.out.println("""
                            <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< COUNTRY >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                                                                      |1|---> SAVE COUNTRY
                                                                      |2|---> SAVE ALL COUNTRIES
                                                                      |3|---> GET ALL COUNTRIES
                                                                      |4|---> FIND BY ID
                                                                      |5|---> REMOVE BY ID
                                                                      |6|---> REMOVE ALL COUNTRIES
                                                                      |7|---> UPDATE
                                                                      |8|---> FIND LONG DESCRIPTION
                                                                      |9|---> FIND QUANTITY OF COUNTRY
                                                                      |0|---> EXIT
                                                                      """);
                    int command = new Scanner(System.in).nextInt();
                    if (command == 0) break;
                    if (command == 1) System.out.println(countryService.saveCountry(country1));
                    if (command == 2) System.out.println(countryService.saveMoreCountries(countries));
                    if (command == 3) System.out.println(countryService.getAllCountries());
                    if (command == 4) System.out.println(countryService.findById(new Scanner(System.in).nextLong()));
                    if (command == 5) System.out.println(countryService.removeById(new Scanner(System.in).nextLong()));
                    if (command == 6) System.out.println(countryService.removeAllCountries());
                    if (command == 7)
                        System.out.println(countryService.update(new Scanner(System.in).nextLong(), country3));
                    if (command == 8) System.out.println(countryService.findLongDescription());
                    if (command == 9)
                        System.out.println(countryService.findQuantityCountry(new Scanner(System.in).nextLine()));
                }
            }
        }
    }
}
