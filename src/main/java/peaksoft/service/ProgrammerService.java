package peaksoft.service;

import peaksoft.models.Country;
import peaksoft.models.Programmer;
import peaksoft.models.exceptions.BadrequestException;

import java.util.List;

public interface ProgrammerService {
    String saveProgrammer(Programmer programmer) throws BadrequestException;

    String saveMoreProgrammers(List<Programmer> programmers);

    List<Programmer> getAllProgrammers();

    Programmer findById(Long id);

    Programmer removeById(Long id);

    String removeAllProgrammers();

    Programmer update(Long id, Programmer programmer);

    List<Programmer> findProgrammersByCountry(String country);

    Programmer findYoungProgrammer();

    Programmer findOldProgrammer();

}
