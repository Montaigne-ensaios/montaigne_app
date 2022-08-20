package com.montaigne.montaigneapp.data.spt.project.remote;

import com.montaigne.montaigneapp.data.spt.ProjetoSpt;
import com.montaigne.montaigneapp.data.spt.project.ProjectsptDataSource;

import java.util.List;

public class ProjectSptRemoteDataSource implements ProjectsptDataSource {


    @Override
    public List<ProjetoSpt> getProjects() {return null;}

    @Override
    public void refreshProjects() {

    }

    @Override
    public ProjetoSpt getProject(String id) {
        return null;
    }

    @Override
    public ProjetoSpt refreshProject(String id) {
        return null;
    }

    @Override
    public void saveProject(ProjetoSpt poll) {

    }

    @Override
    public void deleteProject(String id) {

    }
}
