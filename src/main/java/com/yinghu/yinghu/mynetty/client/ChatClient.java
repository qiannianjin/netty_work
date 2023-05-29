package com.yinghu.yinghu.mynetty.client;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame {
    private static ChatClient instance;
    private static final String HOST = "localhost";
    private static final int PORT = 8000;

    private JTextArea ta = new JTextArea(20, 60);
    private JTextField tf = new JTextField(55);

    private ExecutorService executor;

    private ChatClient() {
        // 居中显示窗体
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ta.setEditable(false);
        ta.setLineWrap(true);
        JScrollPane sp = new JScrollPane(ta);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(sp, BorderLayout.CENTER);

        tf.addKeyListener(new KeyAdapter() {
            // ...
        });
        add(tf, BorderLayout.SOUTH);

        setSize(600, 400);
        setVisible(true);
    }

    private static ChatClient getInstance() {
        if (instance == null) {
            instance = new ChatClient();
        }
        return instance;
    }

    public static void main(String[] args) {
        ChatClient client = getInstance();
        client.init();
    }

    private void init() {
        // 连接服务器
        try {
            Socket socket = new Socket(HOST, PORT);
            // 获取输入输出流
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // 读取服务器消息
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    String msg = null;
                    try {
                        msg = in.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if (msg != null) {
                        ta.append(LocalDateTime.now() + " " + msg + "\n");
                    }
                }
            }, 0, 100);

            executor = Executors.newSingleThreadExecutor();
            // 发送消息TimerTask
            timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    String msg = tf.getText();
                    if (!msg.isEmpty()) {
                        executor.execute(() -> {
                            out.println(msg);
                            ta.append(LocalDateTime.now() + " 我:" + msg + "\n");
                            tf.setText("");
                        });
                    }
                }
            }, 0, 100);
        } catch (IOException e) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "连接服务器失败!");
        }
    }
}
