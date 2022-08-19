package com.montaigne.montaigneapp.data.spt.project.remote;

import com.google.firebase.database.DatabaseReference;
import com.montaigne.montaigneapp.data.spt.ProjectSpt;
import com.montaigne.montaigneapp.data.spt.project.ProjectsptDataSource;

import java.util.List;

public class ProjectSptRemoteDataSource implements ProjectsptDataSource {


    @Override
    public List<ProjectSpt> getProjects() {return null;}

    @Override
    public void refreshProjects() {

    }

    @Override
    public ProjectSpt getProject(String id) {
        return null;
    }

    @Override
    public ProjectSpt refreshProject(String id) {
        return null;
    }

    @Override
    public void saveProject(ProjectSpt poll) {

    }

    @Override
    public void deleteProject(String id) {

    }
}
