package pkpd.restaurant.service;

import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Desk;

/**
 * Created with IDEA
 * author:Jeff Li
 * Date:2020/10/2
 * Time:15:09
 *
 * 
 */

public interface DeskService {
    /**
     * ()
     * @return
     */
    CustomPageInfo<Desk> findPage(CustomPageInfo<Desk> pageInfo);

    /**
     * id
     * @param id
     * @return
     */
    Desk findById(Integer id);

    /**
     *
     * @param desk
     */
    void insert(Desk desk);

    /**
     * 
     * @param desk
     */
    void update(Desk desk);

    /**
     * id
     * @param strIds
     */
    void deleteByIds(String strIds);

    /**
     * 
     * @param desk
     * @return
     */
    Desk findByDeskCode(Desk desk);

    /**
     * 
     * @param desk
     */
    void login(Desk desk);

    /**
     * 
     * @param desk
     */
    void logout(Desk desk);
}
