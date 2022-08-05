package com.montaigne.montaigneapp.data.spt.poll;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.PollSpt;

import java.util.List;

public class DefaultPollRepository implements PollRepository {
    private PollDataSource pollLocalDataSource;
    private PollDataSource pollRemoteDataSource;

    public DefaultPollRepository(PollDataSource pollLocalDataSource, PollDataSource pollRemoteDataSource) {
        this.pollLocalDataSource = pollLocalDataSource;
        this.pollRemoteDataSource = pollRemoteDataSource;
    }

    @Override
    public List<PollSpt> getPolls() {
        return null;
    }

    @Override
    public void refreshPolls() {

    }

    @Override
    public void refreshPoll(String id) {

    }

    @Override
    public void savePoll(PollSpt poll) {

    }

    @Override
    public void deletePoll(PollSpt poll) {

    }

    @Override
    public void updatePoll(PollSpt poll) {

    }

    @Override
    public void completePoll(PollSpt poll) {

    }

    @Override
    public void completePoll(String id) {

    }

    @Override
    public void activatePoll(PollSpt poll) {

    }

    @Override
    public void activatePoll(String id) {

    }
}
