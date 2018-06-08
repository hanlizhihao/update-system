package com.thinking.update.main.common.utils;

import com.thinking.update.main.common.exception.BDException;
import com.thinking.update.main.domain.model.FileVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Administrator
 */
@Slf4j
public class FileUtil {

	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath + fileName);
		out.write(file);
		out.flush();
		out.close();
	}

	public static FileVo getFileVo(FileVo fileVo, MultipartFile file, String filePath) {
		String fileType = fileVo.getFileName().substring(fileVo.getFileName().lastIndexOf("."));
		String realFileName = fileVo.getMd5() + fileType;
		try {
			FileUtils.writeByteArrayToFile(new File(filePath, realFileName),file.getBytes());
		} catch (IOException e) {
			log.error("上传文件失败", e);
			throw new BDException("上传文件发生IO异常");
		}
		fileVo.setPath(filePath+realFileName);
		fileVo.setRealName(realFileName);
		return fileVo;
	}

	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				System.out.println("删除单个文件" + fileName + "成功！");
				return true;
			} else {
				System.out.println("删除单个文件" + fileName + "失败！");
				return false;
			}
		} else {
			System.out.println("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}

	public static String RenameToUUID(String fileName) {
		return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
	}
}
