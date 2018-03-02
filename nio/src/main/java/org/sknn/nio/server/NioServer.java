package org.sknn.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package:
 * org.sknn.nio.server. User: Administrator. Date: 2018-02-26 14:18. Author:
 * Haiyangp.
 */
public class NioServer {

  // 通道管理器
  private Selector selector;

  private void initServer(int port) throws IOException {
    // 开启一个ServerSocket通道
    ServerSocketChannel socketChannel = ServerSocketChannel.open();

    // 设置通道为非阻塞式
    socketChannel.configureBlocking(false);

    // 将通道对应的socket绑定至端口
    ServerSocket socket = socketChannel.socket();
    socket.bind(new InetSocketAddress(port));

    // 获得一个通道选择器
    this.selector = Selector.open();

    // 注册(绑定)通道管理器, 并为该通道设置OP_ACCEPT事件.
    // 注册该事件后, 当该事件到达时, selector.select()会返回, 没有则一直阻塞.
    socketChannel.register(this.selector, SelectionKey.OP_ACCEPT);

    System.out.println("服务端启动成功");
  }

  private void listen() throws IOException {

    while (true) {

      // 当注册方法到达时, 方法返回, 否则一直阻塞.
      this.selector.select();

      // 获得selector中选中项的迭代器, 选中项为注册的事件
      Iterator<SelectionKey> selectionKeyIterator = this.selector.selectedKeys()
          .iterator();
      while (selectionKeyIterator.hasNext()) {
        SelectionKey key = (SelectionKey) selectionKeyIterator.next();
        // 移除已选的key, 防止重复处理
        selectionKeyIterator.remove();

        // 客户端请求事件
        if (key.isAcceptable()) {
          ServerSocketChannel serverChannel = (ServerSocketChannel) key
              .channel();

          // 获得和客户端连接的通道
          SocketChannel channel = serverChannel.accept();

          // 设置为非阻塞式通道
          channel.configureBlocking(false);

          // 向客户端发送消息
          channel.write(ByteBuffer.wrap(new String("可以向客户端发送消息")
              .getBytes("UTF-8")));

          // 和客户端建立连接后, 为了接收客户端的消息, 需要给通道设置读的权限
          channel.register(this.selector, SelectionKey.OP_READ);

          // 可读事件
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

    System.out.println("收到客户端消息: " + msg);

    channel.write(ByteBuffer.wrap(new String("已收到消息" + msg)
        .getBytes("UTF-8")));
  }

  public static void main(String[] args) {
    NioServer nioServer = new NioServer();
    try {
      nioServer.initServer(10241);
      nioServer.listen();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
