package pkpd.restaurant.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SysMenu extends BaseBean{
    /**
     * id
     */
    private Long menuId;
    /**
     *
     */
    private String menuName;
    /**
     * id
     */
    private Long parentId;
    /**
     * id
     */
    private Long parentIds;
    /**
     *
     */
    private Integer isShow;
    /**
     *
     */
    private String permission;
    /**
     *
     */
    private String menuHref;
    /**
     *
     */
    private String menuIcon;
    /**
     *
     */
    private Integer weight;
    /**
     *
     */
    private String description;
    /**
     *
     */
    private Map<String,Object> condition;
    /**
     *
     */
    private List<SysMenu> childMenus;
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentIds() {
        return parentIds;
    }

    public void setParentIds(Long parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getMenuHref() {
        return menuHref;
    }

    public void setMenuHref(String menuHref) {
        this.menuHref = menuHref;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getCondition() {
        if(condition==null){
            condition = new HashMap<String,Object>();
        }
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }

    public List<SysMenu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<SysMenu> childMenus) {
        this.childMenus = childMenus;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", parentId=" + parentId +
                ", parentIds=" + parentIds +
                ", isShow=" + isShow +
                ", permission='" + permission + '\'' +
                ", menuHref='" + menuHref + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                ", condition=" + condition +
                '}';
    }
}
