/*Name: Manal Fathi hussie
  ID: 1706943
  Section: C05
  Email :mm0047.stu@uj.edu.sa*/

package hotelsystem;

import java.util.*;

public class RoomStandard extends Room {
    
      private String bedType;
    private String view;

    public RoomStandard() {
        super();
    }

    public RoomStandard(int floor, int Room_number, double price, String view, String bedType) {
        super(floor, Room_number, price);
        this.bedType = bedType;
        this.view = view;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getBedType() {
        return bedType;
    }

    public String getView() {
        return view;
    }

    @Override
    public double CalculatePrice(ArrayList<Room> rooms) {
        int price = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) instanceof RoomStandard) {
                if (((RoomStandard) rooms.get(i)).Room_number == super.getRoom_number()) {
                    if (((RoomStandard) rooms.get(i)).getBedType().equals(getBedType())) {
                        if (((RoomStandard) rooms.get(i)).getView().equals(getView())) {
                            price += (super.getNight_Rate() * ((RoomStandard) rooms.get(i)).price);
                        }
                    }
                }
            }

        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + " This Room has a " + view + " view";/* and a " + bedType + " bed." ;*/
    }

}

