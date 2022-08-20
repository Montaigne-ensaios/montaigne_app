package com.montaigne.montaigneapp.data.spt.sample;

import com.montaigne.montaigneapp.data.spt.AmostraSpt;

import java.util.List;

public interface SampleRepository {
    List<AmostraSpt> getProjects();

    void refreshProjects();

    void refreshProject(String id);

    void saveProject(AmostraSpt poll);

    void deleteProject(AmostraSpt poll);

    void updateProject(AmostraSpt poll);
}
