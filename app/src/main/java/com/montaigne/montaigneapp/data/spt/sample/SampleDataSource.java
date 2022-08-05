package com.montaigne.montaigneapp.data.spt.sample;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.SampleSpt;

import java.util.List;

public interface SampleDataSource {
    List<SampleSpt> getProjects();

    void refreshProjects();

    void getProject(String id);

    void refreshProject(String id);

    void saveProject(SampleSpt poll);

    void deleteProject(String id);
}
