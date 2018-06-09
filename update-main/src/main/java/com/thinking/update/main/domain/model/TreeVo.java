package com.thinking.update.main.domain.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @create 2018/6/9
 */
@Data
public class TreeVo implements Serializable {

    private String label;

    private String data;

    private LinkedList<TreeVo> children;
}
