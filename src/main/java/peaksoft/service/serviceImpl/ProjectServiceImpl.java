package peaksoft.service.serviceImpl;

import peaksoft.models.Programmer;
import peaksoft.models.Project;
import peaksoft.repository.ProjectRepository;
import peaksoft.repository.repositoryImpl.ProjectRepositoryImpl;
import peaksoft.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository = new ProjectRepositoryImpl();
    @Override
    public String savePrToPt(Programmer programmer, Project project) {
        return projectRepository.savePrToPt(programmer,project);
    }

    @Override
    public Project getExpensiveProject() {
        return projectRepository.getExpensiveProject();
    }

    @Override
    public Project getFastEndedProject() {
        return projectRepository.getFastEndedProject();
    }
}
