package peaksoft.repository;

import peaksoft.models.Programmer;
import peaksoft.models.Project;

public interface ProjectRepository {
    // SAVE PROGRAMMER TO PROJECT

    String savePrToPt(Programmer programmer, Project project);

    // GET EXPENSIVE PROJECT
    Project getExpensiveProject();

    // GET NAME AND TIME FAST ENDED PROJECT

    Project getFastEndedProject();
}
