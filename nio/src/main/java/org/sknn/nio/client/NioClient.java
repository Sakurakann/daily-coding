package org.sknn.nio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * org.sknn.nio.client. User: Administrator. Date: 2018-02-26 15:52. Author:
 * Haiyangp.
 */
public class NioClient {

  private Selector selector;

  private void initClient(String ip, int port) throws IOException {
    SocketChannel channel = SocketChannel.open();
    channel.configureBlocking(false);

    this.selector = Selector.open();

    // 客户端连接服务端, (正在进行, 实际上完成连接过程还需要channel.finishConnect())
    channel.connect(new InetSocketAddress(ip, port));

    channel.register(this.selector, SelectionKey.OP_CONNECT);
  }

  private void listen() throws IOException {
    while (true) {
      this.selector.select();
      // 获得selector中选中项的迭代器
      Iterator<SelectionKey> selectionKeyIterator = this.selector.selectedKeys()
          .iterator();

      while (selectionKeyIterator.hasNext()) {
        SelectionKey key = selectionKeyIterator.next();
        selectionKeyIterator.remove();

        // 选中项可连接
        if (key.isConnectable()) {
          SocketChannel channel = (SocketChannel) key.channel();

          // 如果正在连接
          if (channel.isConnectionPending()) {
            // 完成连接
            channel.finishConnect();
          }

          // 非阻塞
          channel.configureBlocking(false);

          channel.write(ByteBuffer.wrap(new String("来自客户端的消息")
              .getBytes()));
          channel.register(this.selector, SelectionKey.OP_READ);

          // 选中项可读
        } else if (key.isReadable()) {
          read(key);
        }
      }
    }
  }

  private void read(SelectionKey key) throws IOException {
    // 得到事件的Socket通道
    SocketChannel channel = (SocketChannel) key.channel();

    // 创建分配一个读取缓冲区
    ByteBuffer buffer = ByteBuffer.allocate(1024);

    // 将通道中的数据读取到缓冲区
    channel.read(buffer);

    byte[] data = buffer.array();
    String msg = new String(data).trim();

    System.out.println("收到服务端消息: " + msg);

    channel.write(ByteBuffer.wrap(new String("已收到消息" + msg)
        .getBytes("UTF-8")));
  }

  public static void main(String[] args) {
    NioClient nioClient = new NioClient();

    try {
      nioClient.initClient("localhost", 10241);
      nioClient.listen();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
