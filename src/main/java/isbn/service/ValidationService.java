package isbn.service;

import java.util.ArrayList;
import isbn.biz.ValidationBiz;
import isbn.protocol.IsbnNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/isbn")
@RestController
public class ValidationService {

    @Autowired
    ValidationBiz validationBiz;
    
    @CrossOrigin
    @PostMapping("/validate")
    public ArrayList<IsbnNumber> validate(@RequestBody ArrayList<IsbnNumber> isbnNumbers){
        return validationBiz.validate(isbnNumbers);
    }

    @GetMapping("/ping")
    public boolean ping() {
        return true;
    }

}
