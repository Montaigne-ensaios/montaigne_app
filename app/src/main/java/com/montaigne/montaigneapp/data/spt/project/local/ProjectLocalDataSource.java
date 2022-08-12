package com.montaigne.montaigneapp.data.spt.project.local;

import com.montaigne.montaigneapp.data.spt.ProjectSpt;
import com.montaigne.montaigneapp.data.spt.project.ProjectDataSource;
import com.orm.SugarRecord;

import java.util.List;

public class ProjectLocalDataSource extends SugarRecord implements ProjectDataSource {
    @Override
    public List<ProjectSpt> getProjects() {

        List<ProjectSpt> projectSpts = ProjectSpt.listAll(ProjectSpt.class);
        return projectSpts;

    }

    @Override
    public void refreshProjects() {}

    @Override
    public void getProject(String id) {

        ProjectSpt poll = ProjectSpt.
                findById(ProjectSpt.class,Long.parseLong(id));


    }

    @Override
    public void refreshProject(String id) {

        ProjectSpt poll = ProjectSpt.
                findById(ProjectSpt.class,Long.parseLong(id));

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
