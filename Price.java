package com.example.qiuhaodong.refactor.data;

import java.util.logging.Logger;




abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);
}







class ChildrensPrice extends Price {
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}







class NewReleasePrice extends Price {
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    double getCharge(int daysRented) {
        return daysRented * 3;
    }
}







class RegularPrice extends Price {
    int getPriceCode() {
        return Movie.REGULAR;
    }

    double getCharge(int daysRented) {
        //Logger.getLogger("myLog").info("运行RegularPrice对象的getCharge"); //用于判断是否执行了子类的方法

        float result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }
}


