package com.montaigne.montaigneapp.data.spt.poll.remote;

import com.montaigne.montaigneapp.data.spt.Furo;
import com.montaigne.montaigneapp.data.spt.poll.PollDataSource;

import java.util.List;

public class PollRemoteDataSource implements PollDataSource {
    @Override
    public List<Furo> getPolls() {
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
    public void savePoll(Furo poll) {

    }

    @Override
    public void deletePoll(String id) {

    }
}
