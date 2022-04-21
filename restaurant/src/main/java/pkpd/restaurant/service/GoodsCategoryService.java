package pkpd.restaurant.service;


import pkpd.restaurant.entity.GoodsCategory;

import java.util.List;

/**
 * 
 */
public interface GoodsCategoryService {
    /**
     * 
     *
     * @return
     */
    List<GoodsCategory> findAll();

    /**
     * id
     *
     * @param id
     * @return
     */
    GoodsCategory findById(Long id);

    /**
     * 
     *
     * @param category
     */
    void insert(GoodsCategory category);

    /**
     * 
     *
     * @param category
     */
    void update(GoodsCategory category);

    /**
     * id
     *
     * @param strIds
     */
    void deleteByIds(String strIds);
}
