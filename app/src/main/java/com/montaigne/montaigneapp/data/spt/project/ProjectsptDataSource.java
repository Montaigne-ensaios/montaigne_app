package com.montaigne.montaigneapp.data.spt.project;

import com.montaigne.montaigneapp.data.spt.ProjetoSpt;

import java.util.List;

public interface ProjectsptDataSource {
    List<ProjetoSpt> getProjects();

    void refreshProjects();

    ProjetoSpt getProject(String id);

    ProjetoSpt refreshProject(String id);

    void saveProject(ProjetoSpt poll);

    void deleteProject(String id);
}
