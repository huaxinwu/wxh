/**
 * Ambition Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.wxh.action.GoddessAction;
import com.wxh.model.Goddess;

/**
 * 数据展示封装实体类
 * @author wxh
 * @version $Id: View.java, v 0.1 2016年12月20日 上午9:58:55 wxh Exp $
 */
public class View {
    /** 定义功能菜单列表信息 */
    private static final String CONTEXT          = "欢迎来到女神禁区:\n" + "下面是女神禁区的列表:\n"
                                                   + "[MAIN/M]:主菜单:\n" + "[QUERY/Q]:查看全部女神信息:\n"
                                                   + "[GET/G]:查看某位女神的详细信息:\n" + "[ADD/A]:添加女神信息:\n"
                                                   + "[UPDATE/U]:更新女神信息:\n"
                                                   + "[DELETE/D]:删除女神信息:\n"
                                                   + "[SEARCH/S]:查询女神信息:\n" + "[EXIT/E]:退出女神禁区:\n"
                                                   + "[BREAK/B]:退出当前功能，返回主菜单:\n";

    /** 定义菜单按钮的简写  */
    private static final String OPERATION_MAIN   = "MAIN";
    private static final String OPERATION_QUERY  = "QUERY";
    private static final String OPERATION_GET    = "GET";
    private static final String OPERATION_ADD    = "ADD";
    private static final String OPERATION_UPDATE = "UPDATE";
    private static final String OPERATION_DELETE = "DELETE";
    private static final String OPERATION_SEARCH = "SEARCH";
    private static final String OPERATION_EXIT   = "EXIT";
    private static final String OPERATION_BREAK  = "BREAK";

    public static void main(String[] args) {

        System.out.println(CONTEXT);
        /**
         * 该功能两个难点：
         * 1.如何让程序一直运行 ---while(true)
         * 2.在选择的某个选项里，一直操作直到结束，才跳出该操作 -- 设置标志位控制开关
         */

        Scanner scan = new Scanner(System.in);
        Goddess goddess = new Goddess();
        GoddessAction action = new GoddessAction();
        List<Goddess> list = new ArrayList<Goddess>();
        //标记位，记忆当前操作状态，在一个选项里一直操作
        String pernious = null;
        //步长
        Integer step = 1;
        while (scan.hasNext()) {
            String in = scan.next().toString();

            if (OPERATION_EXIT.equals(in.toUpperCase())//退出
                || OPERATION_EXIT.subSequence(0, 1).equals(in.toUpperCase())) {
                System.out.println("您已经成功退出女神禁区！");
                break;
            } else if (OPERATION_ADD.equals(in.toUpperCase())//添加
                       || OPERATION_ADD.subSequence(0, 1).equals(in.toUpperCase())
                       || OPERATION_ADD.equals(pernious)) {
                pernious = OPERATION_ADD;
                if (1 == step) {
                    System.out.println("请输入女神的[姓名]:");
                } else if (2 == step) {
                    //放入女神对象中
                    goddess.setUserName(in);
                    System.out.println("请输入女神的[年龄]:");
                } else if (3 == step) {
                    try {
                        goddess.setAge(Integer.valueOf(in));
                        System.out.println("请输入女神的[生日],格式为yyyy-MM-dd");
                    } catch (NumberFormatException e) {
                        step = 2;
                        System.out.println("请输入女神的[年龄]:");
                    }
                } else if (4 == step) {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        goddess.setBirthday(sdf.parse(in));
                        System.out.println("请输入女神的[邮箱]:");
                    } catch (ParseException e) {
                        step = 3;
                        System.out.println("请输入女神的[生日],格式为yyyy-MM-dd");
                    }

                } else if (5 == step) {
                    goddess.setEmail(in);
                    System.out.println("请输入女神的{手机号码]:");
                } else if (6 == step) {
                    goddess.setMobile(in);
                    try {
                        action.add(goddess);
                        step = 1;
                        pernious = null;
                        System.out.println("添加女神信息成功！");
                    } catch (Exception e) {
                        step = 1;
                        pernious = null;
                        System.out.println("添加女神信息失败！");
                    }
                }
                //如果匹配，步长自增
                if (OPERATION_ADD.equals(pernious)) {
                    step++;
                }
            } else if (OPERATION_UPDATE.equals(in.toUpperCase())//更新
                       || OPERATION_UPDATE.subSequence(0, 1).equals(in.toUpperCase())
                       || OPERATION_UPDATE.equals(pernious)) {
                pernious = OPERATION_UPDATE;
                if (1 == step) {
                    System.out.println("请输入更新女神的{ID]:");
                } else if (2 == step) {
                    try {
                        goddess = action.getGoddess(Integer.valueOf(in));
                        if (goddess == null) {
                            step = 1;
                            System.out.println("输入的女神[ID]不存在！");
                        }
                    } catch (NumberFormatException e) {
                        step = 1;
                        System.out.println("请输入正确的女神{ID]!");
                    } catch (Exception e) {
                        step = 1;
                        System.out.println("输入的女神[ID]不存在！");
                    }
                    System.out.println("请输入女神的{姓名],(如果不更新该字段，则设为null)");
                } else if (3 == step) {
                    if (!"null".equals(in.toUpperCase())) {
                        goddess.setUserName(in);
                    }
                    System.out.println("请输入女神的{年龄],(如果不更新该字段，则设为null)");
                } else if (4 == step) {
                    try {
                        if (!"null".equals(in.toUpperCase())) {
                            goddess.setAge(Integer.valueOf(in));
                        }
                        System.out.println("请输入女神的{生日],格式为yyyy-MM-dd,(如果不更新该字段，则设为null)");

                    } catch (NumberFormatException e) {
                        step = 3;
                        System.out.println("请输入正确的女神[年龄]:");
                    }
                } else if (5 == step) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        if (!"null".equals(in.toUpperCase())) {
                            goddess.setBirthday(sdf.parse(in));
                        }
                        System.out.println("请输入女神的{邮箱],(如果不更新该字段，则设为null)");

                    } catch (ParseException e) {
                        step = 4;
                        System.out.println("请输入正确的女神[生日]:");
                    }
                } else if (6 == step) {
                    if (!"null".equals(in.toUpperCase())) {
                        goddess.setEmail(in);
                    }
                    System.out.println("请输入女神的{手机号码],(如果不更新该字段，则设为null)");
                } else if (7 == step) {
                    if (!"null".equals(in.toUpperCase())) {
                        goddess.setMobile(in);
                    }
                    try {
                        action.update(goddess);
                        step = 1;
                        pernious = null;
                        System.out.println("更新女神信息成功！");
                    } catch (Exception e) {
                        step = 1;
                        pernious = null;
                        System.out.println("更新女神信息失败！");
                    }
                }
                if (OPERATION_UPDATE.equals(pernious)) {
                    step++;
                }
            } else if (OPERATION_DELETE.equals(in.toUpperCase())//删除
                       || OPERATION_DELETE.subSequence(0, 1).equals(in.toUpperCase())
                       || OPERATION_DELETE.equals(pernious)) {
                pernious = OPERATION_DELETE;
                if (1 == step) {
                    System.out.println("请输入要删除的女神[ID],(删除多个用逗号隔开)");
                } else if (2 == step) {
                    try {
                        String[] strs = in.split(",");
                        Integer[] ids = new Integer[strs.length];
                        //遍历将取出来的每个字符串转换成对应ID值
                        for (int i = 0; i < strs.length; i++) {
                            ids[i] = Integer.parseInt(strs[i]);
                        }
                        action.delete(ids);
                        step = 1;
                        pernious = null;
                        System.out.println("删除女神信息成功！");
                    } catch (NumberFormatException e) {
                        step = 1;
                        pernious = null;
                        System.out.println("请输入正确的女神{ID]！");
                    } catch (Exception e) {
                        step = 1;
                        pernious = null;
                        System.out.println("删除女神信息失败！");
                    }
                }
                if (OPERATION_DELETE.equals(pernious)) {
                    step++;
                }
            } else if (OPERATION_QUERY.equals(in.toUpperCase())//查询全部女神信息
                       || OPERATION_QUERY.subSequence(0, 1).equals(in.toUpperCase())) {
                try {
                    list = action.query();
                    if (list != null) {
                        System.out.println("本禁区全部女神信息如下:");
                        for (Goddess g : list) {
                            System.out.println("编号:" + g.getId() + ",姓名：" + g.getUserName());
                        }
                    } else {
                        System.out.println("查询的女神信息不存在！");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("查询女神基本信息失败！");
                }
            } else if (OPERATION_GET.equals(in.toUpperCase())//查询某位女神信息
                       || OPERATION_GET.subSequence(0, 1).equals(in.toUpperCase())
                       || OPERATION_GET.equals(pernious)) {
                pernious = OPERATION_GET;
                if (1 == step) {
                    System.out.println("请输入需要查询女神的[ID]");
                } else if (2 == step) {
                    try {
                        goddess = action.getGoddess(Integer.valueOf(in));
                        if (goddess != null) {
                            step = 1;
                            pernious = null;
                            System.out.println("编号：" + goddess.getId() + "\n姓名："
                                               + goddess.getUserName() + "\n性别：" + goddess.getSex()
                                               + "\n年龄：" + goddess.getAge() + "\n生日："
                                               + goddess.getBirthday() + "\n邮箱："
                                               + goddess.getEmail() + "\n手机号码："
                                               + goddess.getMobile());

                        } else {
                            step = 1;
                            pernious = null;
                            System.out.println("查询女神信息不存在！");
                        }
                    } catch (NumberFormatException e) {
                        step = 1;
                        pernious = null;
                        System.out.println("请输入正确的女神{ID]！");
                    } catch (Exception e) {
                        step = 1;
                        pernious = null;
                        System.out.println("查询女神信息不存在！");
                    }
                }
                if (OPERATION_GET.equals(pernious)) {
                    step++;
                }
            } else if (OPERATION_SEARCH.equals(in.toUpperCase())//根据姓名模糊查询女神信息
                       || OPERATION_SEARCH.subSequence(0, 1).equals(in.toUpperCase())
                       || OPERATION_SEARCH.equals(pernious)) {
                pernious = OPERATION_SEARCH;
                if (1 == step) {
                    System.out.println("请输入任意女神的{姓名]中一个字或者多个字");
                } else if (2 == step) {
                    try {
                        list = action.query(in);
                        if (list != null) {
                            for (Goddess g : list) {
                                System.out.println("编号：" + g.getId() + ",姓名：" + g.getUserName());
                            }
                            step = 1;
                            pernious = null;
                        } else {
                            step = 1;
                            pernious = null;
                            System.out.println("查询的女神信息不存在！");
                        }
                    } catch (Exception e) {
                        step = 1;
                        pernious = null;
                        System.out.println("查询的女神信息不存在！");
                    }
                }
                if (OPERATION_SEARCH.equals(pernious)) {
                    step++;
                }
            } else if (OPERATION_MAIN.equals(in.toUpperCase())//回到主菜单
                       || OPERATION_MAIN.subSequence(0, 1).equals(in.toUpperCase())) {
                step = 1;
                pernious = null;
                System.out.println(CONTEXT);
            } else if (OPERATION_BREAK.equals(in.toUpperCase())//退出当前功能，返回主菜单
                       || OPERATION_BREAK.subSequence(0, 1).equals(in.toUpperCase())) {
                step = 1;
                pernious = null;
                System.out.println(CONTEXT);
            }
        }
    }
}
