package pkpd.restaurant.service;

import pkpd.restaurant.entity.MemberCategory;

import java.util.List;

public interface MemberCategoryService {
    /**
     * 
     * @return
     */
    List<MemberCategory> findAll();

    /**
     * id
     * @param id
     * @return
     */
    MemberCategory findById(Long id);

    /**
     *
     * @param memberCategory
     */
    void insert(MemberCategory memberCategory);

    /**
     * 
     * @param memberCategory
     */
    void update(MemberCategory memberCategory);

    /**
     * id
     * @param strIds
     */
    void deleteByIds(String strIds);
}
