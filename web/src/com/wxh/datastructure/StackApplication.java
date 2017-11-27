/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 栈应用：
 * 1.进制转换，比如十进制转换为八进制
 * @author wxh
 * @version $Id: StackApplication.java, v 0.1 2017年11月23日 下午2:26:26 wxh Exp $
 */
public class StackApplication {

    /**
     * 求解迷宫的算法思想可以描述为:
     * 迷宫单元定义初始化，将起点加入堆栈；
     * while(堆栈不空){
     *    取出栈顶位置作为当前位置；
     *     如果 当前位置是终点，
     *     则 使用堆栈记录的路径标记从起点至终点的路径；
     *     否则{ 按照向下、右、上、左的顺序将当前位置下一个可以探索的位置入栈；
     *     //从堆栈取出的探索方向顺序则是左、上、右、下
     *           如果 当前位置没四周均不可通
     *             则 当前位置出栈；
     *   }
     * }
     * 
     * 迷宫单元定义
     */
    private class Cell {
        /** 单元所在行 */
        int     x       = 0;
        /** 单元所在列*/
        int     y       = 0;
        /** 是否访问过  */
        boolean visited = false;
        /** 是墙('1')、可通路('0')或起点到终点的路径('*')  */
        char    c       = ' ';

        public Cell(int x, int y, char c, boolean visited) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.visited = visited;
        }
    }

    /**
     * 创建一个迷宫
     * 这里采用的例子是行数和列数相同，不然row.length应该为maze[x].length
     * @param maze
     * @return
     */
    private Cell[][] createMaze(char[][] maze) {
        // 构建字符数组行数作为对象数组行数的二维数组
        Cell[][] cells = new Cell[maze.length][];
        for (int x = 0; x < maze.length; x++) {
            // 获取字符数组行数的所有数据
            char[] row = maze[x];
            // 构建字符数组行数作为对象数组行数的一维数组
            cells[x] = new Cell[row.length];
            // 绘制二维数组的坐标点的字符
            for (int y = 0; y < row.length; y++) {
                cells[x][y] = new Cell(x, y, maze[x][y], false);
            }
        }
        return cells;
    }

    /**
     * 打印迷宫
     * 二维数组是一个矩阵
     * @param cells
     */
    private void printMaze(Cell[][] cells) {
        // 遍历行数
        for (int x = 0; x < cells.length; x++) {
            // 遍历列数
            for (int y = 0; y < cells[x].length; y++) {
                // 打印坐标的字符
                System.out.print(cells[x][y].c + " ");
            }
            // 换行
            System.out.println();
        }

    }

    /**
     * 是相邻的单元
     * o -----------y
     * |
     * |
     * |
     * x
     * 
     * @param cell1
     * @param cell2
     * @return boolean
     */
    private boolean isAdjoinCell(Cell cell1, Cell cell2) {
        // 同一行上不同列,因为两个相减有可能为负数
        if (cell1.x == cell2.x && Math.abs(cell1.y - cell2.y) < 2) {
            // 是相邻单元
            return true;
        }
        // 同一列不同行,因为两个相减有可能为负数
        if (cell1.y == cell2.y && Math.abs(cell1.x - cell2.x) < 2) {
            // 是相邻单元
            return true;
        }
        // 不是相邻单元
        return false;
    }

    /**
     * 是有效路径上的单元
     * @param cell
     * @return
     */
    private boolean isVaildWayCell(Cell cell) {
        // 该单元的字符是可通过并且没有被访问过取反
        return cell.c == '0' && !cell.visited;
    }

    /**
     * 算法：baseConversion--进制转换
     * 输入：十进制正整数i
     * 输出：打印相应八进制数
     * 解决方法：十进制正整数求模8，每次所得余数进行逆排就是八进制数
     * 除法公式：除数×商+余数=被除数
     * @param i
     */
    public void baseConversion(int i) {
        // 采用单链表实现栈来处理,因为插入、删除用单链表实现栈效率更快
        Stack stack = new StackSLinked();
        // 遍历，将所得余数依次存入栈中
        while (i > 0) {
            // 入栈,存入字符串数字
            stack.push(i % 8 + "");
            // 获取商，作为下一次的被除数
            i = i / 8;
        }
        // 遍历，栈不为空，就将栈中数据元素打印出来
        while (!stack.isEmpty()) {
            // 栈中数据元素一个一个出栈，不换行
            System.out.print((String) stack.pop());
        }
    }

    /**
     * 算法：bracketMatch--括号匹配
     * 输入：字符串str
     * 输出：boolean，匹配结果
     * 解决方法：算法需要一个栈，在读入字符的过程中，如果是左括号，则
     *          直接入栈，等待相匹配的同类右括号；若读入的是右括号，且与当前栈顶左括号匹配，则将
     *          栈顶左括号出栈，如果不匹配则属于不合法的情况。另外如果碰到一个右括号，而栈为空，
     *          说明没有左括号与之匹配，属于非法情况；或者字符读完，而栈不为空，说明有左括号没
     *          有得到匹配，也属于非法情况。当字符读完同时栈为空，并且在匹配过程中没有发现不匹
     *          配的情况，说明所有的括号是匹配的
     * @param str
     * @return boolean
     */
    public boolean bracketMatch(String str) {
        // 采用单链表实现栈来处理,因为插入、删除用单链表实现栈效率更快
        Stack stack = new StackSLinked();
        for (int i = 0; i < str.length(); i++) {
            // 获取单个字符
            char c = str.charAt(i);
            // 通过匹配方式处理不同的业务逻辑
            switch (c) {
                case '{':
                case '[':
                case '(':
                    // 入栈,将符号{}[]()转换为ASCII码表对应的数字存入栈中
                    stack.push(Integer.valueOf(c));
                    break;
                case '}':
                    // 如果栈不为空，并且出栈的数据元素内容等于左花括号,表明栈中花括号已经成对
                    if (!stack.isEmpty() && ((Integer) stack.pop()).intValue() == '{') {
                        break;
                    } else {
                        // 非法情况
                        return false;
                    }
                case ']':
                    // 如果栈不为空，并且出栈的数据元素内容等于左方括号，表明栈中方括号已经成对
                    if (!stack.isEmpty() && ((Integer) stack.pop()).intValue() == '[') {
                        break;
                    } else {
                        return false;
                    }
                case ')':
                    // 如果栈不为空，并且出栈的数据元素内容等于左圆括号，表明栈中方括号已经成对
                    if (!stack.isEmpty() && ((Integer) stack.pop()).intValue() == '(') {
                        break;
                    } else {
                        return false;
                    }
                default:
                    break;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 算法：mazeExit--迷宫出口
     * 输入：表示迷宫的二维字符数组，起点坐标、终点坐标，并且字符数组及坐标有效
     * 输出：找到起点到终点的路径
     * 解决方法：通常采用的方法是系统的尝
     *          试所有可能的路径：即从起点出发，顺着某个
     *          方向向前探索，例如向当前位置的左边探索，
     *          若当前位置除向左之外还有其他方向的没有
     *          被访问过的邻接点，则在向左探索之前，按固
     *          定的次序记录下当前位置其他可能的探索方
     *          向；若当前位置向左不能再走下去，则换到当
     *          前位置的其他方向进行探索；如果当前位置所
     *          有方向的探索均结束，却没有到达终点，则沿
     *          路返回当前位置的前一个位置，并在此位置还
     *          没有探索过的方向继续进行探索；直到所有可
     *          能的路径都被探索到为止。
     * @param maze
     * @param sx
     * @param sy
     * @param ex
     * @param ey
     */
    public void mazeExit(char[][] maze, int sx, int sy, int ex, int ey) {
        // 创建迷宫
        Cell[][] cells = createMaze(maze);
        // 打印迷宫
        printMaze(cells);
        // 采用单链表实现栈来处理,因为插入、删除用单链表实现栈效率更快
        Stack stack = new StackSLinked();
        // 设置单元起点位置
        Cell startCell = cells[sx][sy];
        // 设置单元终点位置
        Cell endCell = cells[ex][ey];
        // 起点入栈
        stack.push(startCell);
        // 标记起点已经被访问过,访问方式下--右--上--左
        startCell.visited = true;
        // 遍历，将可通过迷宫单元存入栈中
        while (!stack.isEmpty()) {
            // 获取当前的迷宫单元
            Cell current = (Cell) stack.peek();
            // 已经到终点
            if (current == endCell) {
                while (!stack.isEmpty()) {
                    // 沿路返回将路径上的单元设为*
                    Cell cell = (Cell) stack.pop();
                    cell.c = '*';
                    // 栈中与cell相邻的单元才是路径的组成部分，除此之外，
                    // 栈中还有记录下来但是未继续向下探索的单元，
                    // 这些单元直接出栈
                    while (!stack.isEmpty() && !isAdjoinCell((Cell) stack.peek(), cell)) {
                        stack.pop();
                    }
                }
                System.out.println("找到起点到终点的路径");
                printMaze(cells);
                return;
            } else {
                // 如果不是终点
                int x = current.x;
                int y = current.y;
                // 计数标志
                int count = 0;
                /**
                 * o------------->y
                 * |
                 * |
                 * |
                 * x
                 */

                // 向下移动
                if (isVaildWayCell(cells[x + 1][y])) {
                    // 入栈
                    stack.push(cells[x + 1][y]);
                    // 标记访问过
                    cells[x + 1][y].visited = true;
                    // 计数加1
                    count++;
                }
                // 向右移动
                if (isVaildWayCell(cells[x][y + 1])) {
                    // 入栈
                    stack.push(cells[x][y + 1]);
                    // 标记访问过
                    cells[x][y + 1].visited = true;
                    // 计数加1
                    count++;
                }
                // 向上移动
                if (isVaildWayCell(cells[x - 1][y])) {
                    // 入栈
                    stack.push(cells[x - 1][y]);
                    // 标记访问过
                    cells[x - 1][y].visited = true;
                    // 计数加1
                    count++;
                }
                // 向左移动
                if (isVaildWayCell(cells[x][y - 1])) {
                    // 入栈
                    stack.push(cells[x][y - 1]);
                    // 标记访问过
                    cells[x][y - 1].visited = true;
                    // 计数加1
                    count++;
                }
                // 如果是死点，出栈
                if (count == 0) {
                    stack.pop();
                }
            }
        }
        System.out.println("没有从起点到终点的路径");
    }

    /**
     * 测试栈的应用案例
     * @param args
     */
    public static void main(String[] args) {
        StackApplication application = new StackApplication();
        // 十进制转换为八进制
        application.baseConversion(10);
        System.out.println();
        System.out.println("----------------------------");
        // 括号匹配
        System.out.println(application.bracketMatch("{[(}"));
        System.out.println("----------------------------");
        // 迷宫寻路
        // 创建一个10行10列字符二维数组，(8,8)为起点，(1,7)为终点，寻找起点到终点路径
        char[][] maze = { { '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '1', '1', '0', '0', '1', '1' },
                { '1', '0', '0', '1', '1', '0', '0', '1', '0', '1' },
                { '1', '0', '0', '0', '0', '0', '0', '1', '0', '1' },
                { '1', '0', '0', '0', '0', '1', '1', '0', '0', '1' },
                { '1', '0', '0', '1', '1', '1', '0', '0', '0', '1' },
                { '1', '0', '0', '0', '0', '1', '0', '1', '0', '1' },
                { '1', '0', '1', '1', '0', '0', '0', '1', '0', '1' },
                { '1', '1', '0', '0', '0', '0', '1', '0', '0', '1' },
                { '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' } };

        application.mazeExit(maze, 8, 8, 1, 7);

    }

}
