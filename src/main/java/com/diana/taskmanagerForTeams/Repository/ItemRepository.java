package com.diana.taskmanagerForTeams.Repository;

import com.diana.taskmanagerForTeams.Domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
