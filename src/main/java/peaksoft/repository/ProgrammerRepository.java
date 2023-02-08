package peaksoft.repository;

import peaksoft.models.Country;
import peaksoft.models.Programmer;

import java.util.List;

public interface ProgrammerRepository {
    // SAVE ONE PROGRAMMER
    String saveProgrammer(Programmer programmer);

    // SAVE MORE PROGRAMMER
    String saveMoreProgrammers(List<Programmer> programmers);

    // GET ALL PROGRAMMERS

    List<Programmer> getAllProgrammers();

    // FIND PROGRAMMER BY ID

    Programmer findById(Long id);

    // REMOVE PROGRAMMER BY ID

    Programmer removeById(Long id);

    // REMOVE ALL PROGRAMMERS

    String removeAllProgrammers();

    // UPDATE

    Programmer update(Long id, Programmer programmer);

    // FIND PROGRAMMERS BY COUNTRY

    List<Programmer> findProgrammersByCountry(String country);

    // FIND NAME AND AGE YOUNG PROGRAMMER

    Programmer findYoungProgrammer();

    // FIND NAME AND AGE OLD PROGRAMMER

    Programmer findOldProgrammer();

}
