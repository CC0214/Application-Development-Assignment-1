package DiscountRate;

//--------------------------------------------------------------------
//Assignment 1
//Written by: Xin ZHAO 2152461
//For Application Development 2 (Mobile) - Winter 2022
//https://github.com/CC0214/Application-Development-Assignment-1
//--------------------------------------------------------------------

import java.util.Date;

public class Visit {

    private Customer name;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(Customer name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getCustomerName() {
        return name.getName();
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = this.serviceExpense + serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = this.productExpense + productExpense;
    }

    public double getTotalExpense() {
        return  (serviceExpense - (serviceExpense * Discount.getServiceDiscountRate(name.getMemberType()))) +
                (productExpense - (productExpense * Discount.getProductDiscountRate(name.getMemberType())));

    }

    @Override
    public String toString() {
        return "Visit{" +
                "customer name=" + name.getName() +
                ", customer member=" + name.isMember() +
                ", customer member type=" + name.getMemberType() +
                ", date=" + date +
                ", serviceExpense=" + serviceExpense +
                ", productExpense=" + productExpense +
                '}';
    }
}