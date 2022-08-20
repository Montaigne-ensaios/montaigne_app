package com.montaigne.montaigneapp.data.spt.project;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.ProjetoSpt;

import java.util.List;

public interface ProjectRepository {
    List<ProjetoSpt> getProjects();

    List<ProjetoSpt> getProjectStream();

    void refreshProjects();

    void refreshProject(String id);

    void saveProject(ProjetoSpt poll);

    void deleteProject(ProjetoSpt poll);

    void updateProject(ProjetoSpt poll);

    void completeProject(ProjetoSpt project);

    void completeProject(String id);

    void activiteProject(Project project);

    void activiteProject(String id);
}
