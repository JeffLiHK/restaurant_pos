package pkpd.restaurant.service.Impl;

import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.dao.GoodsCategoryDao;

import pkpd.restaurant.entity.GoodsCategory;
import pkpd.restaurant.exception.CustomException;
import pkpd.restaurant.service.GoodsCategoryService;
import pkpd.restaurant.utils.SplitIdsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * 
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    @Autowired
    private GoodsCategoryDao goodsCategoryDao;
    /**
     * 
     * @return
     */
    @Override
    public List<GoodsCategory> findAll(){
        return goodsCategoryDao.findAll();
    }

    /**
     * id
     * @param id
     * @return
     */
    @Override
    public GoodsCategory findById(Long id) {
        return goodsCategoryDao.findById(id);
    }

    /**
     * 
     * @param goodsCategory
     */
    @Override
    public void insert(GoodsCategory goodsCategory) {
        GoodsCategory result = goodsCategoryDao.findByCategoryName(goodsCategory);
        if(result!=null){
            throw new CustomException(ResultEnum.CATEGORY_NAME_IS_EXIST);
        }
        goodsCategoryDao.insert(goodsCategory);
    }

    /**
     * 
     * @param goodsCategory
     */
    @Override
    public void update(GoodsCategory goodsCategory) {
        GoodsCategory result = goodsCategoryDao.findByCategoryName(goodsCategory);
        if(result!=null){
            throw new CustomException(ResultEnum.CATEGORY_NAME_IS_EXIST);
        }
        goodsCategoryDao.update(goodsCategory);
    }

    /**
     * id
     * @param strIds
     */
    @Override
    public void deleteByIds(String strIds) {
        List<Long> idList = SplitIdsUtil.splitStrIds(strIds);
        goodsCategoryDao.deleteByIds(idList);
    }
}
