package com.hj.entity;

import lombok.Data;

import java.util.List;

/**
 * Author: hj
 * Date: 2019-04-26 13:05
 * Description: 指令
 */
@Data
public class Command {

    //指令id
    private int id;

    //指引名称
    private String name;

    //指令描述
    private String description;

    //指令内容,一个指令对应多个指令内容
    private List<CommandContent> contentList;

}
