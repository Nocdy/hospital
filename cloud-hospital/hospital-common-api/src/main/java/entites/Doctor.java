package entites;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Time;

/**
 * @author Nocdy
 * @date 2021年 09月10日 17:22:32
 */
@Repository
@Data
public class Doctor {
    @TableId
    Integer id;

    String name;

    Integer workDay;

    Time workStarTime;

    Time workEndTime;

    Integer office;

    String type;
}
