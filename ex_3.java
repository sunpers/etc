import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/create_lun")
public class CreateLunService {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		Process output = Runtime.getRuntime().exec("lun create testcase");
		output.waitFor();  

		return Response.status(200).entity("run lun create testcase").build();

	}

}
