package com.montaigne.montaigneapp.data.spt.poll;

import com.montaigne.montaigneapp.data.Project;
import com.montaigne.montaigneapp.data.spt.PollSpt;

import java.util.List;

public interface PollDataSource {
    List<PollSpt> getPolls();

    void refreshPolls();

    void getPoll(String id);

    void refreshPoll(String id);

    void savePoll(PollSpt poll);

    void deletePoll(String id);
}
