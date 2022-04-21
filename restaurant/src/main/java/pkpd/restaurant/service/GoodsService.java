package pkpd.restaurant.service;

import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Goods;

public interface GoodsService {
    /**
     * 
     *
     * @param pageInfo
     * @return
     */
    CustomPageInfo<Goods> findPage(CustomPageInfo<Goods> pageInfo);

    /**
     * goodsId
     *
     * @param goodsId
     * @return
     */
    Goods findById(Integer goodsId);

    /**
     * 
     *
     * @param goods
     */
    void insert(Goods goods);

    /**
     * 
     *
     * @param goods
     */
    void update(Goods goods);

    /**
     * id
     *
     * @param strIds
     */
    void deleteByIds(String strIds);
}
