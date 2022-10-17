/**
 * @程式名稱 Log.java
 * @author 秋本空
 * @用途 製造標準Log格式並輸出檔案至指定位置
 */
package akimoto.sora.util.log;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author akimoto.sora(秋本空)
 *
 */
public class Log {

	/**
	 * 
	 * @param loglist 傳入的LogList
	 * @param log     要增加的Log
	 * @return 增加Log後的LogList
	 */
	public List<String> recordLog(List<String> loglist, String log) {

		loglist.add(log);
		return loglist;

	}

	/**
	 * 
	 * @param Constant Log類別(參考LogConstant)
	 * @param message  Log內容
	 * @return Format過的Log字串
	 */
	public String formatLog(String Constant, String message) {
		String log = "";
		String date = "【" + getDate() + "】";

		switch (Constant) {
		case LogConstant.Log_Information:
			log = "【資訊】" + date + "：" + message;
			break;
		case LogConstant.Log_Error:
			log = "【錯誤】" + date + "：" + message;
			break;
		case LogConstant.Log_Fatal:
			log = "【致命】" + date + "：" + message;
			break;
		case LogConstant.Log_Debug:
			log = "【除錯】" + date + "：" + message;
			break;
		case LogConstant.Log_Warning:
			log = "【警告】" + date + "：" + message;
			break;
		}

		return log;

	}

	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String dateresult = sdf.format(date);

		return dateresult;

	}

	/**
	 * 
	 * @param logpath  輸出資料夾路徑
	 * @param filename 檔案名稱
	 * @param loglist  Log的List
	 * @throws IOException 拋出IO例外
	 */
	public void outputLog(String logpath, String filename, List<String> loglist) throws IOException {
		File folder = new File(logpath);
		if (!folder.exists()) {
			folder.mkdir();
		}
		File logfile = new File(logpath + "/" + filename + ".txt");
		if (!logfile.exists()) {
			logfile.createNewFile();
		}
		PrintWriter pw = new PrintWriter(logfile);
		for (String log : loglist) {
			pw.println(log);
		}
		pw.close();

	}

	/**
	 * 
	 * @param logpath  輸出資料夾路徑
	 * @param filename 檔案名稱
	 * @param loglist  Log的List
	 * @throws IOException 拋出IO例外
	 */
	public void outputLogWithDate(String logpath, String filename, List<String> loglist) throws IOException {
		File folder = new File(logpath);
		if (!folder.exists()) {
			folder.mkdir();
		}
		File logfile = new File(logpath + "/" + filename + "_" + getDate() + ".txt");
		if (!logfile.exists()) {
			logfile.createNewFile();
		}
		PrintWriter pw = new PrintWriter(logfile);
		for (String log : loglist) {
			pw.println(log);
		}
		pw.close();

	}

}
