package entites;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 病人就诊卡
 *
 * @author Nocdy
 * @date 2021年 09月07日 12:50:23
 */
@Data
@Repository
@TableName(value = "patient_card")
public class Patient implements Serializable {

    @TableId
    Integer id;

    Long identityNum;

    String name;

}
