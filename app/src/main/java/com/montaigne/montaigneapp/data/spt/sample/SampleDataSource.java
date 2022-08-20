package com.montaigne.montaigneapp.data.spt.sample;

import com.montaigne.montaigneapp.data.spt.AmostraSpt;

import java.util.List;

public interface SampleDataSource {
    List<AmostraSpt> getProjects();

    void refreshProjects();

    void getProject(String id);

    void refreshProject(String id);

    void saveProject(AmostraSpt poll);

    void deleteProject(String id);
}
