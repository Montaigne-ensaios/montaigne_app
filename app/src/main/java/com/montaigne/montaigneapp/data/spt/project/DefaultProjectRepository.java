package com.montaigne.montaigneapp.data.spt.project;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.ProjectSpt;
import com.montaigne.montaigneapp.data.spt.poll.PollDataSource;
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
    public List<ProjectSpt> getProjects() {
        return null;
    }

    @Override
    public List<ProjectSpt> getProjectStream() {

        return projectSptLocalDataSource.getProjects();

    }

    @Override
    public void refreshProjects() {

    }

    @Override
    public void refreshProject(String id) {

    }

    @Override
    public void saveProject(ProjectSpt poll) {

        try{

            projectSptLocalDataSource.saveProject((ProjectSpt) poll);
            projectSptRemoteDataSource.saveProject((ProjectSpt) poll);

        }catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProject(ProjectSpt poll) {

        try {

            projectSptRemoteDataSource.deleteProject(poll.getId().toString());
            projectSptLocalDataSource.deleteProject(poll.getId().toString());

        }catch (RuntimeException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void updateProject(ProjectSpt poll) {

       projectSptLocalDataSource.refreshProjects();


    }

    @Override
    public void completeProject(ProjectSpt project) {
        
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
