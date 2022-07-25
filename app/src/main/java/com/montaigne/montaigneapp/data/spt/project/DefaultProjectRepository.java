package com.montaigne.montaigneapp.data.spt.project;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.poll.PollDataSource;

import java.util.List;

public class DefaultProjectRepository implements ProjectRepository {

    PollDataSource pollLocalDataSource;
    PollDataSource pollRemoteDataSource;

    public DefaultProjectRepository(PollDataSource pollLocalDataSource, PollDataSource pollRemoteDataSource) {
        this.pollLocalDataSource = pollLocalDataSource;
        this.pollRemoteDataSource = pollRemoteDataSource;
    }

    @Override
    public List<Project> getProjects() {
        return null;
    }

    @Override
    public void refreshProjects() {

    }

    @Override
    public void refreshProject(String id) {

    }

    @Override
    public void saveProject(Project poll) {

    }

    @Override
    public void deleteProject(Project poll) {

    }

    @Override
    public void updateProject(Project poll) {

    }

    @Override
    public void completeProject(Project project) {

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
