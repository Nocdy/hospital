package entites;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @author Nocdy
 * @date 2021年 09月22日 10:54:21
 */
@Data
@Repository
public class RegisterUser {

    String doctorName;
    String type;
}
