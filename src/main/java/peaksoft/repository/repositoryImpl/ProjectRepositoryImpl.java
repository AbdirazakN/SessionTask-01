package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HiberConfig;
import peaksoft.models.Programmer;
import peaksoft.models.Project;
import peaksoft.repository.ProjectRepository;

import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {
    private EntityManager entityManager = HiberConfig.getEntityManager();
    @Override
    public String savePrToPt(Programmer programmer, Project project) {
        entityManager.getTransaction().begin();
        entityManager.merge(programmer).setProjects(List.of(project));
        entityManager.getTransaction().commit();
        entityManager.close();
        return programmer.getFullName()+" saved to "+project.getProjectName();
    }

    @Override
    public Project getExpensiveProject() {
        entityManager.getTransaction().begin();
        Project singleResult = (Project) entityManager.createQuery("from Project where price=(select max(price) from Project)").getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public Project getFastEndedProject() {
        entityManager.getTransaction().begin();
        Project singleResult = (Project) entityManager.createQuery("from Project where price=(select max(price) from Project)").getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }
}
