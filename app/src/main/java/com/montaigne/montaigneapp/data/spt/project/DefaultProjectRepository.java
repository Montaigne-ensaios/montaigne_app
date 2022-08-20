package com.montaigne.montaigneapp.data.spt.project;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.ProjetoSpt;
import com.montaigne.montaigneapp.data.spt.project.local.ProjectSptLocalDataSource;
import com.montaigne.montaigneapp.data.spt.project.remote.ProjectSptRemoteDataSource;

import java.util.List;

public class DefaultProjectRepository implements ProjectRepository {

    ProjectSptLocalDataSource projectSptLocalDataSource;
    ProjectSptRemoteDataSource projectSptRemoteDataSource;

    public DefaultProjectRepository(ProjectSptLocalDataSource projectSptLocalDataSource, ProjectSptRemoteDataSource projectSptRemoteDataSource) {
        this.projectSptLocalDataSource = projectSptLocalDataSource;
        this.projectSptRemoteDataSource = projectSptRemoteDataSource;
    }

    @Override
    public List<ProjetoSpt> getProjects() {
        return null;
    }

    @Override
    public List<ProjetoSpt> getProjectStream() {

        return projectSptLocalDataSource.getProjects();

    }

    @Override
    public void refreshProjects() {

    }

    @Override
    public void refreshProject(String id) {

    }

    @Override
    public void saveProject(ProjetoSpt poll) {

        try{

            projectSptLocalDataSource.saveProject((ProjetoSpt) poll);
            projectSptRemoteDataSource.saveProject((ProjetoSpt) poll);

        }catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProject(ProjetoSpt poll) {

        try {

            projectSptRemoteDataSource.deleteProject(poll.getId().toString());
            projectSptLocalDataSource.deleteProject(poll.getId().toString());

        }catch (RuntimeException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void updateProject(ProjetoSpt poll) {

       projectSptLocalDataSource.refreshProjects();


    }

    @Override
    public void completeProject(ProjetoSpt project) {
        
    }

    @Override
    public void completeProject(String id) {

    }

    @Override
    public void activiteProject(Project project) {

    }

    @Override
    public void activiteProject(String id) {

    }
}
