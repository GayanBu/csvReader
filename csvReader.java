if (splitStr.length == 3) {
String tableName = splitstr[1];
String filePass = splitstr[2].replace(";", "");
V／ CSvデータファイル読み込み
File file = new File(filePass);
FileInputStream input = new FileInputStream(file);
CSVData csvData =CSVUtil.importCsvFile(file.getPath());
InputstreamReader stream = new InputStreamReader(input, "SJIS");BufferedReader br = new BufferedReader(stream);
／／ 拡張子判定
String ex=file.getName().substring(file.getName().lastIndexof("."));if (!".csv".equals(ex)) {
／／ csvファイル以外の場合
message ＝ ＂ERROR：CSVファイルを指定してください。＼n＂；
System.out.println(message);
I
resultSb.append(message);
continue;
}
String line = "";
nt i = 0;
String columnName = null;
ArrayList<String> columnList = new ArrayList<String>();
／／ 最終行まで読み込む
(line=bbr.readLine()) != nu11) {
／／一行目は列名
if (i == 0) {
columnName=line;
} else {
//line=ne.place("\"", "'");columnList.add(line
i =i+1;
}
r.close();
／／ csvファイルから、インサート文の生成
br.close();
StringBuilder insertsb =new StringBuilder();
insertSb.append("INSERT ALL \n");
//headers list with comma delimeterString headers =csvData.getCsvHeaders().entrySet().stream().map(a -> a.getKey())
.collect(Collectors.joining(", "));
//iterating csx records
for (int i =ø; i < csvData.getCsvRecords().size(); i++) {StringBuilder columnSb = new StringBuilder();
StringBuilder quotationSb = new StringBuilder();
insertSb.append("INTO ");
insertSb.append(tableName);
insertSb.append(" (");
insertSb.append(headers);
insertSb.append(") VALUES ");
//getting particular column value
for (int j = Ø; j < csvData.getCsvHeaders().rs().size(); j++) {if (!csvData.getCsvRecords().get(i).get(j).isEmpty()) {
quotationSb. append("\'");
quotationSb.append(csvData.getCsvRecords().get(·get(rds().et(i).quotationSb.append("\'");
} else {
quotationSb.append("nu11");
}if (!(j == csvData.getCsvHeaders().sizers().size() - 1)) {quotationSb.append(", ");}
}
columnSb.append(quotationsb);
／／要索を連結
insertSb.append("(");
insertSb.append(columnSb.toString());
insertSb.append(") \n");
I
J1
insertsb.append("SELECT *FROM dual;");
inputstr = insertsb.toString();
commandName = "insert";