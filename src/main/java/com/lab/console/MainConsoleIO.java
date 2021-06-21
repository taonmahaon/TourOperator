package com.lab.console;

import com.lab.domain.Client;
import com.lab.domain.Order;

import java.util.Locale;
import java.util.Scanner;

import static java.util.UUID.randomUUID;

public class MainConsoleIO {
    TourConsoleIO tourConsoleOutput = new TourConsoleIO();
    ClientConsoleIO clientConsole = new ClientConsoleIO();
    OrderConsoleIO orderConsole = new OrderConsoleIO();
    Scanner scanner = new Scanner(System.in);
    private int tourNumber;
    private int duration;
    private int totalCost;

    public void menu(){
        System.out.println(new StringBuilder().append("Добро пожаловать!\n")
                .append("Из какого города вы обращаетесь?\n\n")
                .append("введите \"1\" если обращаетесь из Питера\n")
                .append("введите \"2\" если обращаетесь из Омска\n")
                .append("введите \"0\" если вы админ\n")
                .append("введите \"exit\" чтобы выйти\n"));
    }

    public void spb(){
        System.out.println("перевожу на Тур оператора \"Невский путешественник\"");
        System.out.println(tourConsoleOutput.tourList());
        System.out.println("выберете желаемый тур");
    }

    public void omsk(){
        System.out.println("перевожу на Тур оператора \"Омск - четвертый Рим!\"");
        System.out.print("Введите ваш домашний адрес: ");
        scanner.next();
        System.out.println("Не пытайтесь покинуть Омск!\n" +
                "к вам выехал наряд для воспитательной беседы");
    }

    public void admin(){
        System.out.print("введите пароль: ");
        String pass = scanner.next();
        if (pass.equals(tourConsoleOutput.getPass()))
            System.out.println("Привет админ");
        else {
            System.out.println("Неверный пароль. Перевожу в главное меню\n");
        }
    }

    public boolean tourDetail(){
        tourNumber = scanner.nextInt();
        tourConsoleOutput.outputTour(tourNumber);
        var chosenTour = tourConsoleOutput.get(tourNumber);
        if (chosenTour == null) {
            return false;
        }
        System.out.println("на сколько дней бронируем тур?");
        duration = scanner.nextInt();
        totalCost = duration * chosenTour.getDayPrice() + duration * chosenTour.getHotelPrice() + chosenTour.getTicketPrice();
        tourConsoleOutput.outputTour(tourNumber);
        System.out.println("Сумма к оплате: " + totalCost);
        return true;
    }

    public boolean orderProcedure(){
        while (true) {
            System.out.println("Подтверждаете бронирование? (Y / N)");
            var answer = scanner.next();
            if (answer.toLowerCase(Locale.ROOT).equals("y")) {
                System.out.print("Введите вашу Фамилию: ");
                String clientName = scanner.next();
                System.out.print("Введите вашу Имя: ");
                clientName += " " + scanner.next();
                System.out.println("\nВведите ваш Email: ");
                String clientEmail = scanner.next();
                var currentClient = clientConsole.create(new Client(
                        clientName, clientEmail));
                var orderNumber = String.valueOf(randomUUID());
                System.out.println("В ближайшее время с вами свяжется менеджер. Номер заказа: " + orderNumber);
                orderConsole.create(new Order(currentClient.getId(), tourNumber, duration, totalCost, orderNumber));
                return false;

            } else if (answer.toLowerCase(Locale.ROOT).equals("n")) {
                break;
            }
        }
        return true;
    }

    // TODO: admin CLI in second sprint
}
