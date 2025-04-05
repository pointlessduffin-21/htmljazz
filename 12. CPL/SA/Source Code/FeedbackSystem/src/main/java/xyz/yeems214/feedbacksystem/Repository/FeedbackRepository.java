package xyz.yeems214.feedbacksystem.Repository;

import xyz.yeems214.feedbacksystem.Entity.Feedback;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
}
