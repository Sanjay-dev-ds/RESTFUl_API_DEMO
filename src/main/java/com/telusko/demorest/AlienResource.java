package com.telusko.demorest;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("aliens2")
public class AlienResource {

	AlienRepository repo = new AlienRepository();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Alien> getAliens() {
		return repo.getAliens();
	}

	@GET
	@Path("alien/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Alien getAlien(@PathParam("id") int id) {

		return repo.getAlien(id);
	}

	@POST
	@Path("alien")
	@Consumes(MediaType.APPLICATION_XML)
	public Alien createAlien(Alien a1) {
		repo.create(a1);
		return a1;
	}

	@PUT
	@Path("alien")
	@Consumes(MediaType.APPLICATION_XML)
	public Alien UpdateAlien(Alien a1) {

		if (repo.getAlien(a1.getId()).getId() == 0) {
			repo.create(a1);
			repo.update(a1);
		}

		return a1;

	}

	@DELETE
	@Path("alien/{id}")
	public Alien KillAlien(@PathParam("id") int id) {

		Alien a = repo.getAlien(id);
		if (a.getId() != 0)
			repo.delete(a);

		return a;
	}
	
	
	

}
