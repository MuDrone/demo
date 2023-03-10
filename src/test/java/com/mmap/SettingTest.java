package com.mmap;


import com.FileSetting;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class SettingTest {
    private final Logger logger = LoggerFactory.getLogger(SettingTest.class);
    @Test
    public void test1(){

        logger.info(FileSetting.getInstance().getFilePath());
        logger.info(FileSetting.getInstance().getFileSize()+"");
    }
}
