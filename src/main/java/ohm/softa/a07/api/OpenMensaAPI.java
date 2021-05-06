package ohm.softa.a07.api;

import ohm.softa.a07.model.Meal;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * api.OpenMensaAPI is the interface that should describe the service; used by Retrofit
 * The OpenMensa API is an API to retrieve the menu of a certain day of a certain canteen.
 * In the previous assignment, we used Retrofit to interact with the API.
 * This time, we will use it again -- but don't worry you won't have to implement
 * any TypeAdapters or anything else, it's straight forward this time.
 *
 * Add the method getMeals to the interface OpenMensaAPI (as shown in the UML).
 * Make sure to use the correct annotations to make the proper call.
 */

public interface OpenMensaAPI {
	// TODO add method to get meals of a day
	// example request: GET /canteens/229/days/2017-11-22/meals
	// Call<List<Meal>> getMeals(String date);
	// Zurück kommt ein Call einer Liste von Meals
	@GET("canteens/256/days/{date}/meals")
	Call<List<Meal>> getMeals(@Path("date") String date);
}
