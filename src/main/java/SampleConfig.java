import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class SampleConfig extends Configuration {
    private Long  firstNumber;

    private Long  secondNumber;



    @JsonProperty
    public long getFirstNumber() {
        return firstNumber;
    }

    @JsonProperty
    public void setFirstNumber(long firstNumber) {
        this.firstNumber = firstNumber;
    }

    @JsonProperty
    public long getSecondNumber() {
        return secondNumber;
    }

    @JsonProperty
    public void setSecondNumber(long secondNumber) {
        this.secondNumber = secondNumber;
    }
}