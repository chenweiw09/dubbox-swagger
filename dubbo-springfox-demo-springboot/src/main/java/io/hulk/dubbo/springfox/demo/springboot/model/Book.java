package io.hulk.dubbo.springfox.demo.springboot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhaojigang
 * @date 2018/3/15
 */
@Data
@ApiModel("书籍")
public class Book implements Serializable{
    @ApiModelProperty("ID")
    private Long   id;
    @ApiModelProperty("书标题")
    private String title;
    @ApiModelProperty("书的内容")
    private String content;

    public Book() {
    }

    public Book(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
