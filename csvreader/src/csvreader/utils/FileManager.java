package csvreader.utils;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;
import csvreader.model.DataModel;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {

    CSVReader reader = null;
    String[] data;
    ArrayList<String[]> compiledData = new ArrayList<>();

    public ArrayList<String[]> csvParser(){

        try {
            String file = "sample.csv";
            reader = new CSVReader(new FileReader(file));

            while((data = reader.readNext()) != null) {
                compiledData.add(data);
            }

            reader.close();
        }catch(IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return compiledData;
    }
    // Creates a new CSV file with a
    public void writeDataToCsv(List<DataModel> list) {
        String newFile = "temp.csv";

        try{
            Writer writer = new FileWriter(newFile);
            writer.append(header());
            StatefulBeanToCsv<DataModel> toCsv = new StatefulBeanToCsvBuilder<DataModel>(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                    .withOrderedResults(true)
                    .build();

            toCsv.write(list);
            writer.close();

        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }
    /*Creates Headers for export CSV File based on Annotations in DataModel.Class.
      Filters column names & positions, then sort the positions with Comparator and positions as reference.
      Map all columns in its respective positions, then join column value together with "," delimiter.
    */
    private String header() {
        return Arrays.stream(DataModel.class.getDeclaredFields())
                .filter(f-> f.getAnnotation(CsvBindByName.class) != null
                && f.getAnnotation(CsvBindByPosition.class) != null)
                .sorted(Comparator.comparing(f-> f.getAnnotation(CsvBindByPosition.class).position()))
                .map(f->f.getAnnotation(CsvBindByName.class).column())
                .collect(Collectors.joining(",")) + "\n";
    }


}
