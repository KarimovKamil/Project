package ru.itis.inform.dao.impl;

import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.DiscountCardDao;
import ru.itis.inform.models.DiscountCard;

import java.util.List;

/**
 * Created by Kamil Karimov on 29.11.2016.
 */
@Repository
public class DiscountCardDaoImpl implements DiscountCardDao {

    @Override
    public int saveDiscountCard(DiscountCard discountCard) {
        return 0;
    }

    @Override
    public void deleteDiscountCard(int id) {

    }

    @Override
    public void deleteDiscountCard(DiscountCard discountCard) {

    }

    @Override
    public DiscountCard getDiscountCardById(int id) {
        return null;
    }

    @Override
    public List<DiscountCard> getAll() {
        return null;
    }
}
