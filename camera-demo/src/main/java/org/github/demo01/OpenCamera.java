package org.github.demo01;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import javax.swing.*;

/**
 * 打开摄像头
 *
 * @author wenfs
 * @date 2020/5/23 11:04
 */
public class OpenCamera {
    public static void main(String[] args) throws FrameGrabber.Exception, InterruptedException {
        // 初始化摄像头
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        // 开始获取摄像头数据
        grabber.start();
        // 新建一个窗口
        CanvasFrame canvas = new CanvasFrame("摄像头");
        // 设置关闭窗口时销毁窗口
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 窗口置顶
        canvas.setAlwaysOnTop(true);
        while (true) {
            //窗口是否关闭
            if (!canvas.isDisplayable()) {
                //停止抓取
                grabber.stop();
                //退出
                System.exit(2);
            }
            // 获取摄像头图像的一帧图像
            Frame frame = grabber.grab();
            //获取摄像头图像并放到窗口上显示，
            canvas.showImage(frame);
            //50毫秒刷新一次图像
            Thread.sleep(50);
        }
    }
}

