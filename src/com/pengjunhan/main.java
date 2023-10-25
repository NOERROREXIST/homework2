package com.pengjunhan;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos; // 引入布局位置相关的包
import java.io.*;
import com.pengjunhan.T1.demo1;
import com.pengjunhan.T2.Main2;
import com.pengjunhan.T3.Main3;
import com.pengjunhan.T4.Main4;

public class main extends Application {
    private TextArea outputTextArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Text Processing App");

        outputTextArea = new TextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setStyle("-fx-text-fill: red;"); // 设置文本颜色为红色

        Button method1Button = new Button("主程序-子程序软件体系结构");
        Button method2Button = new Button("面向对象软件体系结构");
        Button method3Button = new Button("事件系统软件体系结构");
        Button method4Button = new Button("管道-过滤软件体系结构");

        method1Button.setOnAction(e -> processWithMethod1());
        method2Button.setOnAction(e -> processWithMethod2());
        method3Button.setOnAction(e -> processWithMethod3());
        method4Button.setOnAction(e -> processWithMethod4());

        HBox buttonBox = new HBox(10); // 使用水平框
        buttonBox.setAlignment(Pos.CENTER); // 设置按钮水平居中摆放
        buttonBox.getChildren().addAll(method1Button, method2Button, method3Button, method4Button);

        VBox root = new VBox(10);
        root.getChildren().addAll(outputTextArea, buttonBox);
        root.setAlignment(Pos.CENTER); // 设置主布局中间摆放

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void processWithMethod1() {
        outputTextArea.clear();
        demo1 kwic = new demo1();
        kwic.input("src\\input.txt");
        kwic.shift();
        kwic.alphabetizer();
        kwic.output("src\\output.txt");
        displayResults("Method 1 Results:", "src\\output.txt");

        // 在 GUI 最底端显示不同的一行文字，并将文本设置为红色
        outputTextArea.appendText("\n\n\n主程序-子程序软件体系结构是一种软件设计方法，其中主程序控制和协调多个子程序模块，以完成复杂任务。这有助于模块化和组织大型软件项目，提高可维护性。\n");
        outputTextArea.setStyle("-fx-text-fill: red;");
    }

    private void processWithMethod2() {
        outputTextArea.clear();
        Main2 main2 = new Main2();
        main2.main(new String[0]);
        displayResults("Method 2 Results:", "src\\output.txt");

        // 在 GUI 最底端显示不同的一行文字，并将文本设置为红色
        outputTextArea.appendText("\n\n\n面向对象软件体系结构是一种设计方法，基于对象的概念，将系统划分为相互独立的对象，通过对象之间的交互实现功能。这提高了代码的可重用性和扩展性。\n");
        outputTextArea.setStyle("-fx-text-fill: red;");
    }

    private void processWithMethod3() {
        outputTextArea.clear();
        Main3 main3 = new Main3();
        main3.main(new String[0]);
        displayResults("Method 3 Results:", "src\\output.txt");

        // 在 GUI 最底端显示不同的一行文字，并将文本设置为红色
        outputTextArea.appendText("\n\n\n" +
                "事件系统软件体系结构通过事件驱动机制协调组件间的通信。当事件发生时，触发适当的响应，实现松散耦合和高扩展性。\n");
        outputTextArea.setStyle("-fx-text-fill: red;");
    }

    private void processWithMethod4() {
        outputTextArea.clear();
        try {
            Main4.main(new String[0]);
            displayResults("Method 4 Results:", "src\\output.txt");

            // 在 GUI 最底端显示不同的一行文字，并将文本设置为红色
            outputTextArea.appendText("\n\n\n" +
                    "管道-过滤软件体系结构采用数据处理管道，每个过滤器负责特定任务，数据按顺序流经各个过滤器，实现数据处理和转换，提高可维护性。\n");
            outputTextArea.setStyle("-fx-text-fill: red;");
        } catch (IOException e) {
            outputTextArea.appendText("Error: " + e.getMessage());
        }
    }

    private void displayResults(String title, String outputFilePath) {
        outputTextArea.appendText(title + "\n");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(outputFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                outputTextArea.appendText(line + "\n");
            }
            reader.close();
        } catch (IOException e) {
            outputTextArea.appendText("Error: " + e.getMessage());
        }
    }
}

