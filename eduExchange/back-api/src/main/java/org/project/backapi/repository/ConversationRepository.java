package org.project.backapi.repository;

import org.project.backapi.domain.Conversation;
import org.project.backapi.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConversationRepository extends JpaRepository<Conversation ,Long> {
    Page<Conversation> findByMessagesContentContaining(String text, Pageable pageable);

    @Query("SELECT c FROM Conversation c JOIN c.messages m WHERE m.content LIKE %:text% AND (c.initiator = :currentUser OR c.receiver = :currentUser)")
    Page<Conversation> findByMessagesContainingUserInvolved(String text, User currentUser, Pageable pageable);


    Page<Conversation> findByInitiatorOrReceiver(User currentUser, Pageable pageable);

}
