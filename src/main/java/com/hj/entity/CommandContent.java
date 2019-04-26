package com.hj.entity;

import lombok.Data;

/**
 * Author: hj
 * Date: 2019-04-26 13:05
 * Description: 指令内容
 */
@Data
public class CommandContent {

    //内容id
    private int id;

    //内容
    private String content;

    //指令id
    private int command_id;
}
