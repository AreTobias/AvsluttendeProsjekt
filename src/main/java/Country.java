public class Country {

    private String name;
    private String capital;
    private double population;
    private float area;
    private String language;
    private String currency;

    public Country(String name, String capital, double population, float area, String language, String currency){
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.language = language;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public double getPopulation() {
        return population;
    }

    public float getArea() {
        return area;
    }

    public String getLanguage() {
        return language;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCapital() { return capital; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setAreal(int areal) {
        this.area = areal;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
