public class ExecuteProcedure {
8
private static final String BATCH_CLASS_PATH = "properties.batch.path";
/**
executeメソッド
*
*@param procedureName
* @throws Exception
@throws SQLException
*@throws InterruptedException
**/

public int execute(String commandLinestr) throws Exception {
String storedProcName = commandLineStr.split(Pattern.quote(".
te("."))[@].replace("CALL ",
String[] parameters =
commandLineStr.substring(commandLineStr.
.inde
)+1,commandLineStr.length()-1)
.split(Pattern.quote(","));
String funcName=commandLinestr.substring(commandLineStr.indexof(".") + 1, commandLinestr.indexof("("));
try {
String className =Caser.toUpperCamelCase(storedProcName) + "Body";
Object procClassObject;
procClassobject = Class.forName(SystemResource.getString(BATCH_CLASS_PATH) + "." + className)
·getDeclaredConstructor(). newInstance();
Class<?>[] paramClasses = new Class<?>[parameters.length];
object[] paramobjects = new Object[parameters.length];
白
Intstream.range(0,parameters.length).forEach(index -> {
I
paramClasses[index] = parameters[index]·getClass();
paramobjects[index] = parameters[index];});
String javaFuncName = Caser.toLowerCameLCase(funcName);
Method method = procClassObject.getClass().getDeclaredMethod(javaFuncName, paramClasses);
method.invoke(procClassObject, paramobjects);
return 1;
／／システムがエラー／突然の終了をスローした場合
} catch (InstantiationException | IllegalAccessException | IllegalArgumentException| InvocationTargetException| NoSuchMethodException | SecurityException | ClassNotFoundException e){
throw e;

}
