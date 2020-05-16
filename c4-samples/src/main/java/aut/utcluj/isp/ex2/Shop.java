package aut.utcluj.isp.ex2;

/**
 * @author stefan
 */
public class Shop extends OnlineShop {
    public String name;
    public String city;

    public Shop(String name, String city) {
        super.getWebAddress();
        this.city=city;
        this.name=name;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public Shop(){}

    @Override
    public String toString() {
        return "Shop: " + name  +
                " City: " + city  ;
    }


    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

}

class ex2 {
    public static void main(String[] args) {

        Shop shop= new Shop("eMag","Cluj");
        OnlineShop onlineShop=new OnlineShop(shop.getName(),shop.getCity(),"https://www.emag.ro");

        System.out.println(onlineShop.toString());
        System.out.println( onlineShop.getWebAddress());
        System.out.println(shop.toString());



    }
}
