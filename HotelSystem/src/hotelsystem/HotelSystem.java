/*Name: Manal Fathi hussie
  ID: 1706943
  Section: C05
  Email :mm0047.stu@uj.edu.sa*/
package hotelsystem;

import java.util.*;
import java.io.*;

public class HotelSystem {

    //Static arrays
    static ArrayList<Booking> AcceptedBookings = new ArrayList<Booking>();
    static ArrayList<File> InvoiceFiles = new ArrayList<File>();

    public static void main(String[] args) throws FileNotFoundException {

        //first file
        File inputRooms = new File("inputRoom.txt");
        //file exits
        if (!inputRooms.exists()) {
            System.out.print("File does not exits");
            System.exit(0);
        }

        //scanner 1
        Scanner input = new Scanner(inputRooms);

        //reading 1
        while (input.hasNext()) {
            //reading type
            String type = input.next();

            switch (type) {

                //first case ass room
                case "AddRoom": {
                    Add_Room(input.nextInt(), input.nextInt(), input.nextDouble(), input.next(), input.next());
                    break;
                }
                //2nd case add Bunglow
                case "AddBungalo": {
                    Add_Bungalow(input.nextInt(), input.nextInt(), input.nextDouble(), input.nextInt(), input.next());
                    break;
                }
                //3rd case add service
                case "AddService": {
                    Add_Service(input.next(), input.nextDouble());
                    break;
                }
                //quit
                case "quit": {
                    break;
                }
            }
        }
        input.close();
        //end of first file

//-----------------------------------------------------------------------------------------------------------          
//data field for file2
        Visitors vi = new Visitors();
        Room r = new RoomStandard();
        Room b = new Bungalow();

        //file2
        File inputPre = new File("inputprocedure.txt");

        //file exits
        if (!inputPre.exists()) {
            System.out.println("File does not exits");
            System.exit(0);
        }

        //scanner 2
        Scanner input2 = new Scanner(inputPre);
        //create new file
        File BookingFile = new File("BookingStatus.txt");

        //printer
        PrintWriter output1 = new PrintWriter(BookingFile);

        output1.println("--------------- Welcome to CS Hotel Management System ---------------");
        output1.println("--------------- Display All System Procedures ---------------");
        while (input2.hasNext()) {

            //readig the type
            String Type = input2.next();
            switch (Type) {
//case 1 reserve
                case "Reserve": {

                    output1.println();
                    output1.println();
                    //Sroom  
                    String RoomType = input2.next();
                    //reserve StandardRoom
                    if (RoomType.equalsIgnoreCase("StandardRoom")) {
                        //room
                        String bedType = input2.next();
                        String view = input2.next();
                        r = new RoomStandard(0, 0, 0, view, bedType);

                        //date
                        int YI = input2.nextInt();
                        int MI = input2.nextInt();
                        int DI = input2.nextInt();
                        int YO = input2.nextInt();
                        int MO = input2.nextInt();
                        int DO = input2.nextInt();

                        Date checkIn = new Date(YI, MI, DI);
                        Date checkOut = new Date(YO, MO, DO);

                        //visitor type
                        String VType = input2.next();
                        //VIP
                        if (VType.equalsIgnoreCase("V")) {

                            int ID = input2.nextInt();
                            String name = input2.next();
                            String natio = input2.next();
                            String mail = input2.next();
                            long number = input2.nextLong();
                            int VID = input2.nextInt();

                            vi = new VIP(ID, name, natio, mail, number, VID);
                        } //NOT VIP
                        else if (VType.equalsIgnoreCase("G")) {

                            int ID = input2.nextInt();
                            String name = input2.next();
                            String natio = input2.next();
                            String mail = input2.next();
                            long number = input2.nextLong();

                            vi = new Visitors(ID, name, natio, mail, number);
                        }

                        //genereate refrecne number
                        String FirstL = Character.toString(vi.name.charAt(0));
                        Random random = new Random();
                        String refrence = FirstL + vi.ID +random.nextInt(1000);

                        //check reserve
                        Booking booking = new Booking(vi, r, checkIn, checkOut, refrence);
                        Object checkedB = Reserve(booking);
                        //if available
                        if (checkedB instanceof Booking) {
                            AcceptedBookings.add((Booking) checkedB);
                            output1.println("Command BOOKING: Reserve a StandardRoom");
                            output1.println(((Booking) checkedB).toString());
                        } //not available
                        else {
                            output1.println("Command BOOKING: CONFLICT");
                            output1.println(" Sorry ! There is no available Stand room   ");
                            output1.print(" From Day : " + checkIn.getDate() + " Month : " + checkIn.getMonth() + " Year : " + checkIn.getYear());
                            output1.println(" To Day : " + checkOut.getDate() + " Month : " + checkOut.getMonth() + " Year : " + checkOut.getYear());

                        }
                    } //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\     
                    //reserve Bunglow
                    else if (RoomType.equals("Bungalow")) {
                        int noRooms = input2.nextInt();
                        String Outdoor = input2.next();
                        r = new Bungalow(0, 0, 0, noRooms, Outdoor);

                        //date
                        int YI = input2.nextInt();
                        int MI = input2.nextInt();
                        int DI = input2.nextInt();
                        int YO = input2.nextInt();
                        int MO = input2.nextInt();
                        int DO = input2.nextInt();

                        Date checkIn = new Date(YI, MI, DI);
                        Date checkOut = new Date(YO, MO, DO);

                        //visitor type
                        String VType = input2.next();

                        //VIP
                        if (VType.equalsIgnoreCase("V")) {
                            int ID = input2.nextInt();
                            String name = input2.next();
                            String natio = input2.next();
                            String mail = input2.next();
                            long number = input2.nextLong();
                            int VID = input2.nextInt();

                            vi = new VIP(ID, name, natio, mail, number, VID);
                        }

                        //NOT VIP
                        if (VType.equalsIgnoreCase("G")) {
                            int ID = input2.nextInt();
                            String name = input2.next();
                            String natio = input2.next();
                            String mail = input2.next();
                            long number = input2.nextLong();

                            vi = new Visitors(ID, name, natio, mail, number);
                        }

                        //genereate refrecne number
                        String FirstL = Character.toString(vi.name.charAt(0));
                        Random random = new Random();
                        String refrence = FirstL + vi.ID+ random.nextInt(1000);

                        //check reserve
                        Booking booking = new Booking(vi, r, checkIn, checkOut, refrence);
                        Object checkedB = Reserve(booking);

                        //if available
                        if (checkedB instanceof Booking) {
                            AcceptedBookings.add((Booking) checkedB);
                            output1.println("Command BOOKING: Reserve a Bungalow");
                            output1.println(((Booking) checkedB).toString());
                        } //not available
                        else {
                            output1.println("Command BOOKING: CONFLICT");
                            output1.println(" Sorry ! There is no available Bungalow   ");
                            output1.print(" From Day : " + checkIn.getDate() + " Month : " + checkIn.getMonth() + " Year : " + checkIn.getYear());
                            output1.println(" To Day : " + checkOut.getDate() + " Month : " + checkOut.getMonth() + " Year : " + checkOut.getYear());

                        }
                    }
                    break;
                }
                //CASE RESERVE END ----------------------------------------------------------------
                //Case seervice start -------------------------------------------------------------
                case "Service": {
                    int ID = input2.nextInt();
                    String SType = input2.next();
                    String toPrint = AddServiceVisitor(ID, SType);
                    output1.println();
                    output1.println();
                    output1.println("Command Add service: \n");
                    output1.println(toPrint);

                    break;
                }
                //CASE SERVICE END ----------------------------------------------------------------
                //Case invoice start -------------------------------------------------------------

                case "Print_Invoce": {
                    File Dfile = new File("AllInvoiceForAllGuests");
                    boolean done = Dfile.mkdir();

                    for (int i = 0; i < AcceptedBookings.size(); i++) {
                        PrintInvoice(AcceptedBookings.get(i));
                    }
                    break;
                }

                //CASE Invoice END ----------------------------------------------------------------
                case "Quit":
                    break;

            }
        }
        input2.close();
        output1.close();

    }
    //------------------------------------------------------------------------------------

    //Methods
    //arrayroom
    static ArrayList<Room> rooms = new ArrayList<Room>();

//method add room
    public static void Add_Room(int floor, int room, double price, String view, String bed) {
        rooms.add(new RoomStandard(floor, room, price, view, bed));
    }

//-------------------------------------------------------------------------------------------------
//method add bungalow
    public static void Add_Bungalow(int floor, int room, double price, int nOFrooms, String OutDoor) {
        rooms.add(new Bungalow(floor, room, price, nOFrooms, OutDoor));
    }

//-------------------------------------------------------------------------------------------------
    //array of service
    static ArrayList<Service> services = new ArrayList<Service>();

//add service method
    public static void Add_Service(String Stype, double Sprice) {
        services.add(new Service(Stype, Sprice));
    }

//-------------------------------------------------------------------------------------------------
    //reserve method
    public static <E> Object Reserve(E o) {

        //data fields
        Date dIn;
        Date dOut;
        boolean datecheckIn;
        boolean datecheckOut;

        //booking list from class room
        ArrayList<Booking> bookingA = new ArrayList<>();
        bookingA = Room.getReserved();

        //standard and orderd
        String Sbed;
        String SView;
        String orderdBed;
        String orderdView;
        int SnoRooms;
        String SoutDoor;
        int OrderdNoRooms;
        String OrderdOutDoor;

        //check
        if (o instanceof Booking) {
            //check if roomStandard or not
            if (((Booking) o).getQuestRoom() instanceof RoomStandard) {

                orderdBed = (((RoomStandard) ((Booking) o).getQuestRoom()).getBedType());
                orderdView = (((RoomStandard) ((Booking) o).getQuestRoom()).getView());

                //search for room number and floor number as same order
                for (int i = 0; i < rooms.size(); i++) {

                    if (rooms.get(i) instanceof RoomStandard) {
                        Sbed = ((RoomStandard) rooms.get(i)).getBedType();
                        SView = ((RoomStandard) rooms.get(i)).getView();

                        if (Sbed.equalsIgnoreCase(orderdBed) && SView.equalsIgnoreCase(orderdView)) {
                            ((Booking) o).setQuestRoom(((RoomStandard) rooms.get(i)));

                            //empty case
                            if (bookingA.isEmpty()) {
                                Room.reserved.add(((Booking) o));
                                return o;
                            } //not empty case
                            else {
                                //calling method
                                boolean check = Available(o);
                                if (check) {
                                    Room.reserved.add(((Booking) o));
                                    return o;
                                } else {
                                    continue;
                                }
                            }
                        }
                    }

                }
            } //check banglow or not
            else if (((Booking) o).getQuestRoom() instanceof Bungalow) {

                OrderdNoRooms = (((Bungalow) ((Booking) o).getQuestRoom()).getnOfRooms());
                OrderdOutDoor = (((Bungalow) ((Booking) o).getQuestRoom()).getOutdoor());

                //search for room number and floor number as same order
                for (int i = 0; i < rooms.size(); i++) {

                    if (rooms.get(i) instanceof Bungalow) {
                        SnoRooms = ((Bungalow) rooms.get(i)).getnOfRooms();
                        SoutDoor = ((Bungalow) rooms.get(i)).getOutdoor();

                        if ((SnoRooms == OrderdNoRooms) && SoutDoor.equalsIgnoreCase(OrderdOutDoor)) {
                            ((Booking) o).setQuestRoom(((Bungalow) rooms.get(i)));

                            if (bookingA.isEmpty()) {
                                Room.AddReserve(((Booking) o));
                                return o;
                            } //not empty case
                            else {
                                boolean check = Available(o);

                                //if available check == true
                                if (check) {
                                    Room.reserved.add(((Booking) o));
                                    return o;
                                } //if not available check == false
                                else {
                                    continue;
                                }
                            }
                        }
                    }

                }
            }
        }
        return "Conflict";

    }

//------------------------------------------------------------------------------------------------
    //available method
    public static boolean Available(Object o) {

        Date orderI = ((Booking) o).getCheckIn();
        Date orderO = ((Booking) o).getCheckOut();
        int count = 0;
        
        if (o instanceof Booking) {

            for (int i = 0; i < Room.getReserved().size(); i++) {
                
                //---------------------------------------------------------------------------------------
                
                if (Room.getReserved().get(i).getQuestRoom() instanceof RoomStandard && ((Booking) o).getQuestRoom() instanceof RoomStandard) {
                    String bed = ((RoomStandard) Room.getReserved().get(i).getQuestRoom()).getBedType();
                    String view = ((RoomStandard) Room.getReserved().get(i).getQuestRoom()).getView();
                    String Obed = (((RoomStandard) ((Booking) o).getQuestRoom()).getBedType());
                    String Oview = (((RoomStandard) ((Booking) o).getQuestRoom()).getView());
                    int floorNo = ((RoomStandard) Room.getReserved().get(i).getQuestRoom()).floor;
                    int roomNo = ((RoomStandard) Room.getReserved().get(i).getQuestRoom()).Room_number;
                    int OfloorNo = (((RoomStandard) ((Booking) o).getQuestRoom()).getFloor());
                    int OroomNo = (((RoomStandard) ((Booking) o).getQuestRoom()).getRoom_number());

                    if (bed.equalsIgnoreCase(Obed) && view.equalsIgnoreCase(Oview) && roomNo == OroomNo && OfloorNo == floorNo) {
                        Date dateI = Room.getReserved().get(i).getCheckIn();
                        Date dateO = Room.getReserved().get(i).getCheckOut();
                        boolean datecheck1 = orderI.before(dateI) && orderO.before(dateI);
                        boolean datecheck2 = orderI.after(dateO);
                        if (!(datecheck1 || datecheck2)) {
                            count++;
                        }
                    }
                } //---------------------------------------------------------------------------------------
                else if (Room.getReserved().get(i).getQuestRoom() instanceof Bungalow && ((Booking) o).getQuestRoom() instanceof Bungalow) {
                    int rooms = ((Bungalow) Room.getReserved().get(i).getQuestRoom()).getnOfRooms();
                    String Outdoor = ((Bungalow) Room.getReserved().get(i).getQuestRoom()).getOutdoor();
                    int Orooms = (((Bungalow) ((Booking) o).getQuestRoom()).getnOfRooms());
                    String Ooutdoor = (((Bungalow) ((Booking) o).getQuestRoom()).getOutdoor());
                    int room = ((Bungalow) Room.getReserved().get(i).getQuestRoom()).Room_number;
                    int Oroom = (((Bungalow) ((Booking) o).getQuestRoom()).getRoom_number());

                    if (Outdoor.equalsIgnoreCase(Ooutdoor) && rooms == Orooms && room == Oroom) {
                        Date dateI = Room.getReserved().get(i).getCheckIn();
                        Date dateO = Room.getReserved().get(i).getCheckOut();
                        boolean datecheck1 = orderI.before(dateI) && orderO.before(dateI);
                        boolean datecheck2 = orderI.after(dateO);
                        if (!(datecheck1 || datecheck2)) {
                            count++;
                        }
                    }
                }
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }

    }

//-----------------------------------------------------------------------------------------------------\
    //add service method
    public static String AddServiceVisitor(int ID, String Service) {
        
        int id = ID;
        String Type = Service;
        String print = "";
        
        for (int j = 0; j < services.size(); j++) {
            
            String St = services.get(j).getServiceType();
            
            if (St.equalsIgnoreCase(Type)) {
                double Sp = services.get(j).getServicePrice();

                for (int i = 0; i < Room.reserved.size(); i++) {
                    if (AcceptedBookings.get(i).getQuest().ID == id) {
                        
                        AcceptedBookings.get(i).AddSrevice(Type, Sp);
                        print = " The Guest:" + AcceptedBookings.get(i).getQuest().getName();
                        print += " in Room/Bungalow: " + AcceptedBookings.get(i).getQuestRoom().getRoom_number();
                        print += " floor: " + AcceptedBookings.get(i).getQuestRoom().getFloor();
                        print += " Ask for Service: " + St ;
                    }
                }
            }
        }
        return print;
    }

//-----------------------------------------------------------------------------------------------------
    //print invoice method
    public static void PrintInvoice(Booking o) throws FileNotFoundException {

        String FileName = o.getQuest().getName().substring(0, 2);
        FileName += o.getQuest().getID() + "_Guest_Invoice";

        //file creat and printer
        File NFile = new File("AllInvoiceForAllGuests", FileName + ".txt");
        InvoiceFiles.add(new File("AllInvoiceForAllGuests", FileName + ".txt"));

        PrintWriter OutputI = new PrintWriter(NFile);
        Date currentDate = new Date();

        //print
        OutputI.println("--------------- Welcome to CS Hotel Management System ---------------");
        OutputI.println("--------- Current Date :  " + currentDate.toString() + "--------");
        OutputI.println("Command: Print_Invoice");
        OutputI.println(" Guest name : " + o.getQuest().getName());
        OutputI.println(" Guest ID : " + o.getQuest().getID());
        
        if (o.getQuestRoom() instanceof RoomStandard) {
            OutputI.print(" Guest Room # : " + o.getQuestRoom().getRoom_number());
            OutputI.print(" in Floor : " + o.getQuestRoom().getFloor());
            OutputI.println(" view : " + ((RoomStandard) o.getQuestRoom()).getView());
            
        } else if (o.getQuestRoom() instanceof Bungalow) {
            OutputI.print(" Guest Bangalow # : " + o.getQuestRoom().getRoom_number());
            OutputI.println(" with a " + ((Bungalow) o.getQuestRoom()).getOutdoor());
        }

        OutputI.println(" Check in date : " + o.getCheckIn().getDate() + "/" + o.getCheckIn().getMonth() + "/" + o.getCheckIn().getYear());
        OutputI.println(" Number of nights : " + o.getQuestRoom().CalculateNight_Rate(o.getCheckIn(), o.getCheckOut()));
        OutputI.println("");
        OutputI.println("--------------- Invoice Details ---------------");

        //calculate price
        double price = o.getQuestRoom().CalculatePrice(rooms);

        OutputI.println(" Room Price in " + o.getQuestRoom().getNight_Rate() + " nights : " + price);
        //print Services
        OutputI.println(" Services: ");

        int Sprice = 0;
        
        for (int s = 0; s < o.getQuestService().size(); s++) {
            if (o.getQuestService().isEmpty()) {
                break;
            } else {
                OutputI.println(o.getQuestService().get(s).toString());
                Sprice += o.getQuestService().get(s).getServicePrice();
            }
        }
        OutputI.println("------------------------------");
        OutputI.println("Total : " + (price + Sprice));
        if (o.getQuest() instanceof VIP) {
            OutputI.println("------------------------------");
            OutputI.println("You are a VIP ");
            OutputI.println("Total after 20% discount: " + ((price + Sprice) - ((((price + Sprice)) * 20) / 100.0)));
        }
        //colse output
        OutputI.close();
    }
}
