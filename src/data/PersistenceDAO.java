package data;

import java.time.LocalDate;
import java.util.List;

import entities.User;


/*
 * This blueprint which provides context for persisting GitStacked web application
 */

public interface PersistenceDAO {

	User createNewUser(User user);
	User persistUser(User user);
	int getUserIdByUsername(String username);
	User login(User user);
	int getExerciseIdByName(String name);
	List<User> getAllUsers();
	void removeWorkout(int id);
	void removeWorkoutExercise(int id);
	int compareDate(LocalDate otherDate);

		
}
