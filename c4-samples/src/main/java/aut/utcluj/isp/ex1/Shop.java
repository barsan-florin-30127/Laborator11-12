package aut.utcluj.isp.ex1;

/**
 * @author stefan
 */
public class Shop {
    private String name;
    private String city;

    public Shop(String name, String city) {
        this.name=name;
        this.city=city;

    }

    public Shop(String name) {
        this.city = "";
        this.name=name;
       ;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
    public String toString(){
        return  String.format("Shop: %s City: %s",getName(), getCity());
    }
    public boolean equals(Object o){
        if(this==o) return  true;
        if (o==null || getClass()!=o.getClass()) return false;
        Shop shop=(Shop) o;
        return true;
    }
}