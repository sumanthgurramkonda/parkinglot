import com.pro.billingPolicy.Bill;
import com.pro.enums.SlotState;
import com.pro.enums.SlotType;
import com.pro.enums.VehicleType;
import com.pro.parkings.ParkingLevel;
import com.pro.parkings.ParkingSlot;
import com.pro.service.ParkingLotService;
import com.pro.ticket.Ticket;
import com.pro.vehicle.Bike;
import com.pro.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingLotService parkingLotService = new ParkingLotService();
        String lotId = "lot";
        int parkingLevelCount = 3;
        int parkingSlotCount = 100;
        List<ParkingLevel> parkingLevels = new ArrayList<>();
        for (int i=0;i<parkingLevelCount;i++){
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            SlotType slotType;
            for (int j=0;j<parkingSlotCount;j++){
                int num = (int)(j*Math.random()%3);
                if(num==0){
                    slotType = SlotType.SMALL;
                }else if(num==1){
                    slotType = SlotType.MEDIUM;
                }else{
                    slotType = SlotType.LARGE;
                }
                parkingSlots.add(new ParkingSlot(j,SlotState.FREE,slotType));
            }
            parkingLevels.add(new ParkingLevel(i,parkingSlots));
        }

        parkingLotService.setUpParking("lot1",parkingLevels);
        Ticket ticket = parkingLotService.reserveSlot("lot1", new Bike(12345));

        System.out.println("ticket -> "+ticket);

        try {
            Thread.sleep(36000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Bill bill = parkingLotService.vacateSlot(ticket.getTicketNumber());

        System.out.println("Bill -> "+bill);
    }
}