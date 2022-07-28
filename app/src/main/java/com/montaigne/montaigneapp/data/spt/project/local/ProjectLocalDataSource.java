package com.montaigne.montaigneapp.data.spt.project.local;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.ProjectSpt;
import com.montaigne.montaigneapp.data.spt.poll.PollDataSource;
import com.montaigne.montaigneapp.data.spt.project.ProjectDataSource;
import com.orm.SugarRecord;

import java.util.List;

public class ProjectLocalDataSource  implements ProjectDataSource {
    @Override
    public List<ProjectSpt> getProjects() {
        return null;
    }

    @Override
    public void refreshProjects() {

    }

    @Override
    public void getProject(String id) {

        /*ProjectSpt projectSpt =
                SugarRecord.findById(ProjectSpt.class,);*/


    }

    @Override
    public void refreshProject(String id) {

    }

    @Override
    public void saveProject(ProjectSpt poll) {

        //poll.save();
        }

    @Override
    public void deleteProject(String id) {}
}
