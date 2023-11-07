package org.project.backapi.repository;

import org.project.backapi.domain.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation ,Long> {
}
