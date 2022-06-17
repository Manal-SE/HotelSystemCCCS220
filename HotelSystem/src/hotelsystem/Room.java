/*Name: Manal Fathi hussie
  ID: 1706943
  Section: C05
  Email :mm0047.stu@uj.edu.sa*/

package hotelsystem;

import java.util.*;

public class Room {
    
    protected int floor;
    protected int Room_number;
    protected int night_Rate;
    protected double price;
    protected static ArrayList<Booking> reserved = new ArrayList<Booking>();

    //consturctor
    public Room() {
    }

    public Room(int floor, int Room_number, double price) {
        this.floor = floor;
        this.Room_number = Room_number;
        this.price = price;

    }

    //getter
    public int getFloor() {
        return floor;
    }

    public int getRoom_number() {
        return Room_number;
    }

    public int getNight_Rate() {
        return night_Rate;
    }

    public double getPrice() {
        return price;
    }
 
    public static ArrayList<Booking> getReserved() {
        return reserved;
    }
        
   
    //setter
    public void setPrice(double price) {
        this.price = price;
    }

    public void setNight_Rate(int night_Rate) {
        this.night_Rate = night_Rate;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setRoom_number(int Room_number) {
        this.Room_number = Room_number;
    }
    
 //Service methods
    
   public int CalculateNight_Rate(Date in, Date Out) {
        if (in.getMonth() == Out.getMonth() && Out.getYear() == Out.getYear()) {
            if (in.getDate() == Out.getDate()) {
                setNight_Rate(0);
                return 0;
            } else {
                setNight_Rate(Out.getDate() - in.getDate());
                return Out.getDate() - in.getDate();
            }
        } else {
            setNight_Rate((int) Math.ceil(Out.getTime() - in.getTime()));
            return (int) Math.ceil(Out.getTime() - in.getTime());
        }
    }
 
   public double CalculatePrice(ArrayList<Room> rooms) {
        return price;
    }

    public static void AddReserve(Booking booking) {
        reserved.add(booking);
    }

    public static void CancelReserve(Booking booking) {
        reserved.remove(booking);
    }

    @Override
    public String toString() {
        return " ******Room information :  Room number: " + Room_number + ", Floor: " + floor;
    }

}


