package com.montaigne.montaigneapp.data.spt.poll;

import com.montaigne.montaigneapp.data.spt.FuroSpt;

import java.util.List;

public class DefaultPollRepository implements PollRepository {
    private PollDataSource pollLocalDataSource;
    private PollDataSource pollRemoteDataSource;

    public DefaultPollRepository(PollDataSource pollLocalDataSource, PollDataSource pollRemoteDataSource) {
        this.pollLocalDataSource = pollLocalDataSource;
        this.pollRemoteDataSource = pollRemoteDataSource;
    }

    @Override
    public List<FuroSpt> getPolls() {
        return null;
    }

    @Override
    public void refreshPolls() {

    }

    @Override
    public void refreshPoll(String id) {

    }

    @Override
    public void savePoll(FuroSpt poll) {

    }

    @Override
    public void deletePoll(FuroSpt poll) {

    }

    @Override
    public void updatePoll(FuroSpt poll) {

    }

    @Override
    public void completePoll(FuroSpt poll) {

    }

    @Override
    public void completePoll(String id) {

    }

    @Override
    public void activatePoll(FuroSpt poll) {

    }

    @Override
    public void activatePoll(String id) {

    }
}
