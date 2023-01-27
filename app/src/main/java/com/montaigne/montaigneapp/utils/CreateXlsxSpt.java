package com.montaigne.montaigneapp.utils;

import android.app.Activity;
import android.content.Context;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class CreateXlsxSpt {

    private static Workbook wb = new HSSFWorkbook();
    private static Sheet sheet;
    private static Row row;
    private static Cell golpe1, golpe2, golpe3, nspt;

    public static void createFileXlsx(ProjetoSpt projetoSpt, FuroSpt furoSpt,
                                        AmostraSpt amostraSpt, Activity activity) {

        sheet = wb.createSheet("Projeto: " + projetoSpt.getNome());

       List<AmostraSpt> amostrasSpts = furoSpt.getListaDeAmostras();
        List<Cell> celulas = new ArrayList<>();


        // TODO: 17/11/2022 Mock para teste com aplicativo.

        Row linha1 = sheet.createRow(0);
        Row linha2 = sheet.createRow(1);
        Row linha3 = sheet.createRow(2);
        Row linha4 = sheet.createRow(3);
        Row linha5 = sheet.createRow(4);
        Row linha6 = sheet.createRow(5);

        //coluna A

        Cell cab_titulo = linha1.createCell(0);
        Cell cab_cliente = linha2.createCell(0);
        Cell cab_local = linha3.createCell(0);
        Cell cab_furo = linha4.createCell(0);
        Cell cab_data = linha5.createCell(0);

        //coluna B

        Cell cliente = linha2.createCell(1);
        Cell local = linha3.createCell(1);
        Cell furo = linha4.createCell(1);
        Cell data_inicial = linha5.createCell(1);
        Cell data_final = linha6.createCell(1);

        //coluna D

        Cell nível_de_agua = linha4.createCell(4);
        Cell na_INICIAL = linha4.createCell(5);
        Cell na_10min = linha5.createCell(5);
        Cell na_24h = linha6.createCell(5);

        //coluna E

        Cell inicial_na = linha4.createCell(5);
        Cell min_10 = linha5.createCell(5);
        Cell hrs_24 = linha6.createCell(5);

        //coluna H

        Cell ref = linha4.createCell(7);
        Cell sondador = linha5.createCell(7);
        Cell resptecnico = linha6.createCell(7);

        //coluna K

        Cell prancha = linha4.createCell(10);

        cab_titulo.setCellValue("PERFIL DE SONDAGEM E PERCUSSAO");

        cab_cliente.setCellValue("CLIENTE: ");
        cab_local.setCellValue("LOCAL: ");
        cab_furo.setCellValue("FURO N: ");
        cab_data.setCellValue("DATA: ");

        data_inicial.setCellValue("INICIO");
        data_final.setCellValue("TERMINO");

        nível_de_agua.setCellValue("NA" +
                "\n(m)");
        na_INICIAL.setCellValue("INICIAL");
        na_10min.setCellValue("10min");
        na_24h.setCellValue("24h");


        String texto_resptecnico = "RESP.TECNICO:";

        ref.setCellValue("REF:");
        sondador.setCellValue("SONDADOR:");
        resptecnico.setCellValue(texto_resptecnico);

        prancha.setCellValue("FOLHA: 1/1");

        Font f1 = wb.createFont();
        f1.setFontName("Arial");
        f1.setFontHeight((short) 250);
        f1.setBold(true);

        Font f2 = wb.createFont();
        f2.setFontName("Arial");
        f2.setBold(true);

        CellStyle estilodotitulo = wb.createCellStyle();
        estilodotitulo.setAlignment(HorizontalAlignment.CENTER);
        estilodotitulo.setFont(f1);

        CellStyle estilodocabecalho = wb.createCellStyle();
        estilodocabecalho.setVerticalAlignment(VerticalAlignment.CENTER);
        estilodocabecalho.setAlignment(HorizontalAlignment.CENTER);
        estilodocabecalho.setFont(f2);

        //todo: Estilos aplicados as Células

        cab_titulo.setCellStyle(estilodotitulo);
        data_final.setCellStyle(estilodocabecalho);
        data_inicial.setCellStyle(estilodocabecalho);
        nível_de_agua.setCellStyle(estilodocabecalho);
        ref.setCellStyle(estilodocabecalho);
        sondador.setCellStyle(estilodocabecalho);
        resptecnico.setCellStyle(estilodocabecalho);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);

            if (cell != null)
                cell.setCellStyle(estilodocabecalho);
        }

        for (int i=3; i <= 5; i++){

            Row row = sheet.getRow(i);
            Cell cell = row.getCell(5);

            if (cell != null)

                cell.setCellStyle(estilodocabecalho);

        }

        sheet.setColumnWidth(0,10*256);

        sheet.addMergedRegion(new CellRangeAddress(0,0,0,10));
        sheet.addMergedRegion(new CellRangeAddress(4,5,0,0));
        sheet.addMergedRegion(new CellRangeAddress(1,1,1,10));
        sheet.addMergedRegion(new CellRangeAddress(2,2,1,10));
        sheet.addMergedRegion(new CellRangeAddress(3,3,1,3));
        sheet.addMergedRegion(new CellRangeAddress(3,5,4,4));
        sheet.addMergedRegion(new CellRangeAddress(4,4,2,3));
        sheet.addMergedRegion(new CellRangeAddress(5,5,2,3));
        sheet.addMergedRegion(new CellRangeAddress(3,5,10,10));
        sheet.addMergedRegion(new CellRangeAddress(3,3,8,9));
        sheet.addMergedRegion(new CellRangeAddress(4,4,8,9));
        sheet.addMergedRegion(new CellRangeAddress(5,5,8,9));

        sheet.setColumnWidth(7,texto_resptecnico.length()*300);

        int rownumber = 6;

        for (AmostraSpt amostras : amostrasSpts) {

            row = sheet.createRow(rownumber++);
            golpe1 = row.createCell(0);
            golpe1.setCellValue(amostras.getGolpe1());
            golpe2 = row.createCell(1);
            golpe2.setCellValue(amostras.getGolpe2());
            golpe3 = row.createCell(2);
            golpe3.setCellValue(amostras.getGolpe3());
            nspt = row.createCell(3);
            nspt.setCellValue(amostras.getNspt());

            celulas.add(golpe1);
            celulas.add(golpe2);
            celulas.add(golpe3);
            celulas.add(nspt);

        }

        File file = new File(activity.getCacheDir(),"xlsx");

        try {

            OutputStream out = new FileOutputStream(file);

            wb.write(out);

        }catch (FileNotFoundException e){
            e.fillInStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


