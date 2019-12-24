package com.louis.mango.backup.service.impl;

import com.louis.mango.backup.service.MysqlBackupService;
import com.louis.mango.backup.util.MySqlBackupRestoreUtils;
import org.springframework.stereotype.Service;

@Service
public class MysqlBackupServiceImpl implements MysqlBackupService {

	/**
	 *
	 * @param host host地址，可以是本机也可以是远程
	 * @param username 数据库的用户名
	 * @param password 数据库的密码
	 * @param backupFolderPath 备份的路径
	 * @param fileName 备份的文件名
	 * @param database 需要备份的数据库的名称
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean backup(String host, String username, String password, String backupFolderPath, String fileName,
			String database) throws Exception {
		return MySqlBackupRestoreUtils.backup(host, username, password, backupFolderPath, fileName, database);
	}

	/**
	 *
	 * @param restoreFilePath 数据库备份的脚本路径
	 * @param host IP地址
	 * @param username 数据库的用户名
	 * @param password 密码
	 * @param database 数据库名称
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean restore(String restoreFilePath, String host, String username, String password, String database)
			throws Exception {
		return MySqlBackupRestoreUtils.restore(restoreFilePath, host, username, password, database);
	}

}
