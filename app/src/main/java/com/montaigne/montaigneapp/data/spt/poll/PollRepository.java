package com.montaigne.montaigneapp.data.spt.poll;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.PollSpt;

import java.util.List;

public interface PollRepository {
    List<PollSpt> getPolls();

    void refreshPolls();

    void refreshPoll(String id);

    void savePoll(PollSpt poll);

    void deletePoll(PollSpt poll);

    void updatePoll(PollSpt poll);

    void completePoll(PollSpt poll);

    void completePoll(String id);

    void activatePoll(PollSpt poll);

    void activatePoll(String id);
}
