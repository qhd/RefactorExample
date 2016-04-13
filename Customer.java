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

        double totalAmont = 0;
        int frequentRenterPoints = 0;

        Enumeration rentals = _rentals.elements();

        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            thisAmount = each.getCharge();

            //积分加一
            frequentRenterPoints++;

            //如果是新片租两天以上，则积分再加一
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            //显示本电影的数据
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmont += thisAmount;
        }

        //统计的数据
        result += "Amount owed is " + String.valueOf(totalAmont) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }
}
