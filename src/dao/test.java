package dao;

import factory.Factory;

public class test {
    public static void main(String []args) {

        try
        {
            int id;
            id = Factory.getIndentDAOInstance().getMaxIndentId();
            System.out.println(id);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
