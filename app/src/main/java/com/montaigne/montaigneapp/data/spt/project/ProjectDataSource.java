package com.montaigne.montaigneapp.data.spt.project;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.ProjectSpt;

import java.util.List;

public interface ProjectDataSource {
    List<ProjectSpt> getProjects();

    void refreshProjects();

    void getProject(String id);

    void refreshProject(String id);

    void saveProject(ProjectSpt poll);

    void deleteProject(String id);
}
