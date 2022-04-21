package pkpd.restaurant.service.Impl;

import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.dao.MemberCategoryDao;
import pkpd.restaurant.entity.MemberCategory;
import pkpd.restaurant.exception.CustomException;
import pkpd.restaurant.service.MemberCategoryService;
import pkpd.restaurant.utils.SplitIdsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MemberCategoryServiceImpl implements MemberCategoryService {
    @Autowired
    private MemberCategoryDao memberCategoryDao;
    /**
     * 
     * @return
     */
    @Override
    public List<MemberCategory> findAll() {
        return memberCategoryDao.findAll();
    }
    /**
     * id
     * @param id
     * @return
     */
    @Override
    public MemberCategory findById(Long id) {
        return memberCategoryDao.findById(id);
    }
    /**
     *
     * @param memberCategory
     */
    @Override
    public void insert(MemberCategory memberCategory) {
        MemberCategory result = memberCategoryDao.findByMcName(memberCategory);
        if(result!=null){
            throw new CustomException(ResultEnum.MC_NAME_IS_EXIST);
        }
        memberCategory.setCreateTime(new Date());
        memberCategoryDao.insert(memberCategory);
    }

    /**
     * 
     * @param memberCategory
     */
    @Override
    public void update(MemberCategory memberCategory) {
        MemberCategory result = memberCategoryDao.findByMcName(memberCategory);
        if(result!=null){
            throw new CustomException(ResultEnum.MC_NAME_IS_EXIST);
        }
        memberCategory.setModifyTime(new Date());
        memberCategoryDao.update(memberCategory);
    }

    /**
     * id
     * @param strIds
     */
    @Override
    public void deleteByIds(String strIds) {
        List<Long> idList = SplitIdsUtil.splitStrIds(strIds);
        memberCategoryDao.deleteByIds(idList);
    }
}
