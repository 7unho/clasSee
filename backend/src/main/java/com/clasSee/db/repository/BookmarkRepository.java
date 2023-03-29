package com.clasSee.db.repository;

import com.clasSee.db.entity.user.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)    @Query("DELETE FROM Bookmark WHERE userId = :userId AND lessonId = :lessonId")
    void removeBookmark(Long userId, Long lessonId);
}
