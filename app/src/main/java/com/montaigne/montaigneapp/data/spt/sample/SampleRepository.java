package com.montaigne.montaigneapp.data.spt.sample;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.SampleSpt;

import java.util.List;

public interface SampleRepository {
    List<SampleSpt> getProjects();

    void refreshProjects();

    void refreshProject(String id);

    void saveProject(SampleSpt poll);

    void deleteProject(SampleSpt poll);

    void updateProject(SampleSpt poll);
}
