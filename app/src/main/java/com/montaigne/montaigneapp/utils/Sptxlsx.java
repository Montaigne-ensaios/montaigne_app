package com.montaigne.montaigneapp.utils;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.List;

public class Sptxlsx {

    Workbook wb = new HSSFWorkbook();
    Sheet sheet;

    public void gerararquivoXlsx (ProjetoSpt projetoSpt, FuroSpt furoSpt, AmostraSpt amostraSpt) {

        sheet = wb.createSheet("Projeto: " + projetoSpt.getNome());

        List<AmostraSpt> amostrasSpts = furoSpt.getListaDeAmostras();

        List<Row> linhas = new ArrayList<>();



            Row linha1 = sheet.createRow(0);
            Row linha2 = sheet.createRow(1);
            Row linha3 = sheet.createRow(2);
            Row linha4 = sheet.createRow(3);
            Row linha5 = sheet.createRow(4);
            Row linha6 = sheet.createRow(5);
            Row linha7 = sheet.createRow(6);
            Row linha8 = sheet.createRow(7);
            Row linha9 = sheet.createRow(8);
            Row linha10= sheet.createRow(9);
            Row linha11= sheet.createRow(10);
            Row linha12= sheet.createRow(11);
            Row linha13= sheet.createRow(12);
            Row linha14= sheet.createRow(13);
            Row linha15= sheet.createRow(14);
            Row linha16= sheet.createRow(15);



        for (AmostraSpt amostras : amostrasSpts) {

                Cell golpe1 = linha.createCell(0);
                golpe1.setCellValue(amostraSpt.getGolpe1());
                Cell golpe2 = linha.createCell(1);
                golpe2.setCellValue(amostraSpt.getGolpe2());
                Cell golpe3 = linha.createCell(2);
                golpe3.setCellValue(amostras.getGolpe3());
                Cell nspt = linha.createCell(3);
                nspt.setCellValue(amostraSpt.getNspt());

            }


        }


        }

    }

