package tut.spring;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CustomerMockedData {

    private static List<Customer> customerlist;

    private static CustomerMockedData instance = null;
    public static CustomerMockedData getInstance(){
        if (instance==null){
            instance = new CustomerMockedData();
        }
        return instance;
    }

    public CustomerMockedData(){
        customerlist = new ArrayList<Customer>();
        customerlist.add(new Customer(1, "one", "HDFC", "E"));
        customerlist.add(new Customer(2, "two", "HDFC", "E"));
    }

    public List<Customer> fetchCustomers(){
        return customerlist;
    }


    public static Customer getCustomerById(int id){
        for(Customer x: customerlist){
            if(x.getId()==id){
                return x;
            }
        }
        return null;
    }

    public static List<Customer> searchCustomers(String query){
        List<Customer> searchResult = new ArrayList<Customer>();
        for(Customer x: customerlist){
            if(x.getName().toLowerCase().contains(query.toLowerCase()) ||
            x.getBankName().toLowerCase().contains(query.toLowerCase()) ||
            x.getRepaymentOption().toLowerCase().contains(query.toLowerCase())){
                searchResult.add(x);
            }
        }
        return searchResult;
    }

    public Customer createCustomer(int id, String name, String bank_name, String repayment_option){
        Customer newCustomer = new Customer(id, name, bank_name, repayment_option);
        customerlist.add(newCustomer);
        return newCustomer;
    }

    public Customer updateCustomer(int id, String name, String bank_name, String repayment_option){
        for(Customer x: customerlist){
            if(x.getId() == id){
                int customerIndex = customerlist.indexOf(x);
                x.setName(name);
                x.setBankName(bank_name);
                x.setRepaymentOption(repayment_option);
                customerlist.set(customerIndex, x);
                return x;
            }
        }
        return null;
    }

    public boolean delete(int id){
        int customerIndex = -1;
        for(Customer x: customerlist){
            if(x.getId()==id){
                customerIndex=customerlist.indexOf(x);
                continue;
            }
        }
        if(customerIndex >= -1){
            customerlist.remove(customerIndex);
        }
        return true;
    }
}
