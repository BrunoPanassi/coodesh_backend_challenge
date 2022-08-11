package com.springbootapp.codeeshbackendchallenge.repository;

import com.springbootapp.codeeshbackendchallenge.model.Launcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LauncherRepo extends JpaRepository<Launcher, Long> {

    @Query("SELECT l FROM Launcher l")
    Page<Launcher> getPagedLaunchers(Pageable pageable);

    @Query("SELECT l FROM Launcher l WHERE l.id = :launcherId")
    Launcher getLauncherById(@Param("launcherId") String launcherId);

    @Query("DELETE Launcher WHERE id = :launcherId") @Modifying
    void deleteLauncherById(@Param("launcherId") String launcherId);
}
