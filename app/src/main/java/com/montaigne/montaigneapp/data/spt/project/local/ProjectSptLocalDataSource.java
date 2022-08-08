package com.montaigne.montaigneapp.data.spt.project.local;

import com.montaigne.montaigneapp.data.spt.ProjectSpt;
import com.montaigne.montaigneapp.data.spt.project.ProjectsptDataSource;
import com.orm.SugarRecord;

import java.util.List;

public class ProjectSptLocalDataSource extends SugarRecord<ProjectSpt> implements ProjectsptDataSource {
    @Override
    public List<ProjectSpt> getProjects() {

        List<ProjectSpt> projectSpts = ProjectSpt.listAll(ProjectSpt.class);
        return projectSpts;

    }

    @Override
    public void refreshProjects() {}

    @Override
    public ProjectSpt getProject(String id) {

        ProjectSpt poll = ProjectSpt.
                findById(ProjectSpt.class,Long.parseLong(id));
        return poll;

    }

    @Override
    public ProjectSpt refreshProject(String id) {

        ProjectSpt poll = ProjectSpt.
                findById(ProjectSpt.class,Long.parseLong(id));
        return poll;

    }

    @Override
    public void saveProject(ProjectSpt poll) {

       poll.save();

        }

    @Override
    public void deleteProject(String id) {

        ProjectSpt poll = ProjectSpt.
                findById(ProjectSpt.class,Long.parseLong(id));
        poll.delete();

    }
}
