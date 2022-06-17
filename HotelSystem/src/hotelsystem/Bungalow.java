/*Name: Manal Fathi hussie
  ID: 1706943
  Section: C05
  Email :mm0047.stu@uj.edu.sa*/

package hotelsystem;

import java.util.*;

 public class Bungalow extends Room {
    
    private int nOfRooms;
    private String outdoor;

    public Bungalow() {
        super();
    }

    public Bungalow(int floor, int Room_number, double price, int nOfRooms, String outdoor) {
        super(floor, Room_number, price);
        this.nOfRooms = nOfRooms;
        this.outdoor = outdoor;
    }

    public void setnOfRooms(int nOfRooms) {
        this.nOfRooms = nOfRooms;
    }

    public void setOutdoor(String outdoor) {
        this.outdoor = outdoor;
    }

    public int getnOfRooms() {
        return nOfRooms;
    }

    public String getOutdoor() {
        return outdoor;
    }

    @Override
    public double CalculatePrice(ArrayList<Room> rooms) {
        int price = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) instanceof Bungalow) {
                if (((Bungalow) rooms.get(i)).Room_number == super.getRoom_number()) {
                    if (((Bungalow) rooms.get(i)).getnOfRooms() == getnOfRooms()) {
                        if (((Bungalow) rooms.get(i)).getOutdoor().equals(getOutdoor())) {
                            price += (super.getNight_Rate() * ((Bungalow) rooms.get(i)).price);
                        }
                    }
                }
            }

        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + " This Room is a Bungalow with a " + outdoor;
    }

}