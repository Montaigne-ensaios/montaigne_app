package com.montaigne.montaigneapp.data.spt.poll;

import com.montaigne.montaigneapp.data.spt.FuroSpt;

import java.util.List;

public interface PollDataSource {
    List<FuroSpt> getPolls();

    void refreshPolls();

    void getPoll(String id);

    void refreshPoll(String id);

    void savePoll(FuroSpt poll);

    void deletePoll(String id);
}
