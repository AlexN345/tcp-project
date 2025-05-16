package com.example.myapp.repository;


import com.example.myapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface Task_rep extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE t.clientInGroup.group.groupId = :groupId")
    List<Task> findByGroupId(@Param("groupId") Long groupId);

    @Query("SELECT t FROM Task t WHERE t.clientInGroup.group.groupId = :groupId AND t.date BETWEEN :start AND :end")
    List<Task> findByGroupIdAndDateRange(
            @Param("groupId") Long groupId,
            @Param("start") LocalDate start,
            @Param("end") LocalDate end
    );
    @Query("SELECT t FROM Task t WHERE t.clientInGroup.group.groupId = :groupId AND t.date= :dat")
    List<Task> findByGroupIdAndDate(
            @Param("groupId") Long groupId,
            @Param("dat") LocalDate start
    );

}
