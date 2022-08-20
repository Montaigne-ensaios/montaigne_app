package com.montaigne.montaigneapp.data.spt;

import com.montaigne.montaigneapp.data.Coordinate;
import com.montaigne.montaigneapp.data.Project;

import java.util.List;

public class ProjetoSpt extends Project {

    private int holeNumber;
    private List<FuroSpt> polls;

    public ProjetoSpt() {}

    public ProjetoSpt(Long id, String name, String client, String company, String technician,
                      String phoneNumber, String starData, Coordinate coordinate, int holeNumber,
                      List<FuroSpt> samples) {

        super(id, name, client, company, technician, phoneNumber, starData, coordinate);
        this.holeNumber = holeNumber;
        this.polls = samples;
    }

    public int getHoleNumber() {
        return holeNumber;
    }

    public void setHoleNumber(int holeNumber) {
        this.holeNumber = holeNumber;
    }

    public List<FuroSpt> getPolls() {
        return polls;
    }

    public void setPolls(List<FuroSpt> polls) {
        this.polls = polls;
    }
}
