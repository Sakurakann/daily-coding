package org.sknn.nio.filecopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * org.sknn.nio.filecopy. User: Administrator. Date: 2018-03-02 12:48. Author:
 * Haiyangp.
 */
public class FileCopy {

  /**
   * 非阻塞式文件复制
   * @param src 源文件地址
   * @param dst 目的文件地址
   * @return 复制结果
   * @throws IOException 可能发生的错误
   */
  private boolean nioFileCopy(String src, String dst)
      throws IOException {

    // 文件输入通道.
    FileChannel srcFileChannel = new FileInputStream(new File(src))
        .getChannel();

    // 创建从中读取和向其写入(mode:可配置)的随机访问文件流, 该文件由 File 参数指定.
    // 其中mode参数: rw表示 readable+writable, 可读写的, 如果该文件不存在则创建.
    FileChannel dstFileChannel = new RandomAccessFile(new File(dst), "rw")
        .getChannel();

    //  将字节从给定的可读取字节通道传输到此通道的文件中.
    dstFileChannel.transferFrom(srcFileChannel, 0, srcFileChannel.size());

    return true;
  }

  private boolean commonFileCopy(String src, String dst)
      throws IOException {

    FileInputStream srcFileStream = new FileInputStream(new File(src));
    FileOutputStream dstFileStream = new FileOutputStream(new File(dst));

    byte[] buffer = new byte[1024];
    int len;
    while ((len = srcFileStream.read(buffer)) != -1) {
      dstFileStream.write(buffer, 0, len);
      dstFileStream.flush();
    }
    return true;
  }

  private boolean commonBufferFileCopy(String src, String dst)
      throws IOException {
    BufferedInputStream srcBufferedInput = new BufferedInputStream(
        new FileInputStream(new File(src)));
    BufferedOutputStream dstBufferedOutput = new BufferedOutputStream(
        new FileOutputStream(new File(dst)));

    byte[] buffer = new byte[1024];
    int len;
    while ((len = srcBufferedInput.read(buffer)) != -1) {
      dstBufferedOutput.write(buffer, 0, len);
      dstBufferedOutput.flush();
    }
    return true;
  }

  private boolean commonBufferReaderFileCopy(String src, String dst)
      throws IOException {
    BufferedReader srcBufferedReader = new BufferedReader(
        new FileReader(new File(src)));
    BufferedWriter dstBufferedWriter = new BufferedWriter(
        new FileWriter(new File(dst)));
    String temp;
    while ((temp = srcBufferedReader.readLine()) != null) {
      dstBufferedWriter.write(temp);
      dstBufferedWriter.newLine();
      dstBufferedWriter.flush();
    }
    return true;
  }

  public static void main(String[] args) {
    FileCopy fileCopy = new FileCopy();
    try {
      boolean b = fileCopy.nioFileCopy("E:/cursor.sql", "E:/a.sql");
      System.out.println(b);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
