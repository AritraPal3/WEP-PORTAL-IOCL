package link;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import excel_filter.AppTest;

public class AppLink {

    public static void main(String[] args) {
        List<AppTest> custList = readXLSXFile("C:\\Users\\User\\Downloads\\File_and_Note_Sheet_(TAT_Apr_2022_to_Mar_2023)_150623.xlsx");
        
        HashMap<String,Integer>initDep=new HashMap<>();
        HashMap<String,Integer>pendDep=new HashMap<>();
        
        for (AppTest cust : custList) {
            String temp1 = cust.getInitiatorDepartment();
            String temp2 = cust.getPendingDepartment();
            String pendloc=cust.getPendingLocation();

        	if(cust.getPendingDays()>60 && pendloc.equals("Eastern Region Office")) {
        		
            if (initDep.containsKey(temp1) == false) {
                initDep.put(temp1, 1);
            } else {
                int x = initDep.get(temp1);
                initDep.put(temp1, x + 1);
            }
            if (pendDep.containsKey(temp2) == false) {
                pendDep.put(temp2, 1);
            } else {
                int x = pendDep.get(temp2);
                pendDep.put(temp2, x + 1);
            }
        	}
        }
        
//        System.out.println("List of Pending with Departments\n");
//        for (String department : pendDep.keySet()) {
//            System.out.println(department + ": " + pendDep.get(department));
//        }
//        System.out.println("\n");
//        System.out.println("List of Initiator Departments");
//        System.out.println("\n");
//        for (String department : initDep.keySet()) {
//            System.out.println(department + ": " + initDep.get(department));
//        }

    }

    public static List<AppTest> readXLSXFile(String file) {
        List<AppTest> listCust = new ArrayList<AppTest>();
        try {
            XSSFWorkbook work = new XSSFWorkbook(new FileInputStream(file));

            XSSFSheet sheet = work.getSheet("File And Note Sheet (TAT Apr 20"); 
            if (sheet == null) {
                System.out.println("Sheet not found.");
                return listCust; // Return an empty list if the sheet is not found
            }

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) {
                    continue; // Skip if the row is null
                }

                int S_no, pendingDays;
                String reference, initiationDate, initiatorName, initiatorLocation, initiatorDepartment, pendingUser, pendingDepartment, pendingLocation, Subject;
                try {
                    S_no = (int) row.getCell(0).getNumericCellValue();
                } catch (Exception e) {
                    S_no = 0;
                }
                try {
                    reference = row.getCell(1).getStringCellValue();
                } catch (Exception e) {
                    reference = null;
                }
                try {
                    initiationDate = row.getCell(2).getStringCellValue();
                } catch (Exception e) {
                    initiationDate = null;
                }
                try {
                    initiatorName = row.getCell(3).getStringCellValue();
                } catch (Exception e) {
                    initiatorName = null;
                }
                try {
                    initiatorDepartment = row.getCell(4).getStringCellValue();
                } catch (Exception e) {
                    initiatorDepartment = null;
                }
                try {
                    initiatorLocation = row.getCell(5).getStringCellValue();
                } catch (Exception e) {
                    initiatorLocation = null;
                }
                try {
                    pendingUser = row.getCell(6).getStringCellValue();
                } catch (Exception e) {
                    pendingUser = null;
                }
                try {
                    pendingDepartment = row.getCell(7).getStringCellValue();
                } catch (Exception e) {
                    pendingDepartment = null;
                }
                try {
                    pendingLocation = row.getCell(8).getStringCellValue();
                } catch (Exception e) {
                    pendingLocation = null;
                }
                try {
                    Subject = row.getCell(9).getStringCellValue();
                } catch (Exception e) {
                    Subject = null;
                }
                try {
                    pendingDays = (int) row.getCell(10).getNumericCellValue();
                } catch (Exception e) {
                    pendingDays = 0;
                }

                AppTest cust = new AppTest(S_no, reference, initiationDate, initiatorName, initiatorDepartment,
                        initiatorLocation, pendingUser, pendingDepartment, pendingLocation, Subject, pendingDays);
                listCust.add(cust);
            }
            work.close();
        } catch (IOException e) {
            System.out.println("Exception in reading data from Excel: " + e.getMessage());
//            e.printStackTrace();
        }
        return listCust;
    }
}
