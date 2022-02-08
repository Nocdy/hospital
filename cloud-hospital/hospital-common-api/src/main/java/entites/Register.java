package entites;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 挂号记录实体类
 *
 * @author Nocdy
 * @date 2021年 09月10日 12:18:46
 */
@Repository
@Data
@TableName(value = "register")
public class Register {

    @TableId(type=IdType.AUTO)
    Integer id;

    Integer patient;

    Integer doctor;

    Integer office;

    String type;

    Date registerTime;

    Date admitTime;

    Boolean status;

}
