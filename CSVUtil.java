12import org.apache.commons.csv.CSVParser;
13import org.apache.commons.csv.CSVRecord;
14
public class csvutil {6
/**
8
CSV読込処理
9
*
0
*@param argRelativePath
1
*@return CSVData
2
*/
public static csvData importcsvFile(string argRelativepath) {
CSVFormat csvFileFormat =CSVFormat.DEFAULT.withHeader();
// FileReader fileReader = null;
InputstreamReader instreamReader = null;
CSVData csvData = new CSVData();
CSVParser csvFileParser = null;
0
int recordCount;
try{
Inputstream instream = new FileInputstream(argRelativePath);
2
BufferedInputstream buffinstram = new BufferedInputstream(instream);instreamReader =new InputstreamReader(buffInstram, "SJIS");// UTF-8csvFileParser = new CSVParser(instreamReader, csvFileFormat);
// Set CsvHeaders
csvData.setcsvHeaders(csvFileParser.getHeaderMap());
// Set CsvRecords
白
List<CSVRecord> rectemp = new ArrayList<CSVRecord>();for(CSVRecord csvRecord : csvFileParser) {
recTemp.add(csvRecord);
}
csvData.setcsvRecords(recTemp);
// Set Record
recordcount =csvData.getcsvRecords().size();
} catch (Exception e) {
finally{
try{
if (instreamReader != null && csvFileParser != null) {
instreamReader.close();
csvFileParser.close();
}} catch (IOException e){
e.printstacktrace();
}
return csvData;
