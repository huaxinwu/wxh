/**
 * Ambition Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.orcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

import com.swetake.util.Qrcode;

/**
 *
 * @author wxh
 * @version $Id: QRCodeTest.java, v 0.1 2016年12月13日 下午5:19:34 wxh Exp $
 */
public class JavaQRCode {

    /**
     * @param content 存储内容
     * @param imgType 图片类型
     * @param size    图片尺寸
     * @return        图片缓冲区
     */
    public BufferedImage qRCodeCommon(String content, String imgType, int size) {
        BufferedImage buffImg = null;
        try {
            Qrcode handler = new Qrcode();
            // 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，
            //排错率越高可存储的信息越少，但对二维码清晰度的要求越小
            handler.setQrcodeErrorCorrect('M');
            /**
             * 编码模式:
             * Numeric             数字
             * Alphanumeric        英文字母
             * Binary              二进制
             * Kanji             汉字
             */

            handler.setQrcodeEncodeMode('B');
            // 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大
            handler.setQrcodeVersion(size);
            // 获得内容的字节数组，设置编码格式  
            byte[] contentBytes = content.getBytes("utf-8");
            // 图片尺寸  
            int imgSize = 67 + 12 * (size - 1);
            //设置图片宽度、高度、图片类型
            buffImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
            //绘制图片类(二维)
            Graphics2D gs = buffImg.createGraphics();
            //设置背景颜色
            gs.setBackground(Color.WHITE);
            //绘制图片位置
            gs.clearRect(0, 0, imgSize, imgSize);
            //设置图片前景色
            gs.setColor(Color.BLACK);
            // 设置偏移量，不设置可能导致解析出错  
            int pixoff = 2;
            // 输出内容> 二维码  
            if (contentBytes.length > 0 && contentBytes.length < 800) {
                boolean[][] codeOut = handler.calQrcode(contentBytes);
                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            //存在就绘制点(图片有点构成)
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                        }
                    }
                }
            } else {
                throw new Exception("QRCode content bytes length = " + contentBytes.length
                                    + " not in [0, 800].");
            }
            gs.dispose();
            buffImg.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffImg;
    }

    /**
     * 生成二维码图片
     * @param content 存储内容
     * @param imgPath 图片路径
     * @param imgType 图片类型
     * @param size    图片尺寸
     */
    public void encodeQRCode(String content, String imgPath, String imgType, int size) {
        try {
            BufferedImage buffImg = this.qRCodeCommon(content, imgType, size);
            File file = new File(imgPath);
            //生成二维码图片
            ImageIO.write(buffImg, imgType, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成二维码图片
     * @param content 存储内容
     * @param output  输出流
     * @param imgType 图片类型
     * @param size    图片尺寸
     */
    public void encodeQRCode(String content, OutputStream output, String imgType, int size) {
        try {
            BufferedImage buffImg = this.qRCodeCommon(content, imgType, size);
            //生成二维码图片
            ImageIO.write(buffImg, imgType, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成二维码图片
     * @param content 存储内容
     * @param imgPath 图片路径
     */
    public void encodeQRCode(String content, String imgPath) {
        this.encodeQRCode(content, imgPath, "png", 7);
    }

    /**
     * 生成二维码图片
     * @param content 存储内容
     * @param output 输出流
     */
    public void encodeQRCode(String content, OutputStream output) {
        this.encodeQRCode(content, output, "png", 7);
    }

    /**
     * 生成二维码图片
     * @param content 存储内容
     * @param imgPath 图片路径
     * @param imgType 图片类型
     */
    public void encodeQRCode(String content, String imgPath, String imgType) {
        this.encodeQRCode(content, imgPath, imgType, 7);
    }

    /**
     * 解析二维码
     * @param imgPath 图片路径
     * @return 字符串
     */
    public String decoderQRCode(String imgPath) {
        File file = new File(imgPath);
        BufferedImage buffImg = null;
        String content = "";
        try {
            buffImg = ImageIO.read(file);
            //二维码解析器
            QRCodeDecoder decoder = new QRCodeDecoder();
            content = new String(decoder.decode(new TwoDimensionCodeImage(buffImg)), "utf-8");
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
        } catch (DecodingFailedException dfe) {
            System.out.println("Error: " + dfe.getMessage());
            dfe.printStackTrace();
        }
        return content;
    }

    /** 
     * 解析二维码（QRCode） 
     * @param input 输入流 
     * @return 字符串
     */
    public String decodeQRCode(InputStream input) {
        BufferedImage bufImg = null;
        String content = null;
        try {
            bufImg = ImageIO.read(input);
            QRCodeDecoder decoder = new QRCodeDecoder();
            content = new String(decoder.decode(new TwoDimensionCodeImage(bufImg)), "utf-8");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } catch (DecodingFailedException dfe) {
            System.out.println("Error: " + dfe.getMessage());
            dfe.printStackTrace();
        }
        return content;
    }

    /**
     * 测试生我二维码图片
     * @param args
     */
    public static void main(String[] args) {
        String imgPath = "e:/Penguins.jpg";
        String encoderContent = "http://www.baidu.com";
        JavaQRCode handler = new JavaQRCode();
        handler.encodeQRCode(encoderContent, imgPath, "jpg");

        System.out.println("========encoder success");

        String decoderContent = handler.decoderQRCode(imgPath);
        System.out.println("解析结果如下：");
        System.out.println(decoderContent);
        System.out.println("========decoder success!!!");
    }
}
