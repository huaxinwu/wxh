/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 测试迭代器与组合模式
 * @author wxh
 * @version $Id: MenuDriverTest.java, v 0.1 2017年6月2日 下午4:10:10 wxh Exp $
 */
public class MenuTestDriverUnit {

    public static void main(String[] agrs) {
        MenuComponent pancakeHouseMenu = new MenuUnit("PANCAKE HOUSE MENU", "Breakfase");
        MenuComponent dinerMenu = new MenuUnit("DINER MENU", "Lunch");
        MenuComponent cafeMenu = new MenuUnit("CAFE MENU", "Dinner");

        MenuComponent dessertMenu = new MenuUnit("DESSERT MENU", "Dessert of course!");

        MenuComponent allMenus = new MenuUnit("ALL MENU", "All menus combined");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        // 加入更多菜单项
        // 煎饼屋菜单
        pancakeHouseMenu.add(new MenuItem("K&B'S Pancake Breakfast",
            "Pancakes with scrambled eggs,and toast", true, 2.99));
        pancakeHouseMenu.add(new MenuItem("Regular Pancake Breakfast",
            "Pancakes with fried eggs,and sausage", false, 2.99));
        pancakeHouseMenu.add(new MenuItem("Buleberry Pancake Breakfast",
            "Pancakes made with fresh blueberries", true, 3.49));
        pancakeHouseMenu.add(new MenuItem("Waffles",
            "Waffles,with your choice of blueberries or strawberries", true, 3.59));

        // 餐厅菜单
        dinerMenu.add(new MenuItem("Vegetarian BLT",
            "(Fakin)Bacon with lettuce & tomato on whole wheat", true, 2.99));
        dinerMenu
            .add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99));
        dinerMenu.add(new MenuItem("Soup of day", "Soup of day,with a side of potato salad", false,
            3.29));
        dinerMenu.add(new MenuItem("Hotdog",
            "a hot dog,with saurkraut,relish,onions,topped with cheese", true, 3.05));

        dinerMenu.add(new MenuItem("Pasta",
            "Spaghtti with Marinara Sauce,and a slice of sourdough bread", true, 3.89));
        // 菜单中添加菜单
        dinerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem("Apple Pie",
            "Apple pie with a flakey crust,topped with vanilla ice cream", true, 1.59));
        dessertMenu.add(new MenuItem("Cheesecake",
            "Creamy New York cheesecake,with a chocolate graham crust", true, 1.99));
        dessertMenu.add(new MenuItem("Sorbet", "A scoop of raspberry and a scoop of line ", true,
            1.89));

        cafeMenu.add(new MenuItem("Veggie Burgar and Air pries",
            "Veggie burgar on a whole wheat bun,letture,tomato,and fries", true, 3.99));
        cafeMenu.add(new MenuItem("Soup of the day",
            "A cup of the soup of the day,with a side salad", false, 3.69));
        cafeMenu.add(new MenuItem("Burrito",
            "A large burrito,with whole pinto beans,salsa,quacamole", true, 4.29));
        // 加入更多菜单
        Waitress waitress = new Waitress(allMenus);
        waitress.printMenuComponent();
    }
}
