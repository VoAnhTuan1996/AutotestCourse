import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataDrivenTesting {
    private static XSSFWorkbook excelWBook;
    private static XSSFSheet excelSheet;
    private static XSSFRow excelRow;
    private static XSSFCell excelCell;
    public static void main(String[] agrs) throws IOException {
        String path = System.getProperty("user.dir");
        String file = path + "\\src\\test\\resources\\TC_Login.xlsx";
        String nameSheet = "Login";
        //read file excel
        FileInputStream excelFile = new FileInputStream(file);
        //truy cập vào file data test
   /*     excelWBook = new XSSFWorkbook(excelFile);
        excelSheet = excelWBook.getSheet(nameSheet);
        System.out.println(getCellData(1,0));

        getTableArray(file,nameSheet);*/
    }

    //read data from excel
    public static String getCellData(int row, int col){
        excelCell = excelSheet.getRow(row).getCell(col);
        String dataCell = excelCell.getStringCellValue();
        return dataCell;
    }

    //getData from table
    public static Object[][] getTableArray(String path,String fileName) throws IOException {
        String[][] newTableArray = null;
        FileInputStream excelFile = new FileInputStream(path);
        //truy cập vào file data test
        excelWBook = new XSSFWorkbook(excelFile);
        excelSheet = excelWBook.getSheet(fileName);
        //System.out.println(getCellData(1,0));
        int startRow = 1;
        int startCol = 1;
        int ci,cj;
        int totalRows = excelSheet.getLastRowNum();// tính từ cột đầu tiên bắt đầu bằng 0
        int totalCols = excelSheet.getRow(1).getLastCellNum()-1;//trả về đúng giá trị cột

        System.out.println("totalRow: "+totalRows);
        System.out.println("totalCols: "+totalCols);

        newTableArray = new String[totalRows][totalCols];
        for (int i = startRow; i<=totalRows; i++){
            ci = i-1;
            for(int j = startCol;j <= totalCols; j++){
                cj = j-1;
                System.out.println("ci: "+ ci);
                System.out.println("cj: "+cj);
                newTableArray[ci][cj] = getCellData(i,j);
                System.out.println(newTableArray[ci][cj]);
            }
        }

        return newTableArray;
    }

    @DataProvider(name = "TC_Login123")
    public Object[][] dataLogin() throws IOException {
        String path = System.getProperty("user.dir");
        String filePath = path + "\\src\\test\\resources\\TC_Login.xlsx";
        String nameSheet = "Login";
        Object[][] dataLogin = DataDrivenTesting.getTableArray(filePath,nameSheet);
        return dataLogin;
    }
}
