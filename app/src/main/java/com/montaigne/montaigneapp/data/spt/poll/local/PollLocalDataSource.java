package com.montaigne.montaigneapp.data.spt.poll.local;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.PollSpt;
import com.montaigne.montaigneapp.data.spt.poll.PollDataSource;

import java.util.List;

public class PollLocalDataSource implements PollDataSource {

    @Override
    public List<PollSpt> getPolls() {
        return null;
    }

    @Override
    public void refreshPolls() {

    }

    @Override
    public void getPoll(String id) {

    }

    @Override
    public void refreshPoll(String id) {

    }

    @Override
    public void savePoll(PollSpt poll) {

    }

    @Override
    public void deletePoll(String id) {

    }
}
