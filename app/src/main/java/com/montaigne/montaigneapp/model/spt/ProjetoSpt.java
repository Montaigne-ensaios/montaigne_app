package com.montaigne.montaigneapp.model.spt;

import com.montaigne.montaigneapp.model.Coordinate;
import com.montaigne.montaigneapp.model.Projeto;
import com.montaigne.montaigneapp.model.spt.FuroSpt;

import java.util.List;

public class ProjetoSpt extends Projeto {

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
