package repositories;

import models.CommentPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by acer-pc on 08.03.2017.
 */
public interface CommentPhotoRepository extends JpaRepository<CommentPhoto, Integer> {
}
