package com.example.qiuhaodong.refactor.data;

import java.util.Enumeration;
import java.util.Vector;


public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    //生成详单
    public String statement() {

        Enumeration rentals = _rentals.elements();

        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            //显示本电影的数据
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        //统计的数据
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    private double getTotalCharge() {
        double totalCharge = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            totalCharge += each.getCharge();
        }
        return totalCharge;
    }

    private int getTotalFrequentRenterPoints() {
        int totalPoints = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            totalPoints += each.getFrequentRenterPoints();
        }
        return totalPoints;
    }
}
