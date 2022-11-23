package com.montaigne.montaigneapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;

import androidx.core.content.FileProvider;

import com.montaigne.montaigneapp.model.spt.AmostraSpt;
import com.montaigne.montaigneapp.model.spt.FuroSpt;
import com.montaigne.montaigneapp.model.spt.ProjetoSpt;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

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

    private static Workbook wb = new HSSFWorkbook();
    private static Sheet sheet;
    private static Row row;
    private static Cell furo1, furo2, furo3, nspt;

    public static class CompartilhaXlsx{

        private static File diretorio;
        private static File xlsxDir;
        private static File[] arquivoxlsx;

        public static void compartilhaXlsx(Context context, Activity activity){

            Intent intent = new Intent("com.montaigne.montaigneapp.ACTION_RETURN_FILE");
            diretorio = context.getCacheDir();
            xlsxDir = new File(diretorio,"xlsx");
            arquivoxlsx = xlsxDir.listFiles();
            activity.setResult(Activity.RESULT_CANCELED,null);

            Uri fileUri = FileProvider.getUriForFile(activity,
                    "com.montaigne.montaigneapp.fileprovider",arquivoxlsx[0]);

        }
    }


    public static void gerarArquivoXlsx(ProjetoSpt projetoSpt, FuroSpt furoSpt,
                                        AmostraSpt amostraSpt, Context context, Activity activity) {

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

        File file = new File(context.getCacheDir(),"xlsx");

        try {

            OutputStream outputStream = new FileOutputStream(file);

            wb.write(outputStream);

        }catch (FileNotFoundException e){
            e.fillInStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CompartilhaXlsx.compartilhaXlsx(context,activity);

    }
}


