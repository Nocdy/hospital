package entites;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 登录注册表
 *
 * @author Nocdy
 * @date 2021年 09月07日 12:46:50
 */
@Data
@Repository
@TableName(value = "user")
public class User implements Serializable {

    @TableId
    Integer id;

    String password;

    String identity;

    String name;


    @TableField(exist = false)
    String confirmPass;


}
