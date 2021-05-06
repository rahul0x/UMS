package com.zakzayak;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends JFrame {
    public static void main(String[] args) {
        String str = "999999999999";
        try {
            int index = str.indexOf(".");
            String num = str.substring(0,index);
            String exp = str.substring(index+1);
            System.out.println(num);
            System.out.println(exp);
            long isInt = Long.parseLong(str);
            System.out.println(isInt);
        } catch (NumberFormatException n) {
            System.out.println("Not vaild");
        }
    }

}
