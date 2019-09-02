package io.hulk.dubbo.springfox.demo.springboot.web;

import io.hulk.dubbo.springfox.demo.springboot.model.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zhaojigang
 * @date 2018/5/16
 */
@Api(tags = "user相关api")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("普通参数测试")
    @PostMapping(value = "/testCommonField")
    public String testCommonField2(@RequestParam("name") String name, @RequestBody Map<String, Book> bookMap) {
        return name;
    }

    @ApiOperation("对象参数测试")
    @PostMapping(value = "/testObject")
    public Book testObject(@RequestBody Book book1) {
        Book book = new Book();
        book.setId(99L);
        book.setTitle(book1.getTitle());
        book.setContent(book1.getContent());
        return book;
    }

    @ApiOperation("无参测试")
    @PostMapping(value = "/testEmptyField")
    public void testCommonField() {
        System.out.println("hello");
    }


    @ApiOperation("基本类型参数测试")
    @GetMapping("/testCommon")
    public String testCommon( @ApiParam("年龄") @RequestParam("age") int age){
        return "age is {}"+age;
    }
}