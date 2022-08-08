package com.montaigne.montaigneapp.data.spt.project;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.ProjectSpt;

import java.nio.file.Files;
import java.util.List;

public interface ProjectRepository {
    List<ProjectSpt> getProjects();

    List<ProjectSpt> getProjectStream();

    void refreshProjects();

    void refreshProject(String id);

    void saveProject(ProjectSpt poll);

    void deleteProject(ProjectSpt poll);

    void updateProject(ProjectSpt poll);

    void completeProject(ProjectSpt project);

    void completeProject(String id);

    void activiteProject(Project project);

    void activiteProject(String id);
}
