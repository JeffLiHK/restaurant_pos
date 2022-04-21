package pkpd.restaurant.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.dao.GoodsDao;
import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Goods;
import pkpd.restaurant.exception.CustomException;
import pkpd.restaurant.service.GoodsService;
import pkpd.restaurant.utils.SplitIdsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    /**
     * 
     *
     * @param pageInfo
     * @return
     */
    @Override
    public CustomPageInfo<Goods> findPage(CustomPageInfo<Goods> pageInfo) {
        Page page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        Goods goods = (Goods) pageInfo.getT();
        if (goods.getGoodsCategory() != null) {
            if (goods.getGoodsCategory().getCategoryId() != null) {
                //
                if (goods.getGoodsCategory().getCategoryId() == -2) {
                    goods.getGoodsCategory().setCategoryId(null);
                    goods.setTypeState(2);
                    //
                }else if (goods.getGoodsCategory().getCategoryId() == -1) {
                    goods.getGoodsCategory().setCategoryId(null);
                    goods.setTypeState(3);
                }
            }
        }
        //，page
        goodsDao.findPage(goods);
        //，page
        CustomPageInfo<Goods> resultInfo = new CustomPageInfo<>(page);
        return resultInfo;
    }

    /**
     * goodsId
     *
     * @param goodsId
     * @return
     */
    @Override
    public Goods findById(Integer goodsId) {
        return goodsDao.findById(goodsId);
    }

    /**
     * 
     *
     * @param goods
     */
    @Override
    public void insert(Goods goods) throws CustomException {
        Goods findGoods = goodsDao.findByGoodsName(goods);
        if (findGoods != null) {
            throw new CustomException(ResultEnum.GOODS_NAME_IS_EXIST);
        }
        goods.setCreateTime(new Date());
        goodsDao.insert(goods);
    }

    /**
     * 
     *
     * @param goods
     */
    @Override
    public void update(Goods goods) {
        Goods findGoods = goodsDao.findByGoodsName(goods);
        if (findGoods != null) {
            throw new CustomException(ResultEnum.GOODS_NAME_IS_EXIST);
        }
        goods.setModifyTime(new Date());
        goodsDao.update(goods);
    }

    /**
     * id
     *
     * @param strIds
     */
    @Override
    public void deleteByIds(String strIds) {
        List<Integer> idList = SplitIdsUtil.splitStrIdsByInt(strIds);
        int effect = goodsDao.deleteByIds(idList);
        if (effect <= 0) {
            throw new CustomException(ResultEnum.DEL_DB_FAIL);
        }
    }
}
