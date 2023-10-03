package org.example;

import io.netty.bootstrap.Bootstrap;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NettyClient {
    public static void main(String[] args) throws IOException {
        SocketChannel open = SocketChannel.open();
        open.socket().connect(new InetSocketAddress("localhost",8080));
        open.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("wo de di yi ci".getBytes());
        buffer.flip();
        open.write(buffer);
        open.shutdownOutput();
    }
}
