package isbn.biz;

import isbn.protocol.IsbnNumber;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ValidationBiz {
    public ArrayList<IsbnNumber> validate(ArrayList<IsbnNumber> isbnNumbers){
        for (IsbnNumber isbn : isbnNumbers){
            isbn.setValid(validateSingleIsbn(isbn));
        }
        return isbnNumbers;
    }

    public boolean validateSingleIsbn(IsbnNumber isbn){
        int type = isbn.getType();
        String numberString = isbn.getNumber();

        if (type != numberString.length()){
            return false;
        }

        int sumOfProducts = 0;
        String[] characters = isbn.getNumber().split("");

        for (int i = 0; i < characters.length; i++) {
            try {
                sumOfProducts += Integer.parseInt(characters[i]) * (type == 10 ? 10 - i : (i % 2 == 0 ? 1 : 3));
            } catch (Exception e){
                return false;
            }
        }

        return type == 10 ? sumOfProducts % 11 == 0 : sumOfProducts % 10 == 0;
    }

}
