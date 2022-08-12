package com.montaigne.montaigneapp.data.spt.sample.local;

import com.montaigne.montaigneapp.data.spt.SampleSpt;
import com.montaigne.montaigneapp.data.spt.sample.SampleDataSource;

import java.util.List;

public class SampleLocalDataSource implements SampleDataSource {
    @Override
    public List<SampleSpt> getProjects() {
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
    public void saveProject(SampleSpt poll) {

    }

    @Override
    public void deleteProject(String id) {

    }
}
