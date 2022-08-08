package com.montaigne.montaigneapp.data.spt.project;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.ProjectSpt;

import java.util.List;

public interface ProjectsptDataSource {
    List<ProjectSpt> getProjects();

    void refreshProjects();

    ProjectSpt getProject(String id);

    ProjectSpt refreshProject(String id);

    void saveProject(ProjectSpt poll);

    void deleteProject(String id);
}
