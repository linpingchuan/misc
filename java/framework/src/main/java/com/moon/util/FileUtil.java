package com.moon.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * 文件操作工具类
 * Created by Paul on 2017/2/12.
 */
public class FileUtil {
    private static final Logger LOGGER= LoggerFactory.getLogger(FileUtil.class);

    /**
     * 获取真实文件名（自动去掉文件路径）
     * @param fileName
     * @return
     */
    public static String getRealFileName(String fileName){
        return FilenameUtils.getName(fileName);
    }

    /**
     * 创建文件
     * @param filePath
     * @return
     */
    public static File createFile(String filePath){
        File file;
        try{
            file=new File(filePath);
            File parentDir=file.getParentFile();
            if(!parentDir.exists())
                FileUtils.forceMkdir(parentDir);
        } catch (IOException e) {
            LOGGER.error("create file failure",e);
            throw new RuntimeException();
        }
        return file;
    }
}