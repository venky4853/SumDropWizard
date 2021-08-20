import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/doSum")
@Produces(MediaType.APPLICATION_JSON)
public class AddResource {
    Long numberOne;
    Long numberTwo;
    AtomicLong counter=new AtomicLong();

    public AddResource(long one, long two) {
        numberOne = one;
        numberTwo = two;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculateSum(@QueryParam("firstNum") Optional<Long> firstNum,
                                 @QueryParam("secondNum") Optional<Long> secondNum) {
        System.out.println("CalculateSum invoked");
        Long localOne = firstNum.orElse(numberOne);
        Long localTwo = secondNum.orElse(numberTwo);
        return new Response(counter.incrementAndGet(), SumHelper.doSum(localTwo,localTwo));
    }

}
