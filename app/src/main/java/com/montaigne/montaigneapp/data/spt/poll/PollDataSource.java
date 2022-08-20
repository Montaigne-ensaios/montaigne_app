package com.montaigne.montaigneapp.data.spt.poll;

import com.montaigne.montaigneapp.data.spt.Furo;

import java.util.List;

public interface PollDataSource {
    List<Furo> getPolls();

    void refreshPolls();

    void getPoll(String id);

    void refreshPoll(String id);

    void savePoll(Furo poll);

    void deletePoll(String id);
}
