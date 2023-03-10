package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class FileSetting {
    private final Logger logger = LoggerFactory.getLogger(FileSetting.class);
    private static  FileSetting instance;
    private String filePath;
    private int fileSize;

    static{
        instance = new FileSetting();
        instance.Init();
    }
    private void Init(){
        try {
            ClassLoader classLoader = FileSetting.class.getClassLoader();
            URL res = classLoader.getResource("FileSetting.properties");
            String Path = res.getPath();
            Properties pro = new Properties();
            pro.load(new FileReader(Path));
            this.filePath = pro.getProperty("mmap.filepath");
            this.fileSize = Integer.parseInt(pro.getProperty("mmap.filesize")) ;
        } catch (IOException e) {
            logger.error("setting load fail!");
        }
    }
    public static FileSetting getInstance(){
        return instance;
    }
    public String getFilePath(){
        return filePath;
    }
    public int getFileSize(){
        return fileSize;
    }
}
