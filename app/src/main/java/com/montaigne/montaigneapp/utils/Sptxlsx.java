package com.montaigne.montaigneapp.utils;

import android.content.Intent;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;


import org.apache.poi.hssf.usermodel.HSSFChart;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

public class Sptxlsx {

    Workbook wb = new HSSFWorkbook();
    Sheet sheet;
    Row row;
    Cell furo1,furo2,furo3,nspt;

    protected void gerarArquivoXlsx (ProjetoSpt projetoSpt, FuroSpt furoSpt, AmostraSpt amostraSpt, File file) {

        sheet = wb.createSheet("Projeto: " + projetoSpt.getNome());

        List<AmostraSpt> amostrasSpts = furoSpt.getListaDeAmostras();

        // TODO: 17/11/2022 Mock para teste com aplicativo.

        //List<AmostraSpt> amostrasSpts = new ArrayList<>();
        //AmostraSpt amostraSpt1 = new AmostraSpt("1","teste",3,2,3,4);

        List<Cell> celulas = new ArrayList<>();

        int rownumber = 0;

        for (AmostraSpt amostras : amostrasSpts) {

            row = sheet.createRow(rownumber++);
            furo1 = row.createCell(0);
            furo1.setCellValue(amostras.getGolpe1());
            furo2 = row.createCell(1);
            furo2.setCellValue(amostras.getGolpe2());
            furo3 = row.createCell(2);
            furo3.setCellValue(amostras.getGolpe3());
            nspt = row.createCell(3);
            nspt.setCellValue(amostras.getNspt());

            celulas.add(furo1);
            celulas.add(furo2);
            celulas.add(furo3);
            celulas.add(nspt);

        }

    }
}


