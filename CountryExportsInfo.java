/**
 * Reads a chosen CSV file of country exports and prints info about them.
 * 
 * @author pabl0cesar
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class CountryExportsInfo {
    public void listExporters(CSVParser parser, String valueOfInterest) {
        for (CSVRecord record : parser) {
            String column = record.get("Exports");
            if (column.contains(valueOfInterest)) {
                String country = record.get("Country");
                System.out.println("This country exports "+valueOfInterest+": "
                +country);
            }
        }
    }
    
    public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord record : parser) {
            String column = record.get("Exports");
            if (column.contains(exportItem1) && column.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println("This country exports "+exportItem1+" and "+exportItem2+": "
                +country);
            }
        }
       }
       
       
    public void numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord record : parser) {
            String column = record.get("Exports");
            if (column.contains(exportItem)) {
                count+=1;
            }
        }
        System.out.println("Number of "+exportItem+" exporters: "+count);
    }
    
    public void countryInfo(CSVParser parser, String country){
        for (CSVRecord record : parser) {
            String tCountry = record.get("Country");
            if (tCountry.equals(country)) {
                System.out.println(country+" exports: "+record.get("Exports"));
            }
        }
    }
    
    public void oneTrillionOrMore(CSVParser parser){
        for(CSVRecord record: parser){
            if(record.get("Value (dollars)").length() > "$999,999,999,999".length()){
                String country = record.get("Country");
                System.out.println(country+" has an economy of one thrillion dollars or more.");
            }
        }
    }

    public void whoExports() {
        FileResource fr = new FileResource();
        listExporters(fr.getCSVParser(), "coffee");
        listExportersTwoProducts(fr.getCSVParser(), "flowers", "cotton");
        numberOfExporters(fr.getCSVParser(), "cocoa");
        countryInfo(fr.getCSVParser(), "Nauru");
        oneTrillionOrMore(fr.getCSVParser());
    }
}
