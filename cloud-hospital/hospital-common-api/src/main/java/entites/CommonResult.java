package entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 返回结果描述
 *
 * @author Nocdy
 * @date 2021年 09月07日 12:24:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }


}
