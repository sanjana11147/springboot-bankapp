package tut.spring;

public class Customer {
    private int id;
    private String name;
    private String bank_name;
    private String repayment_option;

    public Customer(){}

    public Customer(int id, String name, String bank_name, String repayment_option) {
        this.setId(id);
        this.setName(name);
        this.setBankName(bank_name);
        this.setRepaymentOption(repayment_option);
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBankName(){
        return bank_name;
    }

    public void setBankName(String bank_name){
        this.bank_name = bank_name;
    }

    public String getRepaymentOption(){
        return repayment_option;
    }

    public void setRepaymentOption(String repayment_option){
        this.repayment_option = repayment_option;
    }

    @Override
    public String toString(){
        return "Customer{" +
                ", id:" + id +
                ", Name:" + name +
                ", Bank:" + bank_name +
                ", Repayment Option:" + repayment_option +
                "}";
    }

}
