package com.montaigne.montaigneapp.data.spt;

import com.montaigne.montaigneapp.data.Coordinate;
import com.montaigne.montaigneapp.data.Project;

public class ProjectSpt extends Project {

   private int holeNumber;

    public ProjectSpt() {

    }

    public ProjectSpt(Long id, String name, String client, String company, String technician,
                      String phoneNumber, String starData, Coordinate coordinate, int holeNumber) {

        super(id, name, client, company, technician, phoneNumber, starData, coordinate);
        this.holeNumber = holeNumber;
    }

    public int getHoleNumber() {
        return holeNumber;
    }

    public void setHoleNumber(int holeNumber) {
        this.holeNumber = holeNumber;
    }
}
