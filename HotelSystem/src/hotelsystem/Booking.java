/*Name: Manal Fathi hussie
  ID: 1706943
  Section: C05
  Email :mm0047.stu@uj.edu.sa*/

package hotelsystem;

import java.util.*;

public class Booking {

    private Visitors quest;
    private Room questRoom;
    private String refrenceNumber;
    private Date checkIn;
    private Date checkOut;
    private ArrayList<Service> questService = new ArrayList<Service>();

    public Booking() {

    }

    public Booking(Visitors quest, Room questRoom, Date checkIn, Date checkOut, String refrenceNumber) {
        this.quest = quest;
        this.questRoom = questRoom;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.questService = questService;
        this.refrenceNumber = refrenceNumber;
    }
//setters

    public void setQuest(Visitors quest) {
        this.quest = quest;
    }

    public void setQuestRoom(Room questRoom) {
        this.questRoom = questRoom;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
//getters

    public Visitors getQuest() {
        return quest;
    }

    public Room getQuestRoom() {
        return questRoom;
    }

    public String getRefrenceNumber() {
        return refrenceNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public ArrayList<Service> getQuestService() {
        return questService;
    }

//addSrevice
    public void AddSrevice(String Type, double price) {
        questService.add(new Service(Type, price));
    }
    //tostring

    public String toString() {
        String string = "******Booking Refrence number : " + getRefrenceNumber();
        string += " ******Guest information : + " + getQuest();
        string += "  ******Check in Day : " + checkIn.getDate() + " Month : " + checkIn.getMonth() + " Year : " + checkIn.getYear();
        string += " Check out Day : " + checkOut.getDate() + " Month : " + checkOut.getMonth() + " Year : " + checkOut.getYear();
        string += getQuestRoom();
        return string;
    }
}

