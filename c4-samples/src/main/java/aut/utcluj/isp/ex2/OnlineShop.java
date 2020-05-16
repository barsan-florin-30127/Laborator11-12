package aut.utcluj.isp.ex2;

/**
 * @author stefan
 */
public class OnlineShop {
    private String webAddress;
    private String name;
    private String city;
    public OnlineShop(String name, String city, String webAddress) {
        this.webAddress=webAddress;
        this.city=city;
        this.name=name;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public OnlineShop() {

    }

    @Override
    public String toString() {
        return "Shop:  "+ name+ " City: "+city+
                " webAddress: " + webAddress ;
    }


    public String getWebAddress() {
        return webAddress;
    }


}
