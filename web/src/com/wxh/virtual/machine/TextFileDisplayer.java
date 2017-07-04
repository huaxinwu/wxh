/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.virtual.machine;

import java.io.CharArrayWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文本内容显示
 * @author wxh
 * @version $Id: TextFileDisplayer.java, v 0.1 2017年7月4日 上午11:34:58 wxh Exp $
 */
public class TextFileDisplayer implements Doer {

    private String fileName;

    /**
     * @param fileName
     */
    public TextFileDisplayer(String fileName) {
        super();
        this.fileName = fileName;
    }

    /** 
     * 
     * @see com.wxh.virtual.machine.Doer#doYourThing()
     */
    @Override
    public void doYourThing() {
        try {
            FileReader fr = new FileReader(fileName);

            try {
                CharArrayWriter caw = new CharArrayWriter();
                int c;
                while ((c = fr.read()) != -1) {
                    caw.write(c);
                }
                System.out.println(caw.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 关闭流
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
