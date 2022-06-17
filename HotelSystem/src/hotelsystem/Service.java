/*Name: Manal Fathi hussie
  ID: 1706943
  Section: C05
  Email :mm0047.stu@uj.edu.sa*/

package hotelsystem;


public class Service {

    private String ServiceType;
    private double ServicePrice;

//constructre
    public Service() {
    }

    public Service(String ServiceType, double ServicePrice) {
        this.ServiceType = ServiceType;
        this.ServicePrice = ServicePrice;
    }

    //Setter and getter
    public void setServiceType(String ServiceType) {
        this.ServiceType = ServiceType;
    }

    public void setServicePrice(double ServicePrice) {
        this.ServicePrice = ServicePrice;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public double getServicePrice() {
        return ServicePrice;
    }

    @Override
    public String toString() {
        return ServiceType + " : " + ServicePrice;
    }
}