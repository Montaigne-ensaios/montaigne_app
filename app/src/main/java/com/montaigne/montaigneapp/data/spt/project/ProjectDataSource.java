package com.montaigne.montaigneapp.data.spt.project;

import com.montaigne.montaigneapp.data.Project;

import java.util.List;

public interface ProjectDataSource {
    List<Project> getProjects();

    void refreshProjects();

    void getProject(String id);

    void refreshProject(String id);

    void saveProject(Project poll);

    void deleteProject(String id);
}
