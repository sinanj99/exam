/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CourseDTO;
import dto.SignedUpDTO;
import facades.CourseFacade;
import facades.SignedUpFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import utils.EMF_Creator;

/**
 *
 * @author sinanjasar
 */
@Path("signedup")
public class SignedUpResource {

    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private final SignedUpFacade FACADE = SignedUpFacade.getSignedUpFacade(EMF);
    private Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public List<SignedUpDTO> getAllSignedUps() {
        return FACADE.getAllSignedUps();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{studentName}")
    public List<SignedUpDTO> getSignedUpsByStudentName(@PathParam("studentName") String studentName) {
        List<SignedUpDTO> s =  FACADE.getSignedUps(studentName);
        s.forEach(stud -> System.out.println(stud.getCourseDTO().getCourseName()));
        return s;
    }
}
