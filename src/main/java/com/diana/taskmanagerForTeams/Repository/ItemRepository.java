package com.diana.taskmanagerForTeams.Repository;

import com.diana.taskmanagerForTeams.DTO.ItemDTO;
import com.diana.taskmanagerForTeams.Domain.Item;
import com.diana.taskmanagerForTeams.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findByUserAssign (User user);
    long countItemsBoughtByUserAssign (User user);
    List<Item> findByUserAssignAndPurchaseTrue(User user);
}
