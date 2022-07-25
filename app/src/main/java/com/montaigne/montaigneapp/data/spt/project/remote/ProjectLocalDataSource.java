package com.montaigne.montaigneapp.data.spt.project.remote;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.poll.PollDataSource;
import com.montaigne.montaigneapp.data.spt.project.ProjectDataSource;

import java.util.List;

public class ProjectLocalDataSource implements ProjectDataSource {
    @Override
    public List<Project> getProjects() {
        return null;
    }

    @Override
    public void refreshProjects() {

    }

    @Override
    public void getProject(String id) {

    }

    @Override
    public void refreshProject(String id) {

    }

    @Override
    public void saveProject(Project poll) {

    }

    @Override
    public void deleteProject(String id) {

    }
}
