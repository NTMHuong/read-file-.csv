package com.codegym;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    private static CountryManagement countryManagement = new CountryManagement();

    public static void main(String[] args) {
        int choice;
        do{
            menu();
            System.out.println("Nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: {
                    showAllCountry();
                    break;
                }
                case 2: {
                    addNewCountry();
                    break;
                }
                case 3: {
                    readFile();
                    break;
                }
                case 4: {
                    writeFile();
                    break;
                }
            }

        }while (choice != 0);
    }

    private static void writeFile() {
        try {
            countryManagement.writeCountryListToFile("country.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile() {
        try {
            countryManagement.readCountryListToFile("country.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addNewCountry() {
        System.out.println("Nhập id: ");
        String id = sc.nextLine();
        System.out.println("Nhập code của guốc gia: ");
        String code = sc.nextLine();
        System.out.println("Nhập tên quốc gia: ");
        String name = sc.nextLine();
        Country country = new Country(id, code, name);
        countryManagement.addCountry(country);
    }

    private static void showAllCountry() {
        countryManagement.showAll();
    }

    private static void menu() {
        System.out.println("----Menu---");
        System.out.println("1. Hiển thị danh sách");
        System.out.println("2. Thêm quốc gia");
        System.out.println("3. Đọc danh sách quốc gia có sẵn trong danh sách");
        System.out.println("4. Ghi danh sách quốc gia hiện có sẵn ra file");
        System.out.println("0. Thoát");
    }
}
