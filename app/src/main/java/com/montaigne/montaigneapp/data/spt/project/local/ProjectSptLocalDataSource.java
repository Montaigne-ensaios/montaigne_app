package com.montaigne.montaigneapp.data.spt.project.local;

import com.montaigne.montaigneapp.data.spt.ProjetoSpt;
import com.montaigne.montaigneapp.data.spt.project.ProjectsptDataSource;
import com.orm.SugarRecord;

import java.util.List;

public class ProjectSptLocalDataSource extends SugarRecord<ProjetoSpt> implements ProjectsptDataSource {
    @Override
    public List<ProjetoSpt> getProjects() {

        List<ProjetoSpt> projectSpts = ProjetoSpt.listAll(ProjetoSpt.class);
        return projectSpts;

    }

    @Override
    public void refreshProjects() {}

    @Override
    public ProjetoSpt getProject(String id) {

        ProjetoSpt poll = ProjetoSpt.
                findById(ProjetoSpt.class,Long.parseLong(id));
        return poll;

    }

    @Override
    public ProjetoSpt refreshProject(String id) {

        ProjetoSpt poll = ProjetoSpt.
                findById(ProjetoSpt.class,Long.parseLong(id));
        return poll;

    }

    @Override
    public void saveProject(ProjetoSpt poll) {

       poll.save();

        }

    @Override
    public void deleteProject(String id) {

        ProjetoSpt poll = ProjetoSpt.
                findById(ProjetoSpt.class,Long.parseLong(id));
        poll.delete();

    }
}
