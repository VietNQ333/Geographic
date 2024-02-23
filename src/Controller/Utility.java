package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class Utility { 
    public final String PHONE_PATTERN="^[\\d]{10,13}$";
    public final String EMAIL_PATTERN="^[a-zA-Z]\\w+@\\w+(\\.\\w+){1,2}$";
    public final String[] COURSES_LIST={"C/C++","Java",".Net"};
    Scanner sc = new Scanner(System.in);
    
    public int GetInt(String msg, int min,int max){
        int i;
        
        do{
            System.out.print(msg);
            try {
                i=Integer.parseInt(sc.nextLine());
                if(i>=min && i<=max) return i;
                else System.out.println("Out of range");
                
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        }while(true);    
    }
    
    public double GetDouble(String msg, double min,double max){
        double i;
        do{
            System.out.print(msg);
            try {
                i=Double.parseDouble(sc.nextLine());
                if(i>=min && i<=max) return i;
                else System.out.println("Out of range");
                
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        }while(true);    
    }
    
    public double GetFloat(String msg, float min,float max){
        float i;
        do{
            System.out.print(msg);
            try {
                i=Float.parseFloat(sc.nextLine());
                if(i>=min && i<=max) return i;
                else System.out.println("Out of range");
                
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        }while(true);    
    }
    
    public String GetString(String msg,boolean isEmpty){      
        String s;
        do { 
            System.out.println(msg);
            s = sc.nextLine();
            if(isEmpty == true) return s;
            else{
                if(s.equals("")){
                    System.err.println("String must have atleast 1 character");
                } else return s;
            }
            
        } while (true);
    }
    
    public String GetYN(String msg){
        String s;
        do{
            System.out.print(msg);
            try {
                s=sc.next("[ynYN]");
                break;
            } catch (Exception e) {
                System.out.println(e);
                sc.nextLine();
            }
        }while(true);
        return (""+s.charAt(0)).toLowerCase();
    }
    
    public String GetStringByRegex(String msg,String Patt){
        String s;
        do{
            System.out.println(msg);
            try {
                s = sc.nextLine();
                if(Pattern.matches(Patt,s)==true)
                    return s;
            } catch (Exception e) {
                System.out.print(e);
            }
        }while(true);   
    }
    

    public Date GetDate(String msg){
        Date date = new Date();
        SimpleDateFormat SDF = new SimpleDateFormat("MMM-dd-yyyy"); // 01 02 03 ... 12
//      another format:  dd/MMM/yyyy Jan Feb Mar ... Dec,  dd/MMMM/yyyy January ... December
        SDF.setLenient(false);
//      Solve problem: 31/2/2001 -> 3/3/2001 | 2/3/2001(nam nhuan)
        do{
            System.out.println(msg);
            String sDate = sc.nextLine();
            try {
                date = SDF.parse(sDate);
                return date;
            } catch (ParseException e) {
                System.out.print(e);
            }
        }while(true);
        
    }
    
    public String getInArray(String[] acceptedList,String msg){
        String inputCourse="";
        do{
            inputCourse = this.GetString(msg, false);
            for(int i=0;i<acceptedList.length;++i){
                if(inputCourse.equalsIgnoreCase(acceptedList[i])){
                    return inputCourse;
                }
            }
            System.out.print("The accpeted List: ");
            for(int i=0;i<acceptedList.length;++i){
                    System.out.print(acceptedList[i]+" ");
            }
            System.out.println("");
        }while(true);
    }
    
    
}