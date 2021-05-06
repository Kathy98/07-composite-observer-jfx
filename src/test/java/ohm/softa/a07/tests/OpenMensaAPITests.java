package ohm.softa.a07.tests;

import ohm.softa.a07.api.OpenMensaAPI;
import ohm.softa.a07.model.Meal;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OpenMensaAPITests {

	private static final Logger logger = LogManager.getLogger(OpenMensaAPITests.class);
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
	private OpenMensaAPI openMensaAPI;

	//@BeforeAll
	@BeforeEach
	void setup() {

		// use this to intercept all requests and output them to the logging facilities
		HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
		loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

		OkHttpClient client = new OkHttpClient.Builder()
			.addInterceptor(loggingInterceptor)
			.build();

		Retrofit retrofit = new Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl("https://openmensa.org/api/v2/")
			.client(client)
			.build();

		openMensaAPI = retrofit.create(OpenMensaAPI.class);
	}

	private static Date getUpcomingMondayDate() {
		Calendar cal = Calendar.getInstance();
		while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		return cal.getTime();
	}

	/* Complete the test in the class OpenMensaAPITests
	   to ensure that your implementation is working correctly. */
	@Test
	void testGetMeals() throws IOException {
		// TODO prepare call
		/* create a call to get all meals of the current day */
		Call<List<Meal>> mealsCall = openMensaAPI.getMeals(dateFormat.format(getUpcomingMondayDate()));

		// TODO execute the call synchronously
		/* execute the call synchronous */
		Response<List<Meal>> mealsResponse = null;
		try {
			mealsResponse = mealsCall.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// TODO unwrap the body
		/* unwrap the response */
		List<Meal> meals = mealsResponse.body();

		assertNotNull(meals);
		assertNotEquals(0, meals.size());

		for(Meal m : meals){
			logger.info(m.toString());
		}
	}

}
