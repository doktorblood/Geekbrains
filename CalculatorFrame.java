import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame {
    // Переменные для осуществления арифметических действий
    double num1;
    double num2;
    String operation;
    double result;

    // Конструктор класса

    public  CalculatorFrame() {
        JFrame frame = new JFrame("TipaCalc"); //Создаем главное окно
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); //Задаем действие при закрытии
        frame.setLayout(new FlowLayout(FlowLayout.CENTER)); //Задаем расположение компонентов
        frame.setBounds(100,100,450,100); // Задаем размеры окна
        //2 текстовых поля шириной 10 символов - для ввода чисел
        JTextField field1 = new JTextField("0", 10);
        JTextField field2 = new JTextField("0", 10);
        //Поле для вывода результата
        JLabel label = new JLabel("RESULT = ");
        //Кнопки для выбора действия и получения результата
        JButton but1 = createButton(); //Для этой кнопки есть метод
        JButton but2 = new JButton(" = ");
        //Для второй кнопки надо добавить действие
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = (double) (Double.parseDouble(field1.getText())); // Получаем число из первого поля
                num2 = (double) (Double.parseDouble(field2.getText())); // Получаем число из второго поля
                result = calculate (num1, num2, operation); //Вычисляем результат
                label.setText("RESULT = " + Double.toString(result)); //Выводим его на панель
            }
        });
        //Добавляем все к основному окну
        frame.add(field1);
        frame.add(but1);
        frame.add(field2);
        frame.add(but2);
        frame.add(label);
        //Ах да, надо же выключить стелс-режим!
        frame.setVisible(true);
    }

    // Этот метод создает кнопку арифметического действия
    JButton createButton () {
        JButton but1 = new JButton(); // Сама кнопка
        JMenuBar bar = new JMenuBar(); // К ней прикрепим меню
        JMenu mnu = new JMenu("Operation"); // Выпадающее меню

        // Пункты выбора действия
        JMenuItem sum = new JMenuItem("+");
        JMenuItem sub = new JMenuItem("-");
        JMenuItem mult = new JMenuItem("*");
        JMenuItem div = new JMenuItem("/");
        JMenuItem pow = new JMenuItem("^");
        // При выборе пункта меню меняем переменную operation и текст на кнопке
        sum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation = sum.getText();
                mnu.setText(operation);
            }
        });
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation = sub.getText();
                mnu.setText(operation);
            }
        });
        mult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation = mult.getText();
                mnu.setText(operation);
            }
        });
        div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation = div.getText();
                mnu.setText(operation);
            }
        });
        pow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation = pow.getText();
                mnu.setText(operation);
            }
        });
        //Добавляем пункты в меню
        mnu.add(sum);
        mnu.add(sub);
        mnu.add(mult);
        mnu.add(div);
        mnu.add(pow);
        // Добавляем меню в кнопку
        but1.add(bar);
        bar.add(mnu);
        return but1;
    }

    double calculate(double num1,double num2,String operation) {
        double res;
        if (operation == "^") {res = Math.pow(num1,num2);} //Перебираем возможные операции
        else if (operation == "-") {res = (num1-num2);}
        else if (operation == "*") {res = (num1*num2);}
        else if (operation == "/") {res = (num1/num2);}
        else {res = (num1+num2);} // По умолчанию будем складывать
        return res;
    }
}
