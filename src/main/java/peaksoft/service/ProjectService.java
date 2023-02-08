package peaksoft.service;

import peaksoft.models.Programmer;
import peaksoft.models.Project;

public interface ProjectService {
    String savePrToPt(Programmer programmer, Project project);

    Project getExpensiveProject();

    Project getFastEndedProject();
}