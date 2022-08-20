package com.montaigne.montaigneapp.data.spt.poll;

import com.montaigne.montaigneapp.data.spt.Furo;

import java.util.List;

public class DefaultPollRepository implements PollRepository {
    private PollDataSource pollLocalDataSource;
    private PollDataSource pollRemoteDataSource;

    public DefaultPollRepository(PollDataSource pollLocalDataSource, PollDataSource pollRemoteDataSource) {
        this.pollLocalDataSource = pollLocalDataSource;
        this.pollRemoteDataSource = pollRemoteDataSource;
    }

    @Override
    public List<Furo> getPolls() {
        return null;
    }

    @Override
    public void refreshPolls() {

    }

    @Override
    public void refreshPoll(String id) {

    }

    @Override
    public void savePoll(Furo poll) {

    }

    @Override
    public void deletePoll(Furo poll) {

    }

    @Override
    public void updatePoll(Furo poll) {

    }

    @Override
    public void completePoll(Furo poll) {

    }

    @Override
    public void completePoll(String id) {

    }

    @Override
    public void activatePoll(Furo poll) {

    }

    @Override
    public void activatePoll(String id) {

    }
}
