package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.DiscountCard;

import java.util.List;

/**
 * Created by Kamil Karimov on 29.11.2016.
 */
public interface DiscountCardDao {

    int saveDiscountCard(DiscountCard discountCard);

    void deleteDiscountCard(int id);

    void updateDiscountCard(DiscountCard discountCard);

    DiscountCard getDiscountCardById(int id);

    List<DiscountCard> getAll();
}
