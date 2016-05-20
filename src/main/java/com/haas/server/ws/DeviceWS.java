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

/**
 *
 * @author Shall
 */
@Path("/device")
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
}
