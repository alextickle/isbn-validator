package isbn.protocol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class IsbnNumber {
    private String number;
    private int type;
    private boolean valid;
    private int id;
}

