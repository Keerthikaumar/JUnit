// package calculator.model.drive;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;


public class DriversManagerTest
{

    private final DriversManager driversManager = new DriversManager();

    @Before
    public void setup(){
        driversManager.addPassenger( new Passenger( "Carlos", "44234", 100 ) );
        driversManager.addPassenger( new Passenger( "Elise", "533434", 100 ) );
        driversManager.addPassenger( new Passenger( "Ian", "5343433", 100 ) );
        driversManager.addPassenger( new Passenger( "Debbie", "44555521", 100 ) );
        driversManager.addPassenger( new Passenger( "Cleon", "559988", 100 ) );
        driversManager.addPassenger( new Passenger( "Santiago", "1203123", 100 ) );

        driversManager.addDriver( new Driver( "Emilio", "1234990", 10f ) );
        driversManager.addDriver( new Driver( "Pedro", "12312440", 12f ) );
        driversManager.addDriver( new Driver( "Constanza", "9824990", 11f ) );
    }
	
     @Test
    public void Passenger(){
        Passenger secondPassenger = driversManager.getPassenger("533434");
        boolean checkObj = false;
        if("Elise" == secondPassenger.getName() && "533434" == secondPassenger.getId() && 100 == secondPassenger.getBalance())
        {
            checkObj = true;
        }
        Assert.assertEquals("Passenger is Not added!",true , checkObj);
    }
	
     @Test
    public void Driver(){
        Driver secondDriver = driversManager.getDriver("12312440");
        boolean checkObj = false;
        if("Pedro" == secondDriver.getName() && "12312440" == secondDriver.getId() && 12f == secondDriver.getFee())
        {
            checkObj = true;
        }
        Assert.assertEquals("Driver is Not added!",true , checkObj);
    }

    @Test
    public void startTripTest(){
	driversManager.startTrip("533434","9824990");
        boolean checkTrip = false;
        if(driversManager.getDriver("9824990").isAvailable() == false && driversManager.getPassenger("533434").isOnTrip() == true)
        {
            checkTrip = true;
        }
        Assert.assertEquals("Trip has not Started!",true , checkTrip);
    }

    @Test
    public void endTripTest(){
	driversManager.endTrip("44234","1234990");
        boolean checkEndTrip = true;
        if(driversManager.getDriver("1234990").getBalance() >= 10f && driversManager.getPassenger("44234").getBalance() < 100)
        {
            checkEndTrip = false;
        }
        Assert.assertEquals("Trip is not Ended!",true , checkEndTrip);
    }

    @Test
    public void nextAvailableDriverTest(){
	driversManager.endTrip("44234","1234990");
        String availableDriver = driversManager.findNextAvailableDriver();
        Assert.assertEquals("1234990" , availableDriver);
    }
}
