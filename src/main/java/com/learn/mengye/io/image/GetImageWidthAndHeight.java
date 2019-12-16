package com.learn.mengye.io.image;

import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

/**
 * @author MengYe
 * @desc desc
 * @date 2019/12/13 17:28
 */
public class GetImageWidthAndHeight {
    public static void main(String[] args) {
        String url ="http://picture.seeyouplan.com/Fioc_WULxJiMIyOts074MFpzDjV4";
        initPicWidthAndHeight(url);

    }




    public static Map initPicWidthAndHeight(String url) {
        // 如果是图片，需要计算第一张图片的宽高，所有图片的比例相同
        long start = System.currentTimeMillis();
        if (!StringUtils.isBlank(url)) {
            BufferedImage sourceImg;
            try {
                InputStream is = new URL(url).openStream();
                sourceImg = ImageIO.read(is);
                int width = sourceImg.getWidth();
                int height = sourceImg.getHeight();

                long end = System.currentTimeMillis();
                System.out.println("宽:" + width + "   高:" + height);
                System.out.println((end - start) / 1000.0);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
