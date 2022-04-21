package pkpd.restaurant.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.dao.DeskDao;
import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Desk;
import pkpd.restaurant.exception.CustomException;
import pkpd.restaurant.service.DeskService;
import pkpd.restaurant.utils.SplitIdsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:LiuJing
 * Date:2018/10/22
 * Time:15:09
 *
 * 
 */
@Service
@Transactional
public class DeskServiceImpl implements DeskService {
    @Autowired
    private DeskDao deskDao;
    /**
     * ()
     * @return
     */
    @Override
    public CustomPageInfo<Desk> findPage(CustomPageInfo<Desk> pageInfo) {
        Page page = PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        //，page
        deskDao.findPage(pageInfo.getT());
        CustomPageInfo<Desk> resultInfo = new CustomPageInfo<>(page);
        return resultInfo;
    }
    /**
     * id
     * @param id
     * @return
     */
    @Override
    public Desk findById(Integer id) {
        return deskDao.findById(id);
    }


    /**
     *
     * @param desk
     */
    @Override
    public void insert(Desk desk) {
        Desk findDesk = deskDao.findByDeskCode(desk);
        if(findDesk!=null){
            throw new CustomException(ResultEnum.DESK_CODE_IS_EXIST);
        }
        desk.setCreateTime(new Date());
        deskDao.insert(desk);
    }

    /**
     * 
     * @param desk
     */
    @Override
    public void update(Desk desk) {
        Desk findDesk = deskDao.findByDeskCode(desk);
        if(findDesk!=null){
            throw new CustomException(ResultEnum.DESK_CODE_IS_EXIST);
        }
        desk.setModifyTime(new Date());
        deskDao.update(desk);
    }

    /**
     * id
     * @param strIds
     */
    @Override
    public void deleteByIds(String strIds) {
        List<Integer> idList = SplitIdsUtil.splitStrIdsByInt(strIds);
       int effect =  deskDao.deleteByIds(idList);
       if(effect<=0){
           throw new CustomException(ResultEnum.DEL_DB_FAIL);
       }
    }

    /**
     * 
     * @param desk
     * @return
     */
    @Override
    public Desk findByDeskCode(Desk desk) {
        return deskDao.findByDeskCode(desk);
    }

    /**
     * 
     * @param desk
     */
    @Override
    public void login(Desk desk) {
       Desk findDesk =  deskDao.findByDeskCode(desk);
       if(findDesk==null){
           throw new CustomException(ResultEnum.DESK_CODE_NO_EXIST);
       }
       if(findDesk.getIdleStatus()==1||findDesk.getIdleStatus()==2){
           throw new CustomException(ResultEnum.DESK_CODE_NO_IDLE);
       }
       //
       desk.setIdleStatus(1);
       deskDao.update(desk);
    }

    @Override
    public void logout(Desk desk){
        //0
        desk.setIdleStatus(0);
        deskDao.update(desk);
    }
}
