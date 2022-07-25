package com.montaigne.montaigneapp.data.spt.project;

import com.montaigne.montaigneapp.data.Project;

import java.util.List;

public interface ProjectRepository {
    List<Project> getProjects();

    void refreshProjects();

    void refreshProject(String id);

    void saveProject(Project poll);

    void deleteProject(Project poll);

    void updateProject(Project poll);

    void completeProject(Project project);

    void completeProject(String id);

    void activiteProject(Project project);

    void activiteProject(String id);
}
