package peaksoft.service.serviceImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HiberConfig;
import peaksoft.models.Country;
import peaksoft.models.Programmer;
import peaksoft.models.exceptions.BadrequestException;
import peaksoft.repository.ProgrammerRepository;
import peaksoft.repository.repositoryImpl.ProgrammerRepositoryImpl;
import peaksoft.service.ProgrammerService;

import java.time.LocalDate;
import java.util.List;

public class ProgrammerServiceImpl implements ProgrammerService {
    private ProgrammerRepository programmerRepository = new ProgrammerRepositoryImpl();
    @Override
    public String saveProgrammer(Programmer programmer) throws BadrequestException {
        EntityManager entityManager = HiberConfig.getEntityManager();
        List<Programmer> fromProgrammer = entityManager.createQuery("from Programmer").getResultList();
        for (Programmer pro : fromProgrammer) {
            if (!programmer.getEmail().toLowerCase().equals(pro.getEmail().toLowerCase()) && programmer.getDateOfBirth().isAfter(LocalDate.now())){
                System.out.println(programmerRepository.saveProgrammer(programmer));
            }else {
                throw new BadrequestException("E-mail already exist...");
            }
        }

        return "Save method...";
    }

    @Override
    public String saveMoreProgrammers(List<Programmer> programmers) {
        return programmerRepository.saveMoreProgrammers(programmers);
    }

    @Override
    public List<Programmer> getAllProgrammers() {
        return programmerRepository.getAllProgrammers();
    }

    @Override
    public Programmer findById(Long id) {
        return programmerRepository.findById(id);
    }

    @Override
    public Programmer removeById(Long id) {
        return programmerRepository.removeById(id);
    }

    @Override
    public String removeAllProgrammers() {
        return programmerRepository.removeAllProgrammers();
    }

    @Override
    public Programmer update(Long id, Programmer programmer) {
        return programmerRepository.update(id,programmer);
    }

    @Override
    public List<Programmer> findProgrammersByCountry(String country) {
        return programmerRepository.findProgrammersByCountry(country);
    }

    @Override
    public Programmer findYoungProgrammer() {
        return programmerRepository.findYoungProgrammer();
    }

    @Override
    public Programmer findOldProgrammer() {
        return programmerRepository.findOldProgrammer();
    }
}
