package com.montaigne.montaigneapp.data.spt.poll;

import com.montaigne.montaigneapp.data.spt.Furo;

import java.util.List;

public interface PollRepository {
    List<Furo> getPolls();

    void refreshPolls();

    void refreshPoll(String id);

    void savePoll(Furo poll);

    void deletePoll(Furo poll);

    void updatePoll(Furo poll);

    void completePoll(Furo poll);

    void completePoll(String id);

    void activatePoll(Furo poll);

    void activatePoll(String id);
}
