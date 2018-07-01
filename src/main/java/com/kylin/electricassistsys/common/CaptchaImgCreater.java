package com.kylin.electricassistsys.common;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.SecureRandom;

/**
 * Created by Threecolors on 2018/1/24.
 */
public class CaptchaImgCreater
{
    /**
     *
     */
    private static final String CODE_LIST =
            "abcde23456789fghijkmnpqrstuvw23456789xyzABCDEFJHJK23456789LMNOPQRS23456789TUVWXYZ23456789";

    private HttpServletResponse response;

    private HttpServletRequest request;

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private static final int HEIGHT = 30;
    /**
     *
     */
    private static final int FONT_NUM = 4;
    /**
     *
     */
    private int width = 0;
    /**
     *
     */
    private int iNum = 0;
    /**
     *
     */
    private String codeList = "";
    /**
     *
     */
    private boolean drawBgFlag = false;
    /**
     *
     */
    private int rBg = 0;
    /**
     *
     */
    private int gBg = 0;
    /**
     *
     */
    private int bBg = 0;

    SecureRandom random = new SecureRandom();
    /**
     *
     * @param response response对象
     */
    public CaptchaImgCreater(HttpServletResponse response, HttpServletRequest request) {
        this.request = request;
        this.response = response;
        this.width = 13 * FONT_NUM + 15;
        this.iNum = FONT_NUM;
        this.codeList = CODE_LIST;
    }

    public String createRandImage() throws IOException {
        BufferedImage image = new BufferedImage(width, HEIGHT,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g = (Graphics2D)image.getGraphics();

        if (this.drawBgFlag) {
            g.setColor(new Color(rBg, gBg, bBg));
            g.fillRect(0, 0, width, HEIGHT);
        } else {
            g.setColor(getRandColor(200, 250));
            g.fillRect(0, 0, width, HEIGHT);

            for (int i = 0; i < 155; i++) {
                g.setColor(getRandColor(140, 200));
                int x = random.nextInt(width);
                int y = random.nextInt(HEIGHT);
                int xl = random.nextInt(12);
                int yl = random.nextInt(12);
                g.drawLine(x, y, x + xl, y + yl);
            }
        }

        g.setFont(new Font("Arial", Font.PLAIN, 25));

        String sRand = "";
        for (int i = 0; i < iNum; i++) {
            int rand = random.nextInt(codeList.length());
            String strRand = codeList.substring(rand, rand + 1);
            sRand += strRand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random
                    .nextInt(110), 20 + random.nextInt(110)));

            // 生成随机弧度
            int angle=random.nextInt(60)-30;// 角度正负30度
            double radian=angle*Math.PI/180;// 弧度
            //
            g.rotate(radian,13 * i + 6,25);

            g.drawString(strRand, 13 * i + 6, 25);
            g.rotate(-radian,13 * i + 6,25);
        }
        g.dispose();

        try {
            response.setContentType("image/jpg");
            ServletOutputStream out =this.response.getOutputStream();
            HttpSession session = request.getSession();
            session.setAttribute(Constant.SESSION_GENERATED_CAPTCHA_KEY, sRand);
            ImageIO.write(image, "JPEG",out);
        } catch (IOException e) {

        } finally {
            this.response.getOutputStream().close();
        }

        return sRand;
    }

    public void setBgColor(int r, int g, int b) {
        drawBgFlag = true;
        this.rBg = r;
        this.gBg = g;
        this.bBg = b;
    }

    private Color getRandColor(int fc, int bc) {
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    private Font getFont() {
        Font font[] = new Font[5];
        font[0] = new Font("Ravie", Font.PLAIN, 45);
        font[1] = new Font("Antique Olive Compact", Font.PLAIN, 45);
        font[2] = new Font("Forte", Font.PLAIN, 45);
        font[3] = new Font("Wide Latin", Font.PLAIN, 40);
        font[4] = new Font("Gill Sans Ultra Bold", Font.PLAIN, 45);
        return font[random.nextInt(5)];
    }
}
