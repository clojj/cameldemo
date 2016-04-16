package de.fisp.cameldemo.rs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("processors")
public class Resource {

    @POST
    @Path("beautification")
    public String process(String input) {
        return "+" + input + "+";
    }

    @GET
    @Path("test")
    public String test() {
        return "Hello";
    }

}