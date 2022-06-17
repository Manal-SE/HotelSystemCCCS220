/*Name: Manal Fathi hussie
  ID: 1706943
  Section: C05
  Email :mm0047.stu@uj.edu.sa*/

package hotelsystem;

public class VIP extends Visitors{

    private int VIPid;

//constructer
    public VIP(int ID, String name, String nationality, String email, long phone, int VIPid) {
        super(ID, name, nationality, email, phone);
        this.VIPid = VIPid;
    }

    public int getVIPid() {
        return VIPid;
    }

    public void setVIPid(int VIPid) {
        this.VIPid = VIPid;
    }

    public String toString() {
        return "This Visitor is a VIP \n" + super.toString() + " VIPID: " + VIPid;
    }
}