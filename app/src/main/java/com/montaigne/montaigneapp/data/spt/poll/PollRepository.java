package com.montaigne.montaigneapp.data.spt.poll;

import com.montaigne.montaigneapp.data.spt.FuroSpt;

import java.util.List;

public interface PollRepository {
    List<FuroSpt> getPolls();

    void refreshPolls();

    void refreshPoll(String id);

    void savePoll(FuroSpt poll);

    void deletePoll(FuroSpt poll);

    void updatePoll(FuroSpt poll);

    void completePoll(FuroSpt poll);

    void completePoll(String id);

    void activatePoll(FuroSpt poll);

    void activatePoll(String id);
}
