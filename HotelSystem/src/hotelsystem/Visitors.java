/*Name: Manal Fathi hussie
  ID: 1706943
  Section: C05
  Email :mm0047.stu@uj.edu.sa*/

package hotelsystem;

public class Visitors {
    
    protected int ID;
    protected String name;
    protected String nationality;
    protected String email;
    protected long phone;

    //constructor
    public Visitors() {
    }

    public Visitors(int ID, String name, String nationality, String email, long phone) {
        this.ID = ID;
        this.name = name;
        this.nationality = nationality;
        this.email = email;
        this.phone = phone;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    //method printing
    public String toString() {
        String string = " ID: " + ID + ", Name: " + name;
        string += ", Nationality: " + nationality + ", Email: " + email + ", Phone: " + phone;
        return string;
    }

}


