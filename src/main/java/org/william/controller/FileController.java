package org.william.controller;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by huawai on 2017/8/7. Description:
 */
@Controller
@RequestMapping(value = "/file")
public class FileController {

    @RequestMapping(value = "/importFile", method = RequestMethod.POST)
    public void importFile(@RequestParam("file") MultipartFile file) {
        try {
            InputStream is = file.getInputStream();
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int maxRowNum = sheet.getLastRowNum();
            XSSFRow row = null;
            for (int i = 0; i <= maxRowNum; i++) {
                row = sheet.getRow(i);
                row.getCell(0).setCellType(CELL_TYPE_STRING);
                String name = row.getCell(0).getStringCellValue();
                System.out.println("name:" + name);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
