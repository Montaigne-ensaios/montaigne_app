package com.montaigne.montaigneapp.utils;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import org.apache.poi.hssf.usermodel.HSSFChart;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Sptxlsx {

    Workbook wb = new HSSFWorkbook();
    Sheet sheet;
    Row row;
    Cell furo1,furo2,furo3,nspt;

    public void gerararquivoXlsx (ProjetoSpt projetoSpt, FuroSpt furoSpt, AmostraSpt amostraSpt, File file) {

        sheet = wb.createSheet("Projeto: " + projetoSpt.getNome());
        List<AmostraSpt> amostrasSpts = furoSpt.getListaDeAmostras();
        List celulas = new ArrayList();
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


