package com.montaigne.montaigneapp.data.spt.sample.local;

import com.montaigne.montaigneapp.data.spt.AmostraSpt;
import com.montaigne.montaigneapp.data.spt.sample.SampleDataSource;

import java.util.List;

public class SampleLocalDataSource implements SampleDataSource {
    @Override
    public List<AmostraSpt> getProjects() {
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
    public void saveProject(AmostraSpt poll) {

    }

    @Override
    public void deleteProject(String id) {

    }
}
