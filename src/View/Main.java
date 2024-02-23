package View;

import Controller.*;

public class Main extends Menu<String> {
    static String[] menu = {"Enter the information for 11 countries in Southeast Asia", "Display already information", "Search the country according to the entered country's name", "Display the information increasing with the country name", "Exit"};
    Utility utility = new Utility();
    ManageEastAsiaCountries m = new ManageEastAsiaCountries();
    public Main() {
        super("Country Managerments", menu);
    }     
    @Override
    public void execute(int n) {
       switch(n) {
                case 1:
                    if(m.canAdd() == true) {
                        String xCountryCode = utility.GetString("Enter Country Code: ", false);
                        
                        if( !m.isDuplicate(xCountryCode) ) {
                            String xCountryName = utility.GetString("Enter Country Name: ", false);
                            float xTotalArea = (float) utility.GetDouble("Enter Total Area: ", 0.0001, Double.POSITIVE_INFINITY);
                            String xCountryTerrain = utility.GetString("Enter Country Terrain: ", false); 
                            m.addCountry(xCountryCode, xCountryName, xTotalArea, xCountryTerrain);
                        }
                    } 
                break;
                case 2:
                    m.displayCountry();
                break;
                case 3:
                    String xName = utility.GetString("Enter name: ", false);
                    m.searchCountry(xName);
                break;
                case 4:
                    m.displaySortByCountryName();
                break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                break;
            default:
                System.out.println("Invalid choosen. Please try again!!");
            }
    }
    public static void main(String[] args) {
        Main mn = new Main();
        while (true){
            mn.run();
        }
        
    }
}
