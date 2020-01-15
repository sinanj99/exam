/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.ClassDTO;
import dto.CourseDTO;
import dto.SignedUpDTO;
import facades.ClassFacade;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("class")
public class ClassResource {
    
    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private final ClassFacade FACADE = ClassFacade.getClassFacade(EMF);
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
    public List<ClassDTO> getAllClasses() {
        return FACADE.getAllClasses();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("id/{id}")
    public ClassDTO getClassById(@PathParam("id") int id) {
        return FACADE.getClassById(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add")
    public ClassDTO addClass(String class_) {
        ClassDTO classDTO = GSON.fromJson(class_, ClassDTO.class);
        return FACADE.addClass(classDTO);
    }
    

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("edit")
    @RolesAllowed("admin")
    public ClassDTO editClass(String p) {
        ClassDTO classDTO = GSON.fromJson(p, ClassDTO.class);
        return FACADE.editClass(classDTO);
    }
    
//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public PersonDTO getPerson(@PathParam("id") int id) {
//        PersonDTO p;
//        p = FACADE.getPersonById(id);
//        return p;
//    }
//
//    @GET
//    @Path("hobby/{hobby}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<PersonDTO> getPersonsByHobby(@PathParam("hobby") String hobby) {
//        return FACADE.getPersonsByHobby(hobby);
//    }
}

