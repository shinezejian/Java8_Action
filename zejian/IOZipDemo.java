package com.zejian;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static net.mindview.util.Print.print;

/**
 * Created by zejian on 2017/5/2.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class IOZipDemo {

    static String fileString_1="/Users/zejian/Downloads/Java8_Action/src/main/java/com/zejian/ClassCast.java";
    static String fileString_2="/Users/zejian/Downloads/Java8_Action/src/main/java/com/zejian/ClassInitialization.java";
    static String fileString_3="/Users/zejian/Downloads/Java8_Action/src/main/java/com/zejian/ClazzDemo.java";

    //文件夹
    static String fileString_4="/Users/zejian/Downloads/Java8_Action/src/main/java/com/zejian";

    public static void main(String[] args) throws Exception {
        zipOutStreamSingleFile();
        zipOutStreamMutilFile();
        zipInputStreamSingleFile();
        zipInputStreamMutilFile();
    }

    /**
     * 压缩单个文件
     * @throws Exception
     */
    public static void zipOutStreamSingleFile() throws Exception{
        File file = new File(fileString_1);
        File zipFile = new File("singleFile.zip");
        InputStream input = new FileInputStream(file);
        //创建压缩流
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        //为压缩文件前做准备工作,ZipEntry用于封装当前要压缩文件的信息,如设置被压缩文件名称,
        zipOut.putNextEntry(new ZipEntry(file.getName()));
        // 设置注释
        zipOut.setComment("zip singleFile");
        int temp = 0;
        while((temp = input.read()) != -1){
            zipOut.write(temp);//开始压缩
        }
        input.close();
        zipOut.close();
    }

    /**
     * 一次压缩多个文件
     * @throws Exception
     */
    public static void zipOutStreamMutilFile() throws Exception{
        // 要被压缩的文件夹
        File file = new File(fileString_4);
        File zipFile = new File("zipMutilFile.zip");
        InputStream input = null;
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        zipOut.setComment("zip mutil file");
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i = 0; i < files.length; ++i){
                input = new FileInputStream(files[i]);
                zipOut.putNextEntry(new ZipEntry(file.getName()
                        + File.separator + files[i].getName()));
                int temp = 0;
                while((temp = input.read()) != -1){
                    zipOut.write(temp);
                }
                input.close();
            }
        }
        zipOut.close();
    }

    /**
     * 解压单个文件
     * @throws Exception
     */
    public static void zipInputStreamSingleFile () throws Exception{
        //获取要解压的问题
        File file = new File("singleFile.zip");
        //解压文件的名称
        File outFile = new File("unZipSingleFile.txt");
        //使用zipFile解压
        ZipFile zipFile = new ZipFile(file);
        //获取解压文件的信息
        ZipEntry entry = zipFile.getEntry("ClassCast.java");//ClassCast.java 为压缩包中文件的名称
        //获取解压流
        InputStream input = zipFile.getInputStream(entry);
        //写入unZipSingleFile.txt
        OutputStream output = new FileOutputStream(outFile);
        int temp = 0;
        while((temp = input.read()) != -1){
            output.write(temp);
        }
        input.close();
        output.close();
    }

    /**
     * 解压多个文件
     * @throws Exception
     */
    public static void zipInputStreamMutilFile () throws Exception{

        File file = new File("zipMutilFile.zip");
        File outFile = null;
        //获取解压文件对象
        ZipFile zipFile = new ZipFile(file);
        //获取解压流
        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = null;
        InputStream input = null;
        OutputStream output = null;

        //方法1:循环每个要解压的文件
        Enumeration e = zipFile.entries();
        while(e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry)e.nextElement();
            print("File: " + ze2);
            outFile = new File("ze"+File.separator+ze2.getName());
            if(!outFile.getParentFile().getParentFile().exists()){
                outFile.getParentFile().getParentFile().mkdir();
            }
            if(!outFile.getParentFile().exists()){
                outFile.getParentFile().mkdir();
            }
            if(!outFile.exists()){
                outFile.createNewFile();
            }
            //获取解压流
            input = zipFile.getInputStream(ze2);
            output = new FileOutputStream(outFile);
            int temp = 0;
            while((temp = input.read()) != -1){
                output.write(temp);
            }
            input.close();
            output.close();
        }

        //方法2:循环每个要解压的文件
        while((entry = zipInput.getNextEntry()) != null){
            System.out.println("解压缩" + entry.getName() + "文件");//entry.getName()获得压缩包内的文件及文件路径（aaaa/bb.txt）
            outFile = new File( entry.getName());
            if(!outFile.getParentFile().exists()){
                outFile.getParentFile().mkdir();
            }
            if(!outFile.exists()){
                outFile.createNewFile();
            }
            //获取解压流
            input = zipFile.getInputStream(entry);
            output = new FileOutputStream(outFile);
            int temp = 0;
            while((temp = input.read()) != -1){
                output.write(temp);
            }
            input.close();
            output.close();
        }
    }
}
