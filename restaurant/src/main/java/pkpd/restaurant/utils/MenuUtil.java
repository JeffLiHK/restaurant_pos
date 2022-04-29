package pkpd.restaurant.utils;

import pkpd.restaurant.entity.SysMenu;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:Jeff Li
 * Date:2020/10/3
 * Time:23:42
 */

public class MenuUtil {
    /**
     * 
     * @param menuId
     * @param rootMenu
     * @return
     */
    public static List<SysMenu> getChild(Long menuId,List<SysMenu> rootMenu){
        List<SysMenu> childMenu = new ArrayList<>();//
        /**
         * 
         */
        for(SysMenu menu:rootMenu){
            if(menu.getParentId()!=0&&menu.getParentId()==menuId){
               childMenu.add(menu);
            }
        }
        //
        sortByWeight(childMenu);
        if(childMenu.size()==0){
            return null;
        }
        /**
         * 
         */
        for (SysMenu menu:childMenu){
            // url ()
           /* if(StringUtil.isEmpty(menu.getMenuHref())){
                menu.setChildMenu(getChild(menu.getMenuId(),rootMenu));
            }*/
            menu.setChildMenus(getChild(menu.getMenuId(),rootMenu));
        }
        return childMenu;
    }

    /**
     *
     * @param rootMenu 
     * @param enableIsShowFields  is_show 
     * @return
     */
    public static List<SysMenu> formatMenuList(List<SysMenu> rootMenu,boolean enableIsShowFields){
        List<SysMenu> formatMenuList = new ArrayList<>();
        /**
         * is_show
         * is_show=0   is_show=1
         */
        if(enableIsShowFields){
            List<SysMenu> clearMenuList = new ArrayList<>();
            System.out.println(rootMenu.size());
            for(SysMenu menu:rootMenu){
                //0  1
                if(menu.getIsShow()==1){
                    clearMenuList.add(menu);
                }
            }
            rootMenu = clearMenuList;
            System.out.println(rootMenu.size());
        }
        /**
         * 
         */
        for(SysMenu menu:rootMenu){
            if(menu.getParentId()==0){
                formatMenuList.add(menu);
            }
        }
        //
        sortByWeight(formatMenuList);
        /**
         * 
         */
        for(SysMenu menu:formatMenuList){
            menu.setChildMenus(getChild(menu.getMenuId(),rootMenu));
        }
        return formatMenuList;
    }

    /**
     * 
     * @param menuList
     */
    public static void sortByWeight(List<SysMenu> menuList){
        SysMenu tempMenu;
        for(int i=0;i<menuList.size();i++){
            for(int j=i+1;j<menuList.size();j++){
                if(menuList.get(i).getWeight()<menuList.get(j).getWeight()){
                    tempMenu = menuList.get(j);
                    //menuList.get(j) = menuList.get(i)  ，
                    menuList.set(j,menuList.get(i));
                    menuList.set(i,tempMenu);
                }
            }
        }
    }
}
