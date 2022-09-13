*/
1415public class CSVData {
/** cSVHeaders */
private Map<string, Integer> csvHeaders;/** csvRecords */
private List<CSVRecord> csvRecords;
/**
* @return csvHeaders
*-
public Map<string, Integer> getcsvHeaders() {return csvHeaders;
}
**/
*@param csVHeaders セットする csvHeaders
*
public void setcsvHeaders(Map<string, Integer> csvHeaders) {this.csvHeaders = csvHeaders;}
/**
* @return csvRecords
*/
public List<CsVRecord> getcsvRecords() {return csvRecords;}
**/
* @param csvRecords セットする csvRecords
*/
public void setcsvRecords(List<CSVRecord> csvRecords) {this.csvRecords = csvRecords;}
/**
*HELPER METHOD TO CONVERT CSVRECORD TO A LIST*
I
*@param iterator
* @return List<T>
*/
public static <T> List<T> getListFromIterator(Iterator<T> iterator) {
Iterable<t> iterable = () -> iterator;
return streamsupport.stream(iterable.spliterator(), false).collect(collectors.toList());
}
