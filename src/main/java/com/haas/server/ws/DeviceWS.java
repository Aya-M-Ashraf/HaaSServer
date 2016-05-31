package com.haas.server.ws;

import commons.ws.Constants;
import commons.ws.Result;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.haas.server.service.interfaces.DeviceService;
import commons.dto.DeviceDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author Shall
 */
@Path("/device")
@Component
public class DeviceWS {

    @Autowired
    private DeviceService deviceServiceImpl;

    @GET
    @Path("/linkDevice")
    @Produces(MediaType.APPLICATION_JSON)
    public Result linkDevice(@QueryParam(Constants.EMAIL) String email, @QueryParam(Constants.SERIAL_NUMBER) String serialNumber) {
        Result result = new Result();
        boolean isDeviceLinked = deviceServiceImpl.linkDevice(email, serialNumber);
        if (isDeviceLinked) {
            result.setCode("link_device");
            result.setMsg("Device has been linked successfully to the account");
            result.setObj(null);
            result.setSuccess(true);
        } else {
            result.setCode("link_device");
            result.setMsg("Error, couldn't link device");
            result.setObj(null);
            result.setSuccess(false);
        }
        return result;
    }

    @GET
    @Path("/keepAlive")
    @Produces(MediaType.APPLICATION_JSON)
    public Result keepAlive(@QueryParam(Constants.HOST_SERIAL_NUMBER) String hostSerialNum, @QueryParam(Constants.GUEST_SERIAL_NUMBER) String guestSerialNum,
            @QueryParam(Constants.CONSUMED_MB) String consumedMB, @QueryParam(Constants.DATE_TIME_STAMP) String timeStamp,
            @QueryParam(Constants.UPDATED_VERSION) String updatedVersion, @QueryParam(Constants.KEEP_ALIVE_STATUS) String keepAliveStatus, 
            @QueryParam(Constants.EMAIL) String guestEmail, @QueryParam(Constants.SILVER_COINS) String silverCoins, @QueryParam(Constants.GOLDEN_COINS) String goldenCoins) {
        Result result = new Result();
        try {
            System.out.println("**** inside keep alive WS ");

            boolean operationSuccess;

            operationSuccess = deviceServiceImpl.toKeepAlive(hostSerialNum, guestSerialNum, Double.parseDouble(consumedMB), Long.parseLong(timeStamp), Integer.parseInt(updatedVersion), keepAliveStatus, guestEmail, Double.parseDouble(silverCoins), Double.parseDouble(goldenCoins));
            if (operationSuccess) {
                result.setSuccess(true);
                result.setCode("keepAlive");
                result.setMsg("The Keep Alive Messages Has Been Sent Successfuly");
                result.setObj(new DeviceDTO());
            } else {
                result.setSuccess(false);
                result.setCode("keepAlive");
                result.setMsg("The Keep Alive Messages Failed To Be Sent");
                result.setObj(new DeviceDTO());
            }

        } catch (Exception ex) {
            Logger.getLogger(DeviceWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @GET
    @Path("/trackingCoins")
    @Produces(MediaType.APPLICATION_JSON)
    public Result trackingCoins(@QueryParam(Constants.EMAIL) String hostEmail, @QueryParam(Constants.SILVER_COINS) String silverCoins, @QueryParam(Constants.GOLDEN_COINS) String goldenCoins){
        Result result = new Result();
        boolean operationSuccess;
        
        operationSuccess = deviceServiceImpl.trackingHostCoins(hostEmail, Double.parseDouble(silverCoins), Double.parseDouble(goldenCoins));
        
        if (operationSuccess) {
                result.setSuccess(true);
                result.setCode("keepAlive");
                result.setMsg("Your Coins Have Been Successfuly Updated");
                result.setObj(new DeviceDTO());
            } else {
                result.setSuccess(false);
                result.setCode("keepAlive");
                result.setMsg("The Coins Have Been Messages Failed To Be Sent");
                result.setObj(new DeviceDTO());
            }
        return result;
    }
}
