package com.louis.mango.backup.util;

import com.louis.mango.backup.constants.BackupConstants;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * MySQL备份还原工具类
 * @author Louis
 * @date Jan 15, 2019
 */
public class MySqlBackupRestoreUtils {

	/**
	 * 备份数据库
	 * @param host host地址，可以是本机也可以是远程
	 * @param username 数据库的用户名
	 * @param password 数据库的密码
	 * @param backupFolderPath 备份的路径
	 * @param fileName 备份的文件名
	 * @param database 需要备份的数据库的名称
	 * @return
	 * @throws IOException
	 */
	public static boolean backup(String host, String username, String password, String backupFolderPath, String fileName,
			String database) throws Exception {
		File backupFolderFile = new File(backupFolderPath);
		if (!backupFolderFile.exists()) {
			// 如果目录不存在则创建
			backupFolderFile.mkdirs();
		}
		if (!backupFolderPath.endsWith(File.separator) && !backupFolderPath.endsWith("/")) {
			backupFolderPath = backupFolderPath + File.separator;
		}
		//备份文件的路径 = 备份目录+文件名
		String backupFilePath = backupFolderPath + fileName;
		// 拼接命令行的命令
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(BackupConstants.BACKUP_EXE_PATH);//mysqldump的路径
		stringBuilder.append("mysqldump ");
		/*
		 	--opt：等同于--add-drop-table, --add-locks, --create-options,
		 		--quick, --extended-insert,--lock-tables,  --set-charset,
		 		--disable-keys 该选项默认开启,  可以用--skip-opt禁用.

			--add-drop-database：每个数据库创建之前添加drop数据库语句。

			--add-drop-table：每个数据表创建之前添加drop数据表语句。(默认为打开状态，使用--skip-add-drop-table取消选项)
		 */
		stringBuilder.append(" --opt --add-drop-database --add-drop-table ");
		stringBuilder.append(" -h").append(host).append(" -u").append(username).append(" -p").append(password);//地址和账号密码
		stringBuilder.append(" --result-file=").append(backupFilePath);//备份文件的地址
		stringBuilder.append(" --default-character-set=utf8 ");
		stringBuilder.append(database);//需要备份的数据库
		// 调用外部执行 exe 文件的 Java API
		Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
		if (process.waitFor() == 0) {
			// 0 表示线程正常终止
			System.out.println("数据已经备份到 " + backupFilePath + " 文件中");
			return true;
		}
		return false;
	}

    /**
     * 还原数据库
     * @param restoreFilePath 数据库备份的脚本路径
     * @param host IP地址
     * @param database 数据库名称
     * @param username 用户名
     * @param password 密码
     * @return
     */
	public static boolean restore(String restoreFilePath, String host, String username, String password, String database)
			throws Exception {
		File restoreFile = new File(restoreFilePath);
		if (restoreFile.isDirectory()) {
			for (File file : Objects.requireNonNull(restoreFile.listFiles())) {
				if (file.exists() && file.getPath().endsWith(".sql")) {
					restoreFilePath = file.getAbsolutePath();//获取备份文件的绝对路径
					break;
				}
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("mysql -h").append(host).append(" -u").append(username).append(" -p").append(password);
		stringBuilder.append(" ").append(database).append(" < ").append(restoreFilePath);
		try {
			Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
			if (process.waitFor() == 0) {
				System.out.println("数据已从 " + restoreFilePath + " 导入到数据库中");
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static String[] getCommand(String command) {
		String os = System.getProperty("os.name");
		String shell = "/bin/bash";//linux的命令行
		String c = "-c";
		if(os.toLowerCase().startsWith("win")){//windows的命令行
			shell = "cmd";
			c = "/c";
		}
		String[] cmd = { shell, c, command };
		System.out.println(Arrays.toString(cmd));
		return cmd;
	}

	public static void main(String[] args) throws Exception {
		/*String host = "localhost";
		String username = "root";
		String password = "123456";
		String database = "mango";

		System.out.println("开始备份");
		String backupFolderPath = "G:/dev/";
		String fileName = "mango.sql";
		backup(host, username, password, backupFolderPath, fileName, database);
		System.out.println("备份成功");*/

//		String sql = "cmd /c mysqldump --opt  --add-drop-database  --add-drop-table  -hlocalhost -uroot -p123456 --result-file=G:\\mango_backup\\backup_2019-12-24_1136\\mango.sql --default-character-set=utf8 mango";
		String sql = "cmd /c D:\\\"MySQL\\MySQL Server 5.7\\bin\"\\mysqldump --opt  --add-drop-database  --add-drop-table -uroot -p123456 --result-file=G:\\\\mango_backup\\\\mango.sql --default-character-set=utf8 mango";
		Process process = Runtime.getRuntime().exec(sql);
		/*System.out.println("开始还原");
		String restoreFilePath = "F:/dev/mango.sql";
		restore(restoreFilePath, host, username, password, database);
		System.out.println("还原成功");*/

	}

}
